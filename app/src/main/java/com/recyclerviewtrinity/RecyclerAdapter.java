package com.recyclerviewtrinity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aneh Thakur
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {
    private List<GetterSetter> feedItemList;
    private Context mContext;

    public RecyclerAdapter(Context context, ArrayList<GetterSetter> feedItemList) {
        this.feedItemList=feedItemList;
        this.mContext = context;

    }

    @Override
    public RecyclerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        setAnimation(holder.container, position);
        GetterSetter dc_list = feedItemList.get(position);
       holder.tvspecies.setText(dc_list.getName());
        String url=dc_list.getImage();
        url=url.replace(" ","%20");
        Picasso.with(mContext).load(url).fit().into(holder.imgl);


    }

    private void setAnimation(FrameLayout container, int position) {
        Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
        container.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

ImageView imgl;
        TextView tvspecies;
        FrameLayout container;
        public CustomViewHolder(View itemView) {
            super(itemView);
            imgl=(ImageView)itemView.findViewById(R.id.back_image);
            tvspecies = (TextView)itemView.findViewById(R.id.tv_species);
            container = (FrameLayout) itemView.findViewById(R.id.item_layout_container);
        }
    }
}