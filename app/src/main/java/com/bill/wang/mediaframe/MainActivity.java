package com.bill.wang.mediaframe;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import com.bill.wang.mediaframe.sdk.MediaFrame;
import com.bill.wang.mediaframe.sdk.callback.MediaCallback;
import com.bill.wang.mediaframe.sdk.callback.OnAllAudioLoaded;
import com.bill.wang.mediaframe.sdk.callback.Result;
import com.bill.wang.mediaframe.sdk.entity.Audio;
import com.bill.wang.mediaframe.sdk.operator.AudioManager;
import com.bill.wang.mediaframe.sdk.operator.AudioPlayer;
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
        MediaManager mm = new MediaManager();
        OnAllAudioLoaded onAllAudioLoaded= new OnAllAudioLoaded() {
            @Override
            public void onLoaded(List<Audio> audioList, AudioPlayer audioPlayer) {
                audioPlayer.playAsync(audioList.get(0).getPath())
                        .doOnBufferingUpdate(new MediaPlayer.OnBufferingUpdateListener() {
                            @Override
                            public void onBufferingUpdate(MediaPlayer mp, int percent) {

                            }
                        })
                        .doOnPrepared(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                mp.start();
                            }
                        })
                        .doOnError(new MediaPlayer.OnErrorListener() {
                            @Override
                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                return false;
                            }
                        });
            }
        };

        mm.build(new AudioManager(new AudioPlayer()))
                .doOnAllAudioLoaded(onAllAudioLoaded);


/*        List<Audio> audioList = mediaManager.audioMgr().queryAllAudio();
        for (int i = 0; i < audioList.size(); i++) {
            String path = audioList.get(i).getPath();
            Log.d(TAG, "path=" + path);

        }
        String path = audioList.get(0).getPath();
        Log.d(TAG, "audioList.get(0 =" + path);*/

    /*    mediaManager
                .audioMgr()
                .doOnAllAudioLoaded(
                        new OnAllAudioLoaded() {
                            @Override
                            public void onLoaded(List<Audio> audioList, AudioPlayer audioPlayer) {
                                audioPlayer.playAsync(audioList.get(0).getPath())
                                        .doOnBufferingUpdate(new MediaPlayer.OnBufferingUpdateListener() {
                                            @Override
                                            public void onBufferingUpdate(MediaPlayer mp, int percent) {

                                            }
                                        })
                                        .doOnPrepared(new MediaPlayer.OnPreparedListener() {
                                            @Override
                                            public void onPrepared(MediaPlayer mp) {
                                                mp.start();
                                            }
                                        })
                                        .doOnError(new MediaPlayer.OnErrorListener() {
                                            @Override
                                            public boolean onError(MediaPlayer mp, int what, int extra) {
                                                return false;
                                            }
                                        });

                            }
                        }

                );*/


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
