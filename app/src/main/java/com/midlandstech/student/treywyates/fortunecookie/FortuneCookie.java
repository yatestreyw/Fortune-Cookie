package com.midlandstech.student.treywyates.fortunecookie;

import android.util.Log;

import java.util.Random;

//Implements the Fortune Cookie model for the application
public class FortuneCookie {
    //Lists of all the different fortune
    private String[] list0 = {"You", "Your neighbor", "Your spouse", "A family member", "A stranger"};
    private String[] list1 = {"Will", "May", "Cannot", "Must", "Should"};
    private String[] list2 = {"Lose", "Gain", "Obtain", "Find", "Experience"};
    private String[] list3 = {"A great fortune", "A shiny car", "A nice day", "A tragic accident", "A new love"};
    private String[] list4 = {"Soon", "Tomorrow", "Never", "Always", "Eventually"};

    //A list of all of the fortune lists
    private String[][] fortuneList;

    //A list to keep track of each lists current fortune index
    private int[] current;

    //Instantiates the lists
    public FortuneCookie() {
        fortuneList = new String[][]{list0, list1, list2, list3, list4};
        current = new int[5];
    }

    //Returns the next string in the list in regard to the index parameter provided
    public String next(int i) {

        // Increment the current string (No ++ because it was not providing correct results)
        current[i] += 1;

        //Set current back to zero to avoid outOfBounds exceptions if it becomes over length
        if (current[i] == fortuneList.length) {
            current[i] = 0;
        }
        //Return the string at the current index from the parameterized index list
        return fortuneList[i][current[i] % fortuneList.length];
    }

    //Randomizes the fortunes and returns the randomized array
    public String[] randomFortune() {
        String[] randoList = new String[5];
        Random   random = new Random();
        int randoIndex;

        //Changes each list's string to a random index and saves each index in current[]
        for (int i = 0; i < fortuneList.length; ++i) {
            randoIndex = random.nextInt(5);
            current[i] = randoIndex;
            randoList[i] = fortuneList[i][randoIndex];
            //Log to see each index each list is randomized to
            Log.w("MainActivity", "" + randoIndex);
        }
        return randoList;
    }


}
