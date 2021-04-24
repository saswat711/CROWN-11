package com.example.crown11.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.crown11.R;

public class OtpverifyActivity extends AppCompatActivity {
EditText phonenumberet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverify);
        phonenumberet = findViewById(R.id.EtPhoneNumberOtp);
       Bundle way =getIntent().getExtras();
       String phoneno = way.getString("PhoneNo");
       phonenumberet.setText(phoneno);

    }

    public void OnVerify(View view) {
    }

    public void OnSendOtp(View view) {
    }
}