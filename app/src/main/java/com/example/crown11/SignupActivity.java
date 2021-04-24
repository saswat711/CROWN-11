package com.example.crown11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
EditText phonenoet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        phonenoet = findViewById(R.id.EtSignPhoneNo);
    }

    public void OnSignUp(View view) {
    }

    public void OnOtpVerify(View view) {
        Intent otpintent = new Intent(this,OtpverifyActivity.class);
        String PhoneNo = "inputno";
        otpintent.putExtra(PhoneNo,phonenoet.getText().toString());
        startActivity(otpintent);
    }

}