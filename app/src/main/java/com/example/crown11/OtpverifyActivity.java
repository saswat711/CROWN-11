package com.example.crown11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OtpverifyActivity extends AppCompatActivity {
EditText phonenumberet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverify);
        phonenumberet = findViewById(R.id.EtPhoneNumberOtp);
       Bundle way =getIntent().getExtras();
       String methodFrom = way.getString("method");
       if (methodFrom.equals("SignUp")){
           String PhoneNo= way.getString("PhoneNo");
           phonenumberet.setText(PhoneNo);
       }

    }

    public void OnVerify(View view) {
    }

    public void OnSendOtp(View view) {
    }
}