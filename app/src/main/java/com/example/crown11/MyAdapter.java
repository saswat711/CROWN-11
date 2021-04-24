package com.example.crown11;

import android.content.Context;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
  @Override
    public Fragment getItem(int position) {
      switch (position) {
          case 0:
              MatchFragment matchFragment = new MatchFragment();
              return matchFragment;
          case 1:
              LiveFragment liveFragment = new LiveFragment();
              return liveFragment;
          case 2:
              PointsFragment pointsFragment = new PointsFragment();
              return pointsFragment;
          default:
              return null;
      }
  }

    // this counts total number of tabs
@Override
    public int getCount() {
        return totalTabs;
    }
}