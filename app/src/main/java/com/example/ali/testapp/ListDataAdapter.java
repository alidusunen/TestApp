package com.example.ali.testapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler {

        TextView tag, category, user;

    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        LayoutHandler layoutHandler;

        if(row == null){

            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.tag = (TextView) row.findViewById(R.id.tag_number);
            layoutHandler.category = (TextView) row.findViewById(R.id.category);
            layoutHandler.user = (TextView) row.findViewById(R.id.user_info);
            row.setTag(layoutHandler);
        }
        else {
             layoutHandler = (LayoutHandler) row.getTag();
        }

            DataProvider dataProvider = (DataProvider) this.getItem(position);
            layoutHandler.tag.setText(dataProvider.getTag());
            layoutHandler.category.setText(dataProvider.getCategory());
            layoutHandler.user.setText(dataProvider.getUser());

            return row;

    }
}
