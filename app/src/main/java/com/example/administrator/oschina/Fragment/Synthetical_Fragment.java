package com.example.administrator.oschina.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.oschina.MyAdapter.MyPageAdapter;
import com.example.administrator.oschina.R;
import com.example.administrator.oschina.scend_Fragment.Blogs_Fragment;
import com.example.administrator.oschina.scend_Fragment.Exercise_Fragment;
import com.example.administrator.oschina.scend_Fragment.Inquire_Fragment;
import com.example.administrator.oschina.scend_Fragment.Message_Fragment;

import java.util.ArrayList;

import static com.example.administrator.oschina.R.id.synthetical_pager;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class
Synthetical_Fragment extends android.support.v4.app.Fragment{

    private ArrayList<android.support.v4.app.Fragment> list;
    private ViewPager synthetical_pager;
    private MyPageAdapter myPageAdapter;

    private TabLayout synthetical_tab;
    private Blogs_Fragment blogs;
    private Exercise_Fragment exercise;
    private Inquire_Fragment inquire;
    private Message_Fragment message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View synthetical  =  inflater.inflate(R.layout.synthetical_item , null);

        synthetical_pager = (ViewPager) synthetical.findViewById(R.id.synthetical_pager);

        synthetical_tab = (TabLayout) synthetical.findViewById(R.id.synthetical_tab);
        initData();


        return synthetical;
    }

    private void initData() {
        list = new ArrayList<>();

        blogs = new Blogs_Fragment();
        exercise = new Exercise_Fragment();
        inquire = new Inquire_Fragment();
        message = new Message_Fragment();

        list.add(message);
        list.add(blogs);
        list.add(inquire);
        list.add(exercise);

        myPageAdapter = new MyPageAdapter(getChildFragmentManager() , list);
        //加载多少Fragment
        synthetical_pager.setOffscreenPageLimit(4);

        synthetical_pager.setAdapter(myPageAdapter);



        synthetical_tab.setupWithViewPager(synthetical_pager);
        synthetical_tab.setTabMode(TabLayout.MODE_FIXED);
        synthetical_tab.setTabTextColors(R.color.aaa,R.color.bbb);

    }


}
