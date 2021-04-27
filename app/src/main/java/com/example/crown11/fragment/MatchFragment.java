package com.example.crown11.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.crown11.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MatchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MatchFragment extends Fragment {
   protected int randomNumber;
    TextView compview,team1view,team2view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String event="com.example.crown11.fragment.MatchFragment";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MatchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MatchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MatchFragment newInstance(String param1, String param2) {
        MatchFragment fragment = new MatchFragment();
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
        Log.d(event," get the name for json file");
        try{
            //getting the random number for json file
            int i=0;
            if(i==0)
            {
                Random random = new Random();
                randomNumber = random.nextInt(336041 -335982) + 335982;
                i++;
            }
            else if(i==1)
            {
                Random random = new Random();
                randomNumber = random.nextInt(392240 -392181) + 392181;
                i++;
            }
            else if(i==2)
            {
                Random random = new Random();
                randomNumber = random.nextInt(501254 - 501198) + 501198;
                i++;
            }
            else if(i==3)
            {
                Random random = new Random();
                randomNumber = random.nextInt(336041 -335982) + 335982;
                i= 0;
            }

            String filename= String.valueOf(randomNumber);
            // get JSONObject from JSON file
            JSONObject match = new JSONObject(filename);
            // fetch JSONObject named info
            JSONObject info = match.getJSONObject("info");

            String competiton = info.getString("competition");
            compview.setText(competiton);

       


        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =  inflater.inflate(R.layout.fragment_match, container, false);
        compview = rootview.findViewById(R.id.CompetitonView);
        team1view = rootview.findViewById(R.id.Team1View);
        team2view = rootview.findViewById(R.id.Team2view);
        return rootview;
    }
}