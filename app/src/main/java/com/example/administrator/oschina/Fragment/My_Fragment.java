package com.example.administrator.oschina.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.oschina.R;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class My_Fragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View my  =  inflater.inflate(R.layout.my_item , null);
        return my;
    }
}
