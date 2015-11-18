package com.recyclerviewtrinity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    private Context context;

    private ArrayList<GetterSetter> feedItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find recyclerview layout
        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);

        // recyclerview set layoutmanager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //adding data to arraylist
        feedItemList = new ArrayList<GetterSetter>();
        GetterSetter setter=new GetterSetter();
        setter.setName("Aneh Thakur");
        setter.setImage("https://igcdn-photos-e-a.akamaihd.net/hphotos-ak-xap1/t51.2885-19/s150x150/12142372_1688781331336388_2058073120_a.jpg");
        feedItemList.add(setter);

        GetterSetter setter1=new GetterSetter();
        setter1.setName("Shubham Mahajan");
        setter1.setImage("https://lh3.googleusercontent.com/-XleGvoJY4GQ/AAAAAAAAAAI/AAAAAAAAAG0/GTE2wfKlmHA/s120-c/photo.jpg");
        feedItemList.add(setter1);

        GetterSetter setter2 = new GetterSetter();
        setter2.setName("Jatin Sehgal");
        setter2.setImage("https://igcdn-photos-d-a.akamaihd.net/hphotos-ak-xtp1/t51.2885-19/s150x150/12135465_1033064110060763_1254840807_a.jpg");
        feedItemList.add(setter2);

        GetterSetter setter3=new GetterSetter();
        setter3.setName("Aneh Thakur");
        setter3.setImage("https://scontent-hkg3-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/p720x720/12193830_910934355638658_932169824158300781_n.jpg?oh=7e60f41421076e85fca9486a7a14f2d7&oe=56C3D619");
        feedItemList.add(setter3);

        GetterSetter setter4=new GetterSetter();
        setter4.setName("Shubham Mahajan");
        setter4.setImage("https://lh3.googleusercontent.com/-95ruO9KoXCM/VMHUAy6o3FI/AAAAAAAADes/9hXdC2n0S4E/s426/10891597_838316776210220_8110904975142812871_n.jpg");
        feedItemList.add(setter4);

        GetterSetter setter5 = new GetterSetter();
        setter5.setName("Jatin Sehgal");
        setter5.setImage("https://lh3.googleusercontent.com/-KWBAZ9VpkL4/AAAAAAAAAAI/AAAAAAAAAGA/_ETW_tKNYXE/s120-c/photo.jpg");
        feedItemList.add(setter5);

        GetterSetter setter6 = new GetterSetter();
        setter6.setName("Trinity Tuts");
        setter6.setImage("https://lh3.googleusercontent.com/-XleGvoJY4GQ/AAAAAAAAAAI/AAAAAAAAAG0/GTE2wfKlmHA/s120-c/photo.jpg");
        feedItemList.add(setter6);

        //recyclerview adapter
        mAdapter = new RecyclerAdapter(MainActivity.this,feedItemList);

        //set adpater for recyclerview
        mRecyclerView.setAdapter(mAdapter);

        //set click on item
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Log.e("here", "-------------------------------" + position);

                    }
                })
        );
    }

}
