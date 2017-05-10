package com.example.administrator.oschina.Thrends_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.oschina.R;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class Trends_news_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View news = inflater.inflate(R.layout.thrends_news_item , null);

        return news;
    }
}
