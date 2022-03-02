package com.qashar.talkProgrammer;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import yuku.ambilwarna.AmbilWarnaDialog;


/*
My First App ^-^
* Created By Beshr Qashar 2020/1/23
*This app for beginners and it need more develop
*like you can add favorites activity and many things as you want
 */
public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    int default_color;
//    AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mAdview = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        Ahmad.loadAd(adRequest)

        colorOfBackground();

    }

    private void colorOfBackground() {
        layout = findViewById(R.id.liner);//for change background color
        default_color=R.color.colorAccent;//default color
        layout.setBackgroundColor(Color.parseColor("#321E35"));//Saved color
        SharedPreferences shardBack = getSharedPreferences("back",MODE_PRIVATE);
        String color= shardBack.getString("color","");
        switch (color){
            case "":
                break;
            default:
                int vo = Integer.parseInt(color);
                layout.setBackgroundColor(vo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String goo="https://play.google.com/store/apps/details?id="+getPackageName();
        switch (item.getItemId()) {
            case R.id.my_apps:
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Beshr%20Qashar"));
                startActivity(i);
                break;
            case R.id.shre_appp:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_SUBJECT, "***");//Tilte
                intent.putExtra(Intent.EXTRA_TEXT, "****" +"\n"+goo);//Message
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Title"));
                break;
            case R.id.changecolor:
                changColor();
                break;
            case R.id.m_exit:
                onBackPressed();
                break;
        }


        return true;
    }

    @Override
    public void onBackPressed() {

     startActivity(new Intent(getApplicationContext(),EndActivity.class));
        finish();
    }


    public void changColor() {

        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, default_color, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                /*Its for you change what you want.
                * It was in the past i changed the app style*/


//                default_color = color;
//                layout.setBackgroundColor(default_color);
//               SharedPreferences shardBack = getSharedPreferences("back",MODE_PRIVATE);
//               SharedPreferences.Editor editor = shardBack.edit();
//               editor.putString("color",default_color+"");
//               editor.apply();

            }
        });ambilWarnaDialog.show();
    }

    public void info(View view) {
        //Info Fragment
        InfoFragment fragment = new InfoFragment();
        fragment.show(getSupportFragmentManager(),"");
    }

    public void share(View view) {
        Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_SUBJECT,"lllllll");
            intent.putExtra(Intent.EXTRA_TEXT,"ندعوك لتحميل تطبيق كلام مبرمجين \n" +
                    "https://play.google.com/store/apps/details?id="+getPackageName());
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent,"مشاركة تطبيق كلام مبرمجين"));
    }

    public void browserBook(View view) {
        startActivity(new Intent(getApplicationContext(),BrowserBook.class));
    }

    public void ratting(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));

    }
}
