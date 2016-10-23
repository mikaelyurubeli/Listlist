package com.apps.mikael.listlist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable{

    private ListView lv;
    private TextView emptyTextView;
    static ArrayList<Student> studentList;
    CustomStudentAdapter customStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyTextView = (TextView) findViewById(R.id.emptyTextView);
        lv = (ListView) findViewById(R.id.listView);

        if(studentList == null) studentList = new ArrayList<Student>();
        customStudentAdapter = new CustomStudentAdapter(this, studentList);
        lv = (ListView) findViewById(R.id.listView);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student listStudent = studentList.get(position);
                Intent i = new Intent(getApplicationContext(), Edit_student.class);
                i.putExtra("listlist", listStudent);
                i.putExtra("position", position);
                startActivity(i);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.view);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Add_Student.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView emptyempty = (TextView) findViewById(R.id.emptyTextView);
        if(studentList.size() == 0){
            customStudentAdapter = new CustomStudentAdapter(this, new ArrayList<Student>());
            lv.setEmptyView(emptyempty);
            emptyempty.setText("Student Not Found!");
        } else {
            customStudentAdapter = new CustomStudentAdapter(this, studentList);
            emptyempty.setText("");
        } lv.setAdapter(customStudentAdapter);
    }

    private void clear(){
        studentList.clear();
        customStudentAdapter = new CustomStudentAdapter(this, studentList);
        lv.setAdapter(customStudentAdapter);
    }

    private void PopulateStudentList(){
        studentList.add(new Student(studentList.size() + 1, "3145136196", "Mikael Yurubeli", "mikaelyuru@gmail.com", "087875076738"));
        studentList.add(new Student(studentList.size() + 1, "3145136228", "Gregorius Andito", "anditoherjuno@gmail.com", "08787123123"));
        studentList.add(new Student(studentList.size() + 1, "3145136228", "Agustinus Purimbaga", "agus_purim@gmail.com", "081277590214"));
        customStudentAdapter = new CustomStudentAdapter(this, studentList);
        lv.setAdapter(customStudentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu_student_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case (R.id.create_dummy):
                PopulateStudentList();
                return true;
            case (R.id.clear_list):
                clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
