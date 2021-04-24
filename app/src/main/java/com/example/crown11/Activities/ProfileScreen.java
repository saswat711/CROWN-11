package com.example.crown11.Activities;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.crown11.MyAdapter;
import com.example.crown11.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProfileScreen extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager tabviewPager;
    private NavigationView profileview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        tabLayout = findViewById(R.id.TabLayout);
        tabviewPager = findViewById(R.id.TabviewPager);
        profileview = findViewById(R.id.ProfileView);


        //Code for tab layout
        final MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        tabviewPager.setAdapter(adapter);

        tabviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabviewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (profileview.getVisibility() == View.VISIBLE) {
            profileview.setVisibility(View.GONE);
            return true;
        } else {
            return super.dispatchTouchEvent(ev);
        }
    }


    @Override
    public void onBackPressed() {
        int i = 0;
        if (i == 0) {
            NavigationView profileview = findViewById(R.id.ProfileView);
            profileview.setVisibility(View.INVISIBLE);
            final MyAdapter adapter = new MyAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
            tabviewPager.setAdapter(adapter);
            tabviewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    tabviewPager.setCurrentItem(0);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
            ++i;
        } else {
            super.onBackPressed();
        }
    }
}









