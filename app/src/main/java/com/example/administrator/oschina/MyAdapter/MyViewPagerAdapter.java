package com.example.administrator.oschina.MyAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;

    public MyViewPagerAdapter(FragmentManager fm , ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
