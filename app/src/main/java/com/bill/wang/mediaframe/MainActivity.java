package com.bill.wang.mediaframe;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import com.bill.wang.mediaframe.sdk.MediaFrame;
import com.bill.wang.mediaframe.sdk.callback.MediaCallback;
import com.bill.wang.mediaframe.sdk.entity.Audio;
import com.bill.wang.mediaframe.sdk.operator.AudioManager;
import com.bill.wang.mediaframe.sdk.operator.MediaDownloader;
import com.bill.wang.mediaframe.sdk.operator.MediaManager;

import java.util.List;

public class MainActivity extends Activity {
    public final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaFrame.init(this);//初始化框架
    }

    @Override
    protected void onResume() {
        super.onResume();
        MediaManager mediaManager = new MediaManager();
        List<Audio> audioList = mediaManager.audioMgr().queryAllAudio();
        for (int i = 0; i < audioList.size(); i++) {
            String path = audioList.get(i).getPath();
            Log.d(TAG, "path=" + path);

            mediaManager.audioPlayer()
                    .play(path, new MediaCallback(){
                @Override
                public void onBufferingUpdate(MediaPlayer mp, int percent) {

                }

                @Override
                public void onCompletion(MediaPlayer mp) {

                }

                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    return false;
                }

                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    return false;
                }

                @Override
                public void onPrepared(MediaPlayer mp) {

                }

                @Override
                public void onSeekComplete(MediaPlayer mp) {

                }
            });



        }


    }
}
