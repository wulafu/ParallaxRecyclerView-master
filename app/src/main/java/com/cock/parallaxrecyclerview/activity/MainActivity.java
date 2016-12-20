package com.cock.parallaxrecyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.cock.parallaxrecyclerview.R;
import com.cock.parallaxrecyclerview.adapter.MyRecyclerAdapter;
import com.cock.parallaxrecyclerview.view.ParallaxRecyclerView;

import java.util.ArrayList;
/**
 * Author : Created by Luhailiang on 2016/8/29 12:22.
 * Email : 18336094752@163.com
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> list = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        ParallaxRecyclerView recyclerView = (ParallaxRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyRecyclerAdapter(this, R.layout.item, list));
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add(R.mipmap.image1);
            list.add(R.mipmap.image2);
            list.add(R.mipmap.image3);
            list.add(R.mipmap.image4);
            list.add(R.mipmap.image5);
        }
    }
}
