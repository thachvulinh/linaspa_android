package com.example.linaspa.login;

import android.text.TextUtils;

public class Login {
    private String UserName;
    private String Password;

    public Login(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public boolean isValiUserName(){
        return  !TextUtils.isEmpty(UserName)  ;
    }
    public boolean isValiPassword(){
        return  !TextUtils.isEmpty(Password) ;
    }
}
