package com.example.crown11.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.crown11.R;

public class MainActivity extends AppCompatActivity {
    protected EditText usernameet , passwordet;
    private String event="com.example.crown11.Activities.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameet=findViewById(R.id.EtLoginUserName);
        passwordet=findViewById(R.id.EtLoginPassword);
    }



    public void OnSignUp(View view) {
        Log.d(event,"Sign up Button Clicked");
        Intent signuptent = new Intent(this,SignupActivity.class);
        startActivity(signuptent);

    }

    public void OnLogin(View view) {
        String username = usernameet.getText().toString();
        String password = passwordet.getText().toString();
        Log.d(event,"Login Button Clicked");
        Intent loginintent = new Intent(this, ProfileScreen.class);
        startActivity(loginintent);
    }

    public void OnOtpLogin(View view) {
        Intent otpintent = new Intent(this,OtpverifyActivity.class);
        String PhoneNo = "";
        otpintent.putExtra(PhoneNo,"Login");
        startActivity(otpintent);
    }
}