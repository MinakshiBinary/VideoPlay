package com.binaryic.videoplay.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.binaryic.videoplay.R;
import com.binaryic.videoplay.adapter.VideoListAdapter;
import com.binaryic.videoplay.model.VideoModel;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private RecyclerView rv_Videos;
    private ArrayList<VideoModel> array_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
    }

    private void init() {
        rv_Videos = (RecyclerView) findViewById(R.id.rv_Videos);
        setList();
        rv_Videos.hasFixedSize();
        rv_Videos.setLayoutManager(new LinearLayoutManager(ListActivity.this));
        rv_Videos.setAdapter(new VideoListAdapter(ListActivity.this, array_video));
    }

    private void setList() {
        array_video = new ArrayList<VideoModel>();

        VideoModel videoModel = new VideoModel();
        videoModel.setName("Big Buck Bunny");
        videoModel.setDescription("The best way to use these icons on the web is with our icon web font.");
        videoModel.setUrl("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        videoModel.setVideo_Type("other");
        array_video.add(videoModel);

        VideoModel videoModel1 = new VideoModel();
        videoModel1.setName("Android Commercial");
        videoModel1.setDescription("The best way to use these icons on the web is with our icon web font.");
        videoModel1.setUrl("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
        videoModel1.setVideo_Type("other");
        array_video.add(videoModel1);

        VideoModel videoModel2 = new VideoModel();
        videoModel2.setName("Android RecyclerView");
        videoModel2.setDescription("The best way to use these icons on the web is with our icon web font.");
        videoModel2.setUrl("nGA3jMBDjHk");
        videoModel2.setVideo_Type("youtube");
        array_video.add(videoModel2);

    }
}
