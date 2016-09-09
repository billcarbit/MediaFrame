package com.bill.wang.mediaframe.sdk.callback;

import android.media.MediaPlayer;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 */
public abstract class MediaCallback  implements
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnInfoListener,
        MediaPlayer.OnSeekCompleteListener {

    @Override
    public abstract void onBufferingUpdate(MediaPlayer mp, int percent);

    @Override
    public abstract void onCompletion(MediaPlayer mp);

    @Override
    public abstract  boolean onError(MediaPlayer mp, int what, int extra);

    @Override
    public abstract boolean onInfo(MediaPlayer mp, int what, int extra);

    @Override
    public abstract void onPrepared(MediaPlayer mp);

    @Override
    public abstract void onSeekComplete(MediaPlayer mp);
}
