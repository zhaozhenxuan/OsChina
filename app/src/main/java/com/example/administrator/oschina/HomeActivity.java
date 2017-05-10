package com.example.administrator.oschina;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.example.administrator.oschina.Fragment.Find_Fragment;
import com.example.administrator.oschina.Fragment.My_Fragment;
import com.example.administrator.oschina.Fragment.Synthetical_Fragment;
import com.example.administrator.oschina.Fragment.Trends_Fragment;
import com.example.administrator.oschina.MyAdapter.MyViewPagerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeActivity extends FragmentActivity {

    private ViewPager home_pager;
    private TextView tv_toobar;
    private ArrayList<Fragment> list;

    private MyViewPagerAdapter adapter;

    private Synthetical_Fragment synthetical;
    private Find_Fragment find;
    private Trends_Fragment trends;
    private My_Fragment my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv_toobar = (TextView) findViewById(R.id.tv_toobar);
        home_pager = (ViewPager) findViewById(R.id.home_pager);

        initData();
        initView();
    }

    private void initView() {
        adapter = new MyViewPagerAdapter(getSupportFragmentManager(), list);
        home_pager.setOffscreenPageLimit(4);
        home_pager.setAdapter(adapter);
    }

    private void initData() {
        list = new ArrayList<>();
        trends = new Trends_Fragment();
        my = new My_Fragment();
        synthetical = new Synthetical_Fragment();
        find = new Find_Fragment();
        list.add(synthetical);
        list.add(trends);
        list.add(find);
        list.add(my);
    }

}
