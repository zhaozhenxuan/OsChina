package com.example.administrator.oschina.scend_Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.oschina.MyAdapter.MyMessageAdapter;
import com.example.administrator.oschina.R;
import com.example.administrator.oschina.ThreadUtils;
import com.example.administrator.oschina.model.Beans;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.thoughtworks.xstream.XStream;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

import static android.os.Build.VERSION_CODES.M;
import static com.example.administrator.oschina.R.id.synthetical_pager;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class Message_Fragment extends Fragment {

    private ListView synthetical_Listview;
    private RollPagerView synthetical_Pager;
    private List<Beans.NewsBean> list = new ArrayList<>();
    private MyMessageAdapter myMessageAdapter;
    private PtrFrameLayout frameLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View message = inflater.inflate(R.layout.synthetical_message_item, null);

        View baner = inflater.inflate(R.layout.baner_item, null);

        synthetical_Listview = (ListView) message.findViewById(R.id.synthetical_listview);
        synthetical_Pager = (RollPagerView) baner.findViewById(synthetical_pager);
        frameLayout = (PtrFrameLayout) message.findViewById(R.id.framelayut);


        initData();

        //添加listview头视图
        synthetical_Listview.addHeaderView(baner);

        Log.e("TAG", "当前位置 : " + "Message_Fragment");

        //设置播放时间间隔
        synthetical_Pager.setPlayDelay(3000);
        //设置透明度
        synthetical_Pager.setAnimationDurtion(500);
        //设置适配器
        synthetical_Pager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        synthetical_Pager.setHintView(new ColorPointHintView(getActivity(), Color.YELLOW, Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);





        /**
         * 上拉加载和下拉刷新的
         */
        PtrClassicDefaultHeader defaultHeader = new PtrClassicDefaultHeader(getActivity());
        PtrClassicDefaultFooter defaultFooter = new PtrClassicDefaultFooter(getActivity());

        frameLayout.setHeaderView(defaultHeader);
        frameLayout.setFooterView(defaultFooter);
        frameLayout.addPtrUIHandler(defaultFooter);
        frameLayout.addPtrUIHandler(defaultHeader);

        frameLayout.setPtrHandler(new PtrDefaultHandler2() {
            //加载更多
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        ThreadUtils.RunUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myMessageAdapter.notifyDataSetChanged();
                                frameLayout.refreshComplete();
                            }
                        });
                    }
                } , 3000);
            }
            //刷新数据
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        ThreadUtils.RunUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myMessageAdapter.notifyDataSetChanged();
                                frameLayout.refreshComplete();
                            }
                        });
                    }
                } , 3000);
            }
        });







        return message;
    }

    private void initData() {

        String url = "http://www.oschina.net/action/api/news_list";
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            //请求成功
            public void onResponse(String s) {
                XStream xStream = new XStream();
                xStream.alias("oschina" , Beans.class);
                xStream.alias("news" , Beans.NewsBean.class);

                Beans beans = (Beans) xStream.fromXML(s);
                List<Beans.NewsBean> newslist = beans.getNewslist();
                list.addAll(newslist);

                Log.e("TAG","打印数据 ："+ list.toString());

                myMessageAdapter = new MyMessageAdapter(getActivity() , list);

                synthetical_Listview.setAdapter(myMessageAdapter);


            }
        }, new Response.ErrorListener() {
            @Override
            //请求失败
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(stringRequest);

    }

    //轮播图适配器
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.bg_topic_1,
                R.drawable.bg_topic_2,
                R.drawable.bg_topic_3,
                R.drawable.bg_topic_4,
                R.drawable.bg_topic_5,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
