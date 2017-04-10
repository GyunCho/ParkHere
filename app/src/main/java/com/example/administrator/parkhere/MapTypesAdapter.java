package com.example.administrator.parkhere;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GyunCho on 4/9/17.
 */

public class MapTypesAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> mapTypes;

    public MapTypesAdapter(Context c, ArrayList<String> mapTypes) {
        this.context = c;
        this.mapTypes = mapTypes;
    }

    @Override
    public int getCount() {
        return mapTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return mapTypes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);

        textView.setText(mapTypes.get(position));

        if(mapTypes.get(position).equals("Visitor")) {
            textView.setBackgroundColor(Color.CYAN);
        }

        if(mapTypes.get(position).equals("Student")) {
            textView.setBackgroundColor(Color.GREEN);
        }

        if(mapTypes.get(position).equals("Faculty")) {
            textView.setBackgroundColor(Color.YELLOW);
        }


        return textView;
    }
}
