package com.bill.wang.mediaframe.sdk.operator;

import android.os.Environment;

import com.bill.wang.mediaframe.sdk.MediaFrame;
import com.bill.wang.mediaframe.sdk.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 * 硬盘扫描者   负责扫面设备上存储的媒体文件
 */
public class DiskScanner extends MediaFrame {
    public final static String TAG = DiskScanner.class.getSimpleName();
    private Thread audioScanThread;
    private Thread videoScanThread;

    /**
     * 开始音频全盘扫面
     */
    public void startAudioScan() {
        if (audioScanThread != null && audioScanThread.isAlive()) {
            return;
        }
        audioScanThread = new Thread(new AudioScanTask());
        audioScanThread.start();
    }


    /**
     * 开启视频全盘扫描
     */
    public void startVideoScan() {
        if (videoScanThread != null && videoScanThread.isAlive()) {
            return;
        }
        videoScanThread = new Thread(new VideoScanTask());
        videoScanThread.start();

    }


    class AudioScanTask implements Runnable {
        @Override
        public void run() {
            List<String> fileList = new ArrayList<String>();
            FileUtils.getFileList(Environment.getExternalStorageDirectory(), fileList);
            MediaScanner mediaScanner = new MediaScanner(mContext);
            mediaScanner.scanFile(fileList, null);
        }
    }

    class VideoScanTask implements Runnable {
        @Override
        public void run() {

        }
    }

}
