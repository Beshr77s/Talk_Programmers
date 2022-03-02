package com.qashar.talkProgrammer;


import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import yuku.ambilwarna.AmbilWarnaDialog;
/*
* I used simple library for color picker you can found it in gradle
* */

public class SingleActivity extends AppCompatActivity implements FontFragment.BottomSheetListener{
   private TextView text;
   private CardView cardView;
    private LinearLayout layout,lk;
   private int i = 20;
    int default_color;
    Typeface typeface;
//    AdView mAdView;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);

//        AdView = (AdView) findViewById(R.id.adView22);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        AdView.loadAd(adRequest);
        insi();

        text.setTextSize(18);
        title.setText(getIntent().getExtras().getString("title"));
        text.setText(getIntent().getExtras().getInt("text"));
        SharedPreferences shard = getSharedPreferences("save",MODE_PRIVATE);
        String font = shard.getString("text","a");
        switch (font){
            case "":
                font ="d";
                break;

            case "a":
                typeface = Typeface.createFromAsset(getAssets(),"omar.ttf");
             text.setTypeface(typeface);
                break;
            case "b":
                typeface = Typeface.createFromAsset(getAssets(),"sogand.ttf");
            text.setTypeface(typeface);
                break;
            case "c":
                typeface = Typeface.createFromAsset(getAssets(),"am.ttf");
           text.setTypeface(typeface);
                break;
            case "d":
                typeface = Typeface.createFromAsset(getAssets(),"ge.otf");
           text.setTypeface(typeface);
                break;
            default:
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                break;
        }

        SharedPreferences color = getSharedPreferences("saveColor",MODE_PRIVATE);
        String ac=  color.getString("Title","");
        switch (ac){
            case "":
                break;
            default:
                int a = Integer.parseInt(ac);
                title.setTextColor(a);
                break;
        }
        SharedPreferences colrddd =getSharedPreferences("savecolorB",MODE_PRIVATE);
        String c = colrddd.getString("Back","");
        switch (c){
            case "":
                break;
            default:
                int a = Integer.parseInt(c);
                layout.setBackgroundColor(a);
                cardView.setBackgroundColor(a);
                break;
        }

        SharedPreferences preferences = getSharedPreferences("Color",MODE_PRIVATE);
         String colo = preferences.getString("txtColor","");
         switch (colo) {
             case "":
                 break;
             default:
                 int g = Integer.parseInt(colo);
                 text.setTextColor(g);
         }
    }

    private void insi() {
        lk = findViewById(R.id.linnnnnnn);
        title =  findViewById(R.id.titlle);
        text =  findViewById(R.id.text);
        cardView =  findViewById(R.id.card);
        layout = findViewById(R.id.linnn);
    }

    public void add(View view) {
        i++;
        text.setTextSize(i);
    }

    public void auo(View view) {
        i--;
        text.setTextSize(i);
    }

    public void onNormal(View view) {
        text.setTextSize(20);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.textcolormenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.changetextcolor:
                changTextColor();
                break;
            case R.id.fonts:
                FontFragment fontFragment = new FontFragment();
                fontFragment.show(getSupportFragmentManager(),"");
                break;
            case R.id.changTitle:
                changTitleColor();
                break;
            case R.id.changeBack:
                changBackground();
                break;
        }
        return true;
    }


    public void changTextColor() {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, default_color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                default_color = color;
                text.setTextColor(default_color);
               SharedPreferences colordd = getSharedPreferences("Color",MODE_PRIVATE);
               SharedPreferences.Editor eeditor = colordd.edit();
               eeditor.putString("txtColor",default_color+"");
               eeditor.apply();
            }
        });
        ambilWarnaDialog.show();
    }

    public void changTitleColor() {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, default_color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                default_color = color;
                title.setTextColor(default_color);
                SharedPreferences colordd = getSharedPreferences("saveColor",MODE_PRIVATE);
                SharedPreferences.Editor eeditor = colordd.edit();
                eeditor.putString("Title",default_color+"");
                eeditor.apply();
            }
        });
        ambilWarnaDialog.show();
    }

    public void changBackground() {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, default_color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                default_color = color;
                layout.setBackgroundColor(default_color);
                cardView.setBackgroundColor(default_color);
                lk.setBackgroundColor(default_color);
                SharedPreferences colrddd =getSharedPreferences("savecolorB",MODE_PRIVATE);
                 SharedPreferences.Editor editor = colrddd.edit();
                 editor.putString("Back",default_color+"");
                 editor.apply();
            }
        });
        ambilWarnaDialog.show();
    }

    @Override
    public void onButtonClicked(String text) {
        SharedPreferences shard = getSharedPreferences("save",MODE_PRIVATE);
        SharedPreferences.Editor editor = shard.edit();
        editor.putString("text",text);
        editor.apply();
        recreate();
    }






}