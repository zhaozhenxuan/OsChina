package com.example.administrator.oschina.scend_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.oschina.R;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class Blogs_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View blogs = inflater.inflate(R.layout.synthetical_blogs_item , null);

        Log.e("TAG","当前位置 : " + "Blogs_Fragment");

        return blogs;
    }
}
