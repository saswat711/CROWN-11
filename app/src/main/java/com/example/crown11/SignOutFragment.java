package com.example.crown11;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignOutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignOutFragment extends Fragment  implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button confirm, cancel;

    public SignOutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignOutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignOutFragment newInstance(String param1, String param2) {
        SignOutFragment fragment = new SignOutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_sign_out, container, false);
        Button confirm = rootview.findViewById(R.id.BtConfirm);
        Button cancel = rootview.findViewById(R.id.BtCancel);
        return rootview;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.BtConfirm:
                String loggedout= null;
                Intent intent = new Intent(getActivity(),MainActivity.class);
                intent.putExtra(loggedout,false);
                startActivity(intent);
            case R.id.BtCancel:
                Intent i = new Intent(getActivity(),ProfileScreen.class);
                startActivity(i);
        }
    }
}