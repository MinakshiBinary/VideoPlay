package com.binaryic.videoplay.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.binaryic.videoplay.R;
import com.binaryic.videoplay.activity.MyPlayerActivity;
import com.binaryic.videoplay.activity.YouTubeActivity;
import com.binaryic.videoplay.model.VideoModel;

import java.util.ArrayList;

/**
 * Created by minakshi on 27/6/17.
 */

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListHolder> {
    Activity context;
    ArrayList<VideoModel> array_data;

    public VideoListAdapter(Activity context, ArrayList<VideoModel> array_data) {
        this.context = context;
        this.array_data = array_data;
    }

    @Override
    public VideoListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_list, parent, false);
        return new VideoListHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoListHolder holder, int position) {
        holder.tv_Name.setText(array_data.get(position).getName());
        holder.tv_Description.setText(array_data.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return array_data.size();
    }

    public class VideoListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_Name;
        TextView tv_Description;
        LinearLayout ll_content;

        public VideoListHolder(View itemView) {
            super(itemView);
            tv_Name = (TextView) itemView.findViewById(R.id.tv_Name);
            tv_Description = (TextView) itemView.findViewById(R.id.tv_Description);
            ll_content = (LinearLayout) itemView.findViewById(R.id.ll_content);
            ll_content.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_content:
                    if (array_data.get(getPosition()).getVideo_Type().matches("other")) {
                        Log.e("adapter", "Video_Type==" + array_data.get(getPosition()).getVideo_Type());
                        Log.e("adapter", "Url==" + array_data.get(getPosition()).getUrl());
                        Intent intent = new Intent(context, MyPlayerActivity.class);
                        intent.putExtra("url", array_data.get(getPosition()).getUrl());
                        context.startActivity(intent);
                    } else {
                        Log.e("adapter", "Video_Type==" + array_data.get(getPosition()).getVideo_Type());
                        Log.e("adapter", "Url==" + array_data.get(getPosition()).getUrl());
                        Intent intent = new Intent(context, YouTubeActivity.class);
                        intent.putExtra("url", array_data.get(getPosition()).getUrl());
                        context.startActivity(intent);
                    }
                    break;
            }
        }
    }
}
