package com.qashar.talkProgrammer;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    private List<Data> Datalist = null;
    private ArrayList<Data> arraylist;
    Context context;
//    RewardedVideoAd mahmad;
    public ListAdapter(Activity context, List<Data> openSite) {
        this.context=context;
        this.Datalist = openSite;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(openSite);
    }

    @Override
    public int getCount() {
        return Datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return Datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        View Item =inflater.inflate(R.layout.item, null,true);
        final TextView txtTitle =  Item.findViewById(R.id.titleid);//العنوان
        final TextView txtPart =  Item.findViewById(R.id.partid);//الفصل
        txtTitle.setText(Datalist.get(position).getTitle());
//        txtPart.setText(Datalist.get(position).getPart1());
        ImageView imageView = Item.findViewById(R.id.star_fav);

        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,SingleActivity.class);
                intent.putExtra("title",txtTitle.getText().toString());
                intent.putExtra("text",Datalist.get(position).getText());
                context.startActivity(intent);
            }
        });
        return Item;



    };



}
