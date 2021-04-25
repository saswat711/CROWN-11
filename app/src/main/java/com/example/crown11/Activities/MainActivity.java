package com.example.crown11.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.crown11.R;

public class MainActivity extends AppCompatActivity {
    protected EditText usernameet , passwordet;
    private String event="com.example.crown11.Activities.MainActivity";
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final  String isLogin = "isLoginKey";
    SharedPreferences loggedin;
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
        loggedin = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(loggedin.getBoolean(isLogin,true))
        {
            Intent autologinintent = new Intent(this, ProfileScreen.class);
            startActivity(autologinintent);
        }
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
        SharedPreferences.Editor editor = loggedin.edit();
        editor.putBoolean(isLogin, true);
        editor.apply();
        Intent loginintent = new Intent(this, ProfileScreen.class);
        startActivity(loginintent);
    }

    public void OnOtpLogin(View view) {
        Intent otpintent = new Intent(this,OtpverifyActivity.class);
        startActivity(otpintent);
    }

    public void onFaceBookLogin(View view) {
    }
}