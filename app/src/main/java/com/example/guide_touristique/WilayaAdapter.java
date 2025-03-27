package com.example.guide_touristique;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.BaseAdapter;

import java.util.List;

public class WilayaAdapter extends BaseAdapter {
    private Context context;
    private List<Wilaya> wilayas;

    public WilayaAdapter(Context context, List<Wilaya> wilayas) {
        this.context = context;
        this.wilayas = wilayas;
    }

    @Override
    public int getCount() {
        return wilayas.size();
    }

    @Override
    public Object getItem(int position) {
        return wilayas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_wilaya, parent, false);
        }

        TextView txtWilaya = convertView.findViewById(R.id.txtWilaya);
        Wilaya wilaya = wilayas.get(position);
        txtWilaya.setText(wilaya.getName() + " | " + wilaya.getArabicName());

        return convertView;
    }
}