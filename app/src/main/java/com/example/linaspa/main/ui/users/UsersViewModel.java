package com.example.linaspa.main.ui.users;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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

public class UsersViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public UsersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is users");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void getData(String url, UsersAdapter adapter, ArrayList<Users> arrayUsers, Context context ){
        RequestQueue requestqueue= Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i < response.length(); i++){
                            try {
                                JSONObject object=response.getJSONObject(i);
                                arrayUsers.add(new Users(
                                        object.getInt("ID"),
                                        object.getString("Name"),
                                        object.getString("UserName"),
                                        object.getString("Password"),
                                        object.getString("Password_Show"),
                                        object.getString("Image"),
                                        object.getInt("Authorities"),
                                        object.getString("Date_Created")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestqueue.add(jsonArrayRequest);
    }
}
