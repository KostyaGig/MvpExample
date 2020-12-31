package com.kostya.mvpsampleexample.model;

import android.text.TextUtils;

import org.w3c.dom.Text;

public class User {

    private String email;
    private String password;

    public User(){}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int isValidate(){
        if (TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            return 1;
        } else if (TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)){
            return 2;
        } else if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
            return 3;
        } else {
            return 0;
        }
    }

}
