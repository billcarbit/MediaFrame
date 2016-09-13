package com.bill.wang.mediaframe.sdk.callback;

import com.bill.wang.mediaframe.sdk.entity.Audio;
import com.bill.wang.mediaframe.sdk.operator.AudioPlayer;

import java.util.List;

/**
 * Created by bill.wang on 2016/9/13.
 * https://github.com/billcarbit/MediaFrame.git
 */
public interface OnAllAudioLoaded {
  void onLoaded(List<Audio> audioList, AudioPlayer audioPlayer);
}
