package com.example.administrator.oschina.MyAdapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.oschina.R;
import com.example.administrator.oschina.model.Beans;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class MyMessageAdapter extends BaseAdapter {

    private Context context;
    private List<Beans.NewsBean> list;

    public MyMessageAdapter(Context context, List<Beans.NewsBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message , null);
            holder.tv_message_a = (TextView) convertView.findViewById(R.id.tv_message_a);
            holder.tv_message_b = (TextView) convertView.findViewById(R.id.tv_message_b);
            holder.tv_message_c = (TextView) convertView.findViewById(R.id.tv_message_c);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Beans.NewsBean beans = list.get(position);

        holder.tv_message_a.setText(beans.getTitle());
        holder.tv_message_b.setText(beans.getBody());
        holder.tv_message_c.setText("@"+beans.getAuthor());

        return convertView;
    }

    class ViewHolder{
        private TextView tv_message_a;
        private TextView tv_message_b;
        private TextView tv_message_c;
    }
}
