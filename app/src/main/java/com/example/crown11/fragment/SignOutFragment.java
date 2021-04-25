package com.example.crown11.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.crown11.Activities.MainActivity;
import com.example.crown11.Activities.ProfileScreen;
import com.example.crown11.R;

import java.util.Objects;

public class SignOutFragment extends Fragment  implements View.OnClickListener {
SharedPreferences loggedin;
    public static final  String isLogin = "isLoginKey";
     private static final String ARG_PARAM1 = "param1";
        private static final String ARG_PARAM2 = "param2";

    //    // TODO: Rename and change types of parameters
        private String mParam1;
        private String mParam2;

    public SignOutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_sign_out, container, false);
        Button confirm = rootview.findViewById(R.id.BtConfirm);
        Button cancel = rootview.findViewById(R.id.BtCancel);
        loggedin = this.requireActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

        return rootview;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.BtConfirm:
                SharedPreferences.Editor editor = loggedin.edit();
                editor.putBoolean(isLogin, false);
                editor.apply();
                String loggedout= null;
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra(loggedout,false);
                startActivity(intent);
            case R.id.BtCancel:
                Intent i = new Intent(getActivity(), ProfileScreen.class);
                startActivity(i);
        }
    }
}