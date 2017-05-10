package com.example.administrator.oschina.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.oschina.MyAdapter.MyTrendsAdapter;
import com.example.administrator.oschina.R;
import com.example.administrator.oschina.Thrends_Fragment.Trends_hot_Fragment;
import com.example.administrator.oschina.Thrends_Fragment.Trends_my_Fragment;
import com.example.administrator.oschina.Thrends_Fragment.Trends_news_Fragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.example.administrator.oschina.R.id.synthetical_pager;
import static com.example.administrator.oschina.R.id.synthetical_tab;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class Trends_Fragment extends Fragment {


    @Bind(R.id.treads_tab)
    TabLayout treadsTab;
    @Bind(R.id.trends_pager)
    ViewPager trendsPager;

    private ArrayList<Fragment> list;
    private MyTrendsAdapter trendsAdapter;

    private Trends_hot_Fragment trends_hot;
    private Trends_my_Fragment trends_my;
    private Trends_news_Fragment trends_news;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View trends = inflater.inflate(R.layout.trends_item, null);
        ButterKnife.bind(this, trends);

        initData();


        return trends;
    }

    private void initData() {
        list = new ArrayList<>();
        trends_hot = new Trends_hot_Fragment();
        trends_my = new Trends_my_Fragment();
        trends_news = new Trends_news_Fragment();

        list.add(trends_news);
        list.add(trends_hot);
        list.add(trends_my);

        trendsAdapter = new MyTrendsAdapter(getChildFragmentManager() , list);
        trendsPager.setAdapter(trendsAdapter);

        treadsTab.setupWithViewPager(trendsPager);
        treadsTab.setTabMode(TabLayout.MODE_FIXED);
        treadsTab.setTabTextColors(R.color.aaa,R.color.bbb);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
