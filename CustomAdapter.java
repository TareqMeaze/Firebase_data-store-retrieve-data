package com.meaze.database;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Student> {

    private Activity context;
    private List<Student> studentList;

    public CustomAdapter( Activity context,  List<Student> studentList) {
        super(context, R.layout.item_xml, studentList);
        this.context = context;
        this.studentList = studentList;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.item_xml,null,true);

        Student student = studentList.get(position);

        TextView tvName= view.findViewById(R.id.tvName);
        TextView tvAge = view.findViewById(R.id.tvAge);

        tvName.setText(" Name : "+student.getName());
        tvAge.setText("Age :"+student.getAge()+" Years");

        return view;
    }
}
