package com.midlandstech.student.treywyates.fortunecookie;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    private Button[] buttons;
    private FortuneCookie fortunes = new FortuneCookie();
    private int selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        buildGuiByCode();
    }

    public void buildGuiByCode() {
        // Get width of the screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int x = size.x;
        int y = size.y / 7;

        // Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);
        gridLayout.setRowCount(6);
        gridLayout.setPadding(5, 5, 5, 5);

        // Create the buttons and add them to gridLayout
        buttons = new Button[6];
        ButtonHandler bh = new ButtonHandler();

        for (int row = 0; row < buttons.length; row++) {
            buttons[row] = new Button(this);
            buttons[row].setTextSize(20);
            buttons[row].setOnClickListener(bh);
            buttons[row].setPadding(0, 5, 0, 5);
            if (row == buttons.length - 1) {
                buttons[row].setText("Random Fortune");
                randomize(fortunes.randomFortune());
            }
            gridLayout.addView(buttons[row], x, y);
        }

        // Set gridLayout as the View of this Activity
        setContentView(gridLayout);
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            for (int i = 0; i < buttons.length; i++) {
                if (isButton(v, i)) {
                    selection = i;
                }
            }

            if (selection < buttons.length - 1) {
                buttons[selection].setText(fortunes.next(selection));
            } else {
                randomize(fortunes.randomFortune());
            }
        }
    }

    public boolean isButton(View b, int i) {
        return (b == buttons[i]);
    }

    public void randomize(String[] randoList) {
        for (int i = 0; i < buttons.length - 1; ++i) {
            buttons[i].setText(randoList[i]);
        }
    }
}
