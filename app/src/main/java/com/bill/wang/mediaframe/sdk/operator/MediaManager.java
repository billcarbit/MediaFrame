package com.bill.wang.mediaframe.sdk.operator;

import com.bill.wang.mediaframe.sdk.MediaFrame;
import com.bill.wang.mediaframe.sdk.entity.Audio;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 */
public class MediaManager extends MediaFrame {

    private AudioPlayer mAudioPlayer;

    public MediaManager() {

    }

    public AudioManager audioMgr() {
        return new AudioManager();
    }

    public VideoManager videoMgr() {
        return new VideoManager();
    }

    public DiskScanner diskScanner() {
        return new DiskScanner();
    }

    public AudioPlayer audioPlayer() {
        if (mAudioPlayer == null) {
            mAudioPlayer = new AudioPlayer();
        }
        return mAudioPlayer;
    }

    public MediaDownloader downloader() {
        return new MediaDownloader();
    }

    public void releaseAudioPlayer() {
        mAudioPlayer.stop();
        mAudioPlayer.reset();
        mAudioPlayer.release();
        mAudioPlayer = null;
    }

}
