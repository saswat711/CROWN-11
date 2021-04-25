package com.example.crown11.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.example.crown11.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpverifyActivity extends AppCompatActivity {

    EditText phonenumberet;
    String phoneno;
    String mVerificationId;
    PhoneAuthProvider.ForceResendingToken mResendToken;
    FirebaseAuth mAuth;
    SharedPreferences loggedin;
    public static final  String isLogin = "isLoginKey";

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

        mAuth = FirebaseAuth.getInstance();
        Bundle way =getIntent().getExtras();
        phoneno = way.getString("PhoneNo");
        phonenumberet.setText(phoneno);
        loggedin = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
    }

    public void OnVerify(View view) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId,"123456");
        signInWithPhoneAuthCredential(credential);
    }

    public void OnSendOtp(View view) {
        phoneno = phonenumberet.getText().toString();
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneno)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(PhoneAuthCredential credential) {
                                // This callback will be invoked in two situations:
                                // 1 - Instant verification. In some cases the phone number can be instantly
                                //     verified without needing to send or enter a verification code.
                                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                                //     detect the incoming verification SMS and perform verification without
                                //     user action.
                                Log.d("Aryan", "onVerificationCompleted:" + credential);

                                signInWithPhoneAuthCredential(credential);
                            }

                            @Override
                            public void onVerificationFailed(FirebaseException e) {
                                // This callback is invoked in an invalid request for verification is made,
                                // for instance if the the phone number format is not valid.
                                Log.w("Aryan", "onVerificationFailed", e);

                                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                    // Invalid request
                                } else if (e instanceof FirebaseTooManyRequestsException) {
                                    // The SMS quota for the project has been exceeded
                                }

                                // Show a message and update the UI
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId,
                                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                                // The SMS verification code has been sent to the provided phone number, we
                                // now need to ask the user to enter the code and then construct a credential
                                // by combining the code with a verification ID.
                                Log.d("Aryan", "onCodeSent:" + verificationId);

                                // Save verification ID and resending token so we can use them later
                                mVerificationId = verificationId;
                                mResendToken = token;

                            }
                        })          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Aryan", "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();
                            SharedPreferences.Editor editor = loggedin.edit();
                            editor.putBoolean(isLogin, true);
                            editor.apply();
                            startActivity(new Intent(OtpverifyActivity.this,ProfileScreen.class));
                            // Update UI
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w("Aryan", "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                            }
                        }
                    }
                });
    }
}