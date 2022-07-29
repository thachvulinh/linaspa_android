package com.example.linaspa.main.ui.users;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Users {
    private int ID;
    private String Name;
    private String UserName;
    private String Password;
    private String Password_Show;
    private String Image;
    private int Authorities;
    private String Date_Created;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getPassword_Show() {
        return Password_Show;
    }

    public void setPassword_Show(String password_Show) {
        Password_Show = password_Show;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getAuthorities() {
        return Authorities;
    }

    public void setAuthorities(int authorities) {
        Authorities = authorities;
    }

    public String getDate_Created() {
        return Date_Created;
    }

    public void setDate_Created(String date_Created) {
        Date_Created = date_Created;
    }

    public Users(int ID, String name, String userName, String password, String password_Show, String image, int authorities, String date_Created) {
        this.ID = ID;
        Name = name;
        UserName = userName;
        Password = password;
        Password_Show = password_Show;
        Image = image;
        Authorities = authorities;
        Date_Created = date_Created;
    }

}
