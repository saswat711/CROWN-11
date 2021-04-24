package com.example.crown11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    protected EditText usernameet , passwordet;
    private String event="com.example.crown11.MainActivity";

    /* Work to do for Aryan

    Add function to the login button Show that it goes to profile screen on successful
   store the user name and phone number as it would be used on profile screen and pass it as extras for
   profile screen

Add function to the facebook login and make store the user name and pass it as extras for
profile screen

   change code for sign up activity and login activity

     */

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
        Intent loginintent = new Intent(this,ProfileScreen.class);
        startActivity(loginintent);
    }

    public void OnOtpLogin(View view) {
        Intent otpintent = new Intent(this,OtpverifyActivity.class);

        startActivity(otpintent);
    }
}