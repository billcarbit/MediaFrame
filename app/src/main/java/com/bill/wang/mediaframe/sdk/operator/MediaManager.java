package com.bill.wang.mediaframe.sdk.operator;

import com.bill.wang.mediaframe.sdk.MediaFrame;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 */
public class MediaManager extends MediaFrame {


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
        return new AudioPlayer();
    }

    public MediaDownloader downloader() {
        return new MediaDownloader();
    }

}
