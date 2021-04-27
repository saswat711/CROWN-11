package com.example.crown11.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.crown11.MyAdapter;
import com.example.crown11.R;
import com.example.crown11.fragment.HomeFragment;
import com.example.crown11.fragment.RulesFragment;
import com.example.crown11.fragment.SignOutFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProfileScreen extends AppCompatActivity {

    private NavigationView profileview;
   private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);

        profileview = findViewById(R.id.ProfileView);
        bottomNavigation = findViewById(R.id.SettingsView);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));
    }
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.Home:
                            openFragment(HomeFragment.newInstance("", ""));
                            return true;
                        case R.id.SignOut:
                            openFragment(SignOutFragment.newInstance("", ""));
                            return true;
                        case R.id.rules:
                            openFragment(RulesFragment.newInstance("", ""));
                            return true;
                        case R.id.profile:
                            profileview.setVisibility(View.VISIBLE);
                    }
                    return false;
                }
            };

        public void openFragment(Fragment fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
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

        } else {
            super.onBackPressed();
        }
    }
}









