package com.example.e_cell_inductions;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {
    private String username;
    private long phoneno;
    private LocalDate dob;
    private String password;
    private String email;
    static ArrayList<Data> database = new ArrayList<>();

    Data(String username,long phoneno,LocalDate dob,String password,String email){
        this.username = username;
        this.phoneno = phoneno;
        this.dob = dob;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(long phoneno) {
        this.phoneno = phoneno;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
