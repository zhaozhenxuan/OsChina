package com.example.administrator.oschina.MyAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import static android.R.attr.name;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class MyPageAdapter extends FragmentPagerAdapter {

    String[] name = new String[]{"咨询", "博客", "问答", "活动"};
    private ArrayList<Fragment> list;

    public MyPageAdapter(FragmentManager fm,ArrayList<Fragment> list) {
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
