package com.apps.mikael.listlist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Add_Student extends AppCompatActivity {

    EditText b1,b2,b3,b4,b5;
    public ArrayList<Student> student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        student = MainActivity.studentList;

        b2 = (EditText) findViewById(R.id.enoreg);
        b3 = (EditText) findViewById(R.id.enama);
        b4 = (EditText) findViewById(R.id.eemail);
        b5 = (EditText) findViewById(R.id.etelp);


        Intent i = getIntent();
        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.btnCancel);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.btnSave);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    public void save(){

        String bb2 = b2.getText().toString();
        String bb3 = b3.getText().toString();
        String bb4 = b4.getText().toString();
        String bb5 = b5.getText().toString();
        Student sv = new Student(
                student.size()+1,
                bb2,
                bb3,
                bb4,
                bb5);
        student.add(sv);
        finish();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}
