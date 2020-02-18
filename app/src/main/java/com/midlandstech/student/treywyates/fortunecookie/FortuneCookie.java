package com.midlandstech.student.treywyates.fortunecookie;

import android.util.Log;

import java.util.Random;

public class FortuneCookie {
    private String[] list0 = {"You", "Your neighbor", "Your spouse", "A family member", "A stranger"};
    private String[] list1 = {"Will", "May", "Cannot", "Must", "Should"};
    private String[] list2 = {"Lose", "Gain", "Obtain", "Find", "Experience"};
    private String[] list3 = {"A great fortune", "A shiny car", "A nice day", "A tragic accident", "A new love"};
    private String[] list4 = {"Soon", "Tomorrow", "Never", "Always", "Eventually"};
    private String[][] fortuneList;
    private int[] current;

    public FortuneCookie() {
        fortuneList = new String[][]{list0, list1, list2, list3, list4};
        current = new int[5];
    }

    public String next(int i) {
        Log.w("MainActivity", "i = " + i);
        Log.w("MainActivity", "current[i] = " + current[i] % fortuneList.length);
        //Error errorea hehe *****
        current[i] = current[i] + 1;
        if (current[i] == fortuneList.length) {
            current[i] = 0;
        }
        return fortuneList[i][current[i] % fortuneList.length];
    }

    public String[] randomFortune() {
        String[] randoList = new String[5];
        Random   random = new Random();
        int randoIndex;

        for (int i = 0; i < fortuneList.length; ++i) {
            randoIndex = random.nextInt(5);
            current[i] = randoIndex;
            randoList[i] = fortuneList[i][randoIndex];
            Log.w("MainActivity", "" + randoIndex);
        }
        return randoList;
    }


}
