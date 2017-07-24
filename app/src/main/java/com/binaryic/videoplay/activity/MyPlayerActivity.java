package com.binaryic.videoplay.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.afollestad.easyvideoplayer.EasyVideoCallback;
import com.afollestad.easyvideoplayer.EasyVideoPlayer;
import com.binaryic.videoplay.R;

/**
 * Created by minakshi on 27/6/17.
 */

public class MyPlayerActivity extends AppCompatActivity implements EasyVideoCallback {

    private static final String TEST_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
    //   private static final String TEST_URL = "http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
    // private static final String TEST_URL = Environment.getExternalStorageDirectory().getPath()+"/media/1.mp4";

    private EasyVideoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myplayer);

        // Grabs a reference to the player view
        player = (EasyVideoPlayer) findViewById(R.id.player);

        // Sets the callback to this Activity, since it inherits EasyVideoCallback
        player.setCallback(this);

        // Sets the source to the HTTP URL held in the TEST_URL variable.
        // To play files, you can use Uri.fromFile(new File("..."))
        getExtra();


        // From here, the player view will show a progress indicator until the player is prepared.
        // Once it's prepared, the progress indicator goes away and the controls become enabled for the user to begin playback.
    }

    private void getExtra() {
        if (getIntent().hasExtra("url")) {
            //  player.setSource(Uri.parse(TEST_URL));
            player.setSource(Uri.parse(getIntent().getStringExtra("url")));

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        // Make sure the player stops playing if the user presses the home button.
        player.pause();
    }

    // Methods for the implemented EasyVideoCallback

    @Override
    public void onPreparing(EasyVideoPlayer player) {
        // TODO handle if needed
    }

    @Override
    public void onPrepared(EasyVideoPlayer player) {
        // TODO handle
    }

    @Override
    public void onBuffering(int percent) {
        // TODO handle if needed
    }

    @Override
    public void onError(EasyVideoPlayer player, Exception e) {
        Log.e("MyPlayerActivity", "error==" + e.getMessage());
    }

    @Override
    public void onCompletion(EasyVideoPlayer player) {
        // TODO handle if needed
        finish();
    }

    @Override
    public void onRetry(EasyVideoPlayer player, Uri source) {
        // TODO handle if used
    }

    @Override
    public void onSubmit(EasyVideoPlayer player, Uri source) {
        // TODO handle if used
    }

    @Override
    public void onStarted(EasyVideoPlayer player) {
        // TODO handle if needed
    }

    @Override
    public void onPaused(EasyVideoPlayer player) {
        // TODO handle if needed
    }
}
