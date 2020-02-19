package com.midlandstech.student.treywyates.fortunecookie;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    //Array for the buttons
    private Button[] buttons;

    //Instance of our model
    private FortuneCookie fortunes = new FortuneCookie();

    //Index of the button selected
    private int selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        buildGuiByCode();
    }
    //Builds our GUI through code instead of XML
    public void buildGuiByCode() {
        // Get width and height of screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int x = size.x;
        int y = size.y / 7;

        // Create a GridLayout to configure the buttons to
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);
        gridLayout.setRowCount(6);

        // Create the buttons and add them to gridLayout
        buttons = new Button[6];
        ButtonHandler bh = new ButtonHandler();

        for (int row = 0; row < buttons.length; row++) {
            buttons[row] = new Button(this);
            buttons[row].setTextSize(30);
            buttons[row].setOnClickListener(bh);
            //The last button is used for the random click
            if (row == buttons.length - 1) {
                buttons[row].setText("Random");
                randomize(fortunes.randomFortune());
            }
            gridLayout.addView(buttons[row], x, y);
        }

        // Set the gridLayout to the content View
        setContentView(gridLayout);
    }

    //onClick listener for when the buttons are pressed
    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {

            //Gets the index of which button was pressed
            for (int i = 0; i < buttons.length; i++) {
                if (isButton(v, i)) {
                    selection = i;
                }
            }

            //If it is a fortune button it calls the next()
            if (selection < buttons.length - 1) {
                buttons[selection].setText(fortunes.next(selection));
            } else {
                //Otherwise the random button was pressed and we call randomize()
                randomize(fortunes.randomFortune());
            }
        }
    }

    //Decides whether or not the button called is the one that was pressed
    public boolean isButton(View b, int i) {
        return (b == buttons[i]);
    }

    //Method to easily set each fortune buttons text to the random strings
    public void randomize(String[] randoList) {
        for (int i = 0; i < buttons.length - 1; ++i) {
            buttons[i].setText(randoList[i]);
        }
    }
}
