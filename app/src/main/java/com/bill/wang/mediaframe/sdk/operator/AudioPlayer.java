package com.bill.wang.mediaframe.sdk.operator;

import android.media.MediaPlayer;
import android.util.Log;

import com.bill.wang.mediaframe.sdk.callback.MediaCallback;

import java.io.IOException;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 * <p/>
 * 音频播放者 负责音频的播放，
 */
public class AudioPlayer extends MediaPlayer {
    public final static String TAG = AudioPlayer.class.getSimpleName();


    public AudioPlayer() {
    }


    public AudioPlayer doOnBufferingUpdate(MediaPlayer.OnBufferingUpdateListener listener) {
        this.setOnBufferingUpdateListener(listener);
        return this;
    }

    public AudioPlayer doOnPrepared(MediaPlayer.OnPreparedListener listener) {
        this.setOnPreparedListener(listener);
        return this;
    }

    public AudioPlayer doOnError(MediaPlayer.OnErrorListener listener) {
        this.setOnErrorListener(listener);
        return this;
    }

    public AudioPlayer doOnCompletion(MediaPlayer.OnCompletionListener listener) {
        this.setOnCompletionListener(listener);
        return this;
    }

    public AudioPlayer doOnInfo(MediaPlayer.OnInfoListener listener) {
        this.setOnInfoListener(listener);
        return this;
    }

    public AudioPlayer doOnSeekComplete(MediaPlayer.OnSeekCompleteListener listener) {
        this.setOnSeekCompleteListener(listener);
        return this;
    }


    /**
     * 同步播放
     * @param path
     * @return
     */
    public AudioPlayer play(String path) {
        reset();
        setDataSource(path);
        prepare();
        start();
        return this;
    }

    /**
     * 异步播放
     * @param path
     * @return
     */
    public AudioPlayer playAsync(String path) {
        reset();
        setDataSource(path);
        prepareAsync();
        return this;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void reset() {
        super.reset();
    }

    @Override
    public void setDataSource(String path) {
        try {
            super.setDataSource(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepare() {
        try {
            super.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void prepareAsync() {
        super.prepareAsync();
    }

    @Override
    public void seekTo(int msec) {
        super.seekTo(msec);
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void setVolume(float leftVolume, float rightVolume) {
        super.setVolume(leftVolume, rightVolume);
    }

    @Override
    public void release() {
        super.release();
    }

    @Override
    public int getDuration() {
        return super.getDuration();
    }

    @Override
    public boolean isPlaying() {
        return super.isPlaying();
    }
}
