package com.apps.mikael.listlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mikael on 10/7/2016.
 */
public class CustomStudentAdapter extends ArrayAdapter<Student>{
    public CustomStudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_student, parent, false);
        }

        TextView no = (TextView) convertView.findViewById(R.id.no);
        TextView noreg = (TextView) convertView.findViewById(R.id.noreg);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView email = (TextView) convertView.findViewById(R.id.email);
        TextView telp = (TextView) convertView.findViewById(R.id.telp);

        no.setText(student.no + "");
        noreg.setText(student.noreg);
        nama.setText(student.nama);
        email.setText(student.email);
        telp.setText(student.telp);

        return convertView;
    }
}
