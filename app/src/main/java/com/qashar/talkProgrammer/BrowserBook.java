package com.qashar.talkProgrammer;


import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import talkProgrammer.R;

public class BrowserBook extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Data> arraylist = new ArrayList<>();
    private ListAdapter adapter;

    //  private RewardedVideoAd mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_book);

        listView = findViewById(R.id.lv);


        /*
         * Here you will add your titles with texts you want to show it in the app
         * you can add from what you want like strings file or from code as you like
         * ^-^
         * Notice you have to add same quantities of titles and texts except that you will get error
         * */
        Integer[] TITLES = {R.string.title1, R.string.title2, R.string.title3};//you can add as you want .....R.string.****
//        Integer[] PART = {R.string.part1,....,.....}; // You add part if you want .....
        Integer[] TEXT = {R.string.text1, R.string.text2, R.string.text3};//you can add as you want ..... R.string.****
        for (int i = 0; i < TITLES.length; i++) {
            Data data = new Data(TITLES[i], TEXT[i]);
            arraylist.add(data);
        }
        adapter = new ListAdapter(this, arraylist);
        listView.setAdapter(adapter);
    }
}
