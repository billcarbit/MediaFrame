package com.bill.wang.mediaframe.sdk.operator;

import android.media.MediaPlayer;
import com.bill.wang.mediaframe.sdk.callback.MediaCallback;
import java.io.IOException;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 * <p/>
 * 音频播放者 负责音频的播放，
 */
public class AudioPlayer extends MediaPlayer{


    class AudioPlayerListener implements
            MediaPlayer.OnPreparedListener,
            MediaPlayer.OnErrorListener,
            MediaPlayer.OnBufferingUpdateListener,
            MediaPlayer.OnCompletionListener,
            MediaPlayer.OnInfoListener,
            MediaPlayer.OnSeekCompleteListener  {
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
    }

    //private Context mContext;

    private MediaCallback mCallback;

    public AudioPlayer() {
    }



    public void play(String path, MediaCallback callback) {
        mCallback = callback;
        reset();
        setDataSource(path);
        prepare();
        start();
    }

    public void playAsync(String path) {
        reset();
        setDataSource(path);
        prepareAsync();
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
