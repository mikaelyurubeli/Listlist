package com.apps.mikael.listlist;

import java.io.Serializable;

/**
 * Created by Mikael on 10/7/2016.
 */
//Getter Setter
public class Student implements Serializable{

    public int no;
    public String noreg;
    public String nama;
    public String email;
    public String telp;

    public Student(int no, String noreg, String nama, String email, String telp){
        this.no = no;
        this.noreg = noreg;
        this.nama = nama;
        this.email = email;
        this.telp = telp;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNoreg() {
        return noreg;
    }

    public void setNoreg(String noreg) {
        this.noreg = noreg;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }
}
