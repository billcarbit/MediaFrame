package com.bill.wang.mediaframe.sdk.utils;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 */
public class AudioUtils {

    /**
     * 格式过滤
     *
     * @param path
     * @return
     */
    public static boolean formatFilter(String path) {
        return path.endsWith(".wav") || path.endsWith(".mp3") || path.endsWith(".aac") || path
                .endsWith(".m4a") || path.endsWith(".ape") || path.endsWith(".flac");
    }


}
