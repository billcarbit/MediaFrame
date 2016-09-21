package com.bill.wang.mediaframe.sdk;

import android.content.Context;

import com.bill.wang.mediaframe.sdk.callback.OnAllAudioLoaded;
import com.bill.wang.mediaframe.sdk.callback.Result;
import com.bill.wang.mediaframe.sdk.entity.Audio;
import com.bill.wang.mediaframe.sdk.operator.AudioManager;

import java.util.List;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 */
public abstract class MediaFrame {
    protected static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public abstract AudioManager doOnAllAudioLoaded(OnAllAudioLoaded result);

}
