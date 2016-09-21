package com.bill.wang.mediaframe.sdk.callback;

import com.bill.wang.mediaframe.sdk.entity.Audio;
import com.bill.wang.mediaframe.sdk.operator.AudioPlayer;

import java.util.List;

/**
 * Created by bill.wang on 2016/9/21.
 * https://github.com/billcarbit/MediaFrame.git
 */
public interface Result {
    void onSuccess();
    void onError();
    void onSuccess(List<Audio> audioList, AudioPlayer audioPlayer);

}
