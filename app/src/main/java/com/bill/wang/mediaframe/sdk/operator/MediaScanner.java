package com.bill.wang.mediaframe.sdk.operator;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;

import java.util.List;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 * 媒体文件扫描者 负责将媒体文件的信息加入媒体库，例如：文件路径，歌名，艺术家等等
 */
public class MediaScanner {

    public final static String TAG = MediaScanner.class.getSimpleName();

    private MediaScannerConnection mediaScanConn = null;

    private MediaScannerClient client = null;

    private String filePath = null;

    private String fileType = null;

    private List<String> filePaths = null;

    public MediaScanner(Context context) {
        if (client == null) {

            client = new MediaScannerClient();
        }

        if (mediaScanConn == null) {

            mediaScanConn = new MediaScannerConnection(context, client);
        }
    }

    class MediaScannerClient implements MediaScannerConnection.MediaScannerConnectionClient {

        public void onMediaScannerConnected() {
            if (filePath != null) {
                mediaScanConn.scanFile(filePath, fileType);
            }
            if (filePaths != null) {
                for (String file : filePaths) {
                    mediaScanConn.scanFile(file, fileType);
                }
            }
            filePath = null;
            fileType = null;
            filePaths = null;
        }

        public void onScanCompleted(String path, Uri uri) {
            mediaScanConn.disconnect();
        }

    }

    /**
     * 扫描文件标签信息
     *
     * @param filePath 文件路径 eg:/sdcard/MediaPlayer/dahai.mp3
     * @param fileType 文件类型 eg: audio/mp3  media/*  application/ogg
     */
    public void scanFile(String filePath, String fileType) {
        this.filePath = filePath;
        this.fileType = fileType;
        //连接之后调用MusicSannerClient的onMediaScannerConnected()方法
        mediaScanConn.connect();
    }

    /**
     * @param filePaths 文件路径
     * @param fileType  文件类型
     */
    public void scanFile(List<String> filePaths, String fileType) {
        this.filePaths = filePaths;
        this.fileType = fileType;
        mediaScanConn.connect();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}