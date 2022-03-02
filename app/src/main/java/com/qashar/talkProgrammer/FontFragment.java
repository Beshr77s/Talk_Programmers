package com.qashar.talkProgrammer;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FontFragment extends BottomSheetDialogFragment {
    private BottomSheetListener mListener;

    Typeface typeface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fonts,container,false);
        TextView t1 = view.findViewById(R.id.f1);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"omar.ttf");
        t1.setTypeface(typeface);
        TextView t2 = view.findViewById(R.id.f2);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"sogand.ttf");
        t2.setTypeface(typeface);
        TextView t3 = view.findViewById(R.id.f3);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"am.ttf");
        t3.setTypeface(typeface);
        TextView t4 = view.findViewById(R.id.f4);
        typeface = Typeface.createFromAsset(getActivity().getAssets(),"ge.otf");
        t4.setTypeface(typeface);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("a");
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("b");
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("c");
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("d");
            }
        });
        return view;

    }
    public interface BottomSheetListener {
        void onButtonClicked(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (BottomSheetListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
}
