package com.bill.wang.mediaframe.sdk.operator;

import com.bill.wang.mediaframe.sdk.MediaFrame;
import com.bill.wang.mediaframe.sdk.callback.OnAllAudioLoaded;
import com.bill.wang.mediaframe.sdk.callback.Result;
import com.bill.wang.mediaframe.sdk.entity.Audio;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 */
public class MediaManager extends MediaFrame {

    private AudioManager mAudioManager;
    private VideoManager mVideoManager;
    private static MediaManager mediaManager;

    public MediaManager() {

    }

    public AudioManager getAudioManager() {
        return mAudioManager;
    }

    public VideoManager getVideoManager() {
        return mVideoManager;
    }

/*    public static synchronized MediaManager getInstance() {
        if (mediaManager == null) {
            mediaManager = new MediaManager();
        }
        return mediaManager;
    }*/


    public DiskScanner diskScanner() {
        return new DiskScanner();
    }


    public MediaFrame build(MediaFrame mf) {
        if (mf instanceof AudioManager) {
            mAudioManager = (AudioManager) mf;
        } else if (mf instanceof VideoManager) {
            mVideoManager = (VideoManager) mf;
        }
        return mf;
    }

    public MediaDownloader downloader() {
        return new MediaDownloader();
    }


    @Override
    public AudioManager doOnAllAudioLoaded(OnAllAudioLoaded result) {
        return null;
    }
}
