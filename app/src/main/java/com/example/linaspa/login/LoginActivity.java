package com.example.linaspa.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.linaspa.R;
import com.example.linaspa.main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText ev_UserName,ev_Password;
    private TextView tv_Message;
    private Button btnLogin;
    String url_login = "http://192.168.1.11/honespa.atwebpages.com/api/admin/login";

    public static final String TAG = LoginActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ev_UserName=findViewById(R.id.ev_UserName);
        ev_Password=findViewById(R.id.ev_Password);
        tv_Message=findViewById(R.id.tv_Message);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickLogin();
            }
        });
    }
    public void ClickLogin(){
        String strUserName=ev_UserName.getText().toString().trim();
        String strPassword=ev_Password.getText().toString().trim();
        Login login=new Login(strUserName,strPassword);
        tv_Message.setVisibility(View.VISIBLE);
        Map<String,String> params=new HashMap<>();
        params.put("UserName",strUserName);
        params.put("Password",strPassword);
        JSONObject parameters = new JSONObject(params);
        if(login.isValiUserName() && login.isValiPassword() ){
            RequestQueue requestqueue= Volley.newRequestQueue(this);
            JsonObjectRequest jsonArrayRequest=new JsonObjectRequest(Request.Method.POST, url_login,parameters,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if(response.getInt("result")==1) {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                } else{
                                    tv_Message.setText(response.getString("notification").toString());
                                    tv_Message.setTextColor(getResources().getColor(com.google.android.material.R.color.design_dark_default_color_secondary));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                            Log.e(TAG, error.toString());
                            tv_Message.setText(error.toString());
                        }
                    }
            );
            requestqueue.add(jsonArrayRequest);
        }
        else{
            tv_Message.setText("Email or password invalid");
            tv_Message.setTextColor(getResources().getColor(com.google.android.material.R.color.design_dark_default_color_secondary));
        }
    }
}