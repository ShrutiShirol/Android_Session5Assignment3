package com.mobilerepair.app.contextmenu53;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Santoshraddi on 22-02-2017.
 */
public class PersonAdapter extends BaseAdapter {

    ArrayList<Person> mArrayList;
    LayoutInflater mLayoutInflater;

    public PersonAdapter(Context context, ArrayList<Person> mArrayList) {
        this.mArrayList=mArrayList;
        this.mLayoutInflater=LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=mLayoutInflater.inflate(R.layout.customlistview,parent,false);

        Person student= (Person) getItem(position);

        TextView name=(TextView)convertView.findViewById(R.id.name);
        TextView phone1=(TextView)convertView.findViewById(R.id.phone);

        name.setText(student.getName());

        phone1.setText(String.valueOf(student.getPhone()));

        return convertView;
    }
}

