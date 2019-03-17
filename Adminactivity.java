package com.example.rishi.moviedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Adminactivity extends AppCompatActivity {
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminactivity);
        username=findViewById(R.id.user_text);
        password=findViewById(R.id.pass_text);
    }

    public void adminLogin(View view) {
        String user,pass;
        user=username.getText().toString();
        pass=password.getText().toString();
        if(user.isEmpty()){
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
        }
        if(pass.isEmpty()){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
        }
        if((user.equalsIgnoreCase("admin")) && (pass.equalsIgnoreCase("123"))){

        }
        else {
            Toast.makeText(this, "Invalid Username Or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
