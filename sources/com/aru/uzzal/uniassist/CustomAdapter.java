package com.aru.uzzal.uniassist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] flags;
    private LayoutInflater inflater;
    String[] uniname;

    CustomAdapter(Context context2, String[] uniname2, int[] flags2) {
        this.context = context2;
        this.uniname = uniname2;
        this.flags = flags2;
    }

    public int getCount() {
        return this.uniname.length;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            view = this.inflater.inflate(C0457R.layout.university, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(C0457R.C0459id.uname);
        ((ImageView) view.findViewById(C0457R.C0459id.unilogo)).setImageResource(this.flags[i]);
        textView.setText(this.uniname[i]);
        return view;
    }
}
