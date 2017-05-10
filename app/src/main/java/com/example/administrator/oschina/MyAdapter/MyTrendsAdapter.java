package com.example.administrator.oschina.MyAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class MyTrendsAdapter extends FragmentPagerAdapter {

    String[] name = new String[]{"最新动弹", "热门动弹", "我的动弹"};
    private ArrayList<Fragment> list;

    public MyTrendsAdapter(FragmentManager fm, ArrayList<Fragment> list) {
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

    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }
}
