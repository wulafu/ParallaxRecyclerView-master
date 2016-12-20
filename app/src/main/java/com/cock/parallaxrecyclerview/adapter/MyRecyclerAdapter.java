package com.cock.parallaxrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cock.parallaxrecyclerview.R;
import com.cock.parallaxrecyclerview.holder.ParallaxViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Author : Created by Luhailiang on 2016/8/29 12:22.
 * Email : 18336094752@163.com
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private int getItemLayoutId ;
    private ArrayList<Integer> mData;


    public MyRecyclerAdapter(Context context, int getItemLayoutId, ArrayList<Integer> mData) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.getItemLayoutId = getItemLayoutId;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        return new ViewHolder(inflater.inflate(getItemLayoutId, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Picasso.with(context).load(mData.get(position)).into(viewHolder.getBackgroundImage());
        viewHolder.getTextView().setText("测试数据第" + position);

        // Important to call this method
        viewHolder.getBackgroundImage().reuse();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * # CAUTION:
     * ViewHolder must extend from ParallaxViewHolder
     */
    public static class ViewHolder extends ParallaxViewHolder {

        private final TextView textView;

        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.label);
        }

        @Override
        public int getParallaxImageId() {
            return R.id.backgroundImage;
        }

        public TextView getTextView() {
            return textView;
        }
    }
}

