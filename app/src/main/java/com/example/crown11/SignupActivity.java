package com.example.crown11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
EditText phonenoet;


/* Work to do for Aryan
get the username  phone number and  password

When user click verify otp send to OtpVerifyActivity

When otp verify successful come back to this activity show the button Sign up and disable the verify otp button
save the username  phone number and  password on fire base
save the phoneno given on the otp verify activity
if the verification is successful than only store it

if verification not successful show retry in verify activity only

 */

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
        startActivity(otpintent);
    }

}