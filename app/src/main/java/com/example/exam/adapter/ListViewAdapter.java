package com.example.exam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exam.R;
import com.example.exam.entity.Product;
import com.example.exam.room.AppDatabase;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<Product> listProducts;
    private Activity activity;
    Context ctx;
    AppDatabase db;

    public ListViewAdapter(List<Product> listProducts, Activity activity){
        this.listProducts = listProducts;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.activity_list_view, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            viewHolder.tvCode = (TextView) view.findViewById(R.id.tvCode);
            viewHolder.ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);
            view.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        Product product = listProducts.get(position);
        viewHolder.tvName.setText(product.productName);
        viewHolder.tvCode.setText(String.valueOf(product.quantity));
        return view;
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvCode;
        ImageView ivAvatar;
    }
}
