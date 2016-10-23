package com.apps.mikael.listlist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Edit_student extends AppCompatActivity {

    EditText eno, enoreg, enama, eemail, etelp;
    public static ArrayList<Student> studentList;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        studentList = MainActivity.studentList;

        enoreg = (EditText) findViewById(R.id.enoreg);
        enama = (EditText) findViewById(R.id.enama);
        eemail = (EditText) findViewById(R.id.eemail);
        etelp = (EditText) findViewById(R.id.etelp);

        Student parsing = (Student) getIntent().getSerializableExtra("listlist");
        enoreg.setText(parsing.getNoreg());
        enama.setText(parsing.getNama());
        eemail.setText(parsing.getEmail());
        etelp.setText(parsing.getTelp());

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.btnDone);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.btnDel);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void save(){
        String b2 = enoreg.getText().toString();
        String b3 = enama.getText().toString();
        String b4 = eemail.getText().toString();
        String b5 = etelp.getText().toString();
        Student student = new Student(studentList.size() - (studentList.size()-1), b2, b3, b4, b5);
        studentList.set(position, student);
        finish();

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_delete_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_student:
                for (int i = position + 1; i < studentList.size(); i++){
                    studentList.get(position + 1).setNo(i);
                }
                position = getIntent().getIntExtra("position", 0);
                studentList.remove(position);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            default :
                return super.onOptionsItemSelected(item);
        }

    }
}
