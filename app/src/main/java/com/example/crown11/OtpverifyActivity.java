package com.example.crown11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OtpverifyActivity extends AppCompatActivity {
EditText phonenumberet;

/* Work to do for Aryan

this activity is common for both login activity and veify otp for sign up


verify the otp when successful come back to this activity show the button Sign up and disable the verify otp button
save the username  phone number and  password on fire base
if the verification is successful than only store it

if verification not successful come back to show retry in this activity only t

 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverify);
        phonenumberet = findViewById(R.id.EtPhoneNumberOtp);


    }

    public void OnVerify(View view) {
    }

    public void OnSendOtp(View view) {
    }
}