package com.bill.wang.mediaframe.sdk.operator;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.MediaStore;

import com.bill.wang.mediaframe.sdk.MediaFrame;
import com.bill.wang.mediaframe.sdk.callback.OnAllAudioLoaded;
import com.bill.wang.mediaframe.sdk.entity.Audio;
import com.bill.wang.mediaframe.sdk.utils.AudioUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.reflect.Method;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 * 音频管理者 负责音频数据库和外存文件的增删改查
 */
public class AudioManager extends MediaFrame {
    private static final String TAG = AudioManager.class.getSimpleName();

    public AudioManager() {
    }

    /**
     * 获取媒体库中所有音频对象
     *
     * @return
     */
    public List<Audio> queryAllAudio() {
        Cursor cursor = getAudioCursorByCondition(null, null, null, null);
        List<Audio> audioList = getAudioListByCursor(cursor);
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return audioList;
    }

    private OnAllAudioLoaded mOnAllAudioLoaded;

    public AudioManager doOnAllAudioLoaded(OnAllAudioLoaded onAllAudioLoaded) {
        mOnAllAudioLoaded = onAllAudioLoaded;
        List<Audio> audioList =queryAllAudio();
        mOnAllAudioLoaded.onLoaded( audioList,MediaManager.getInstance().audioPlayer());
        return this;
    }


    /**
     * 根据游标获取Audio对象
     *
     * @param audioCursor
     * @return
     */
    public Audio getAudioByCursor(Cursor audioCursor) {
        Audio audio = new Audio();
        if (audioCursor == null) {
            return null;
        }
        String path = audioCursor.getString(audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));

        if (!(path != null && new File(path).exists() && AudioUtils.formatFilter(path))) {//音频文件必须实际存在并且格式符合过滤条件
            return null;
        }

        String title = checkString(audioCursor
                .getString(audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)), audioCursor
                .getString(audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)));
        String artist = checkString(audioCursor.getString(
                audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)), "<unknown>");
        String album = audioCursor
                .getString(audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
        int albumId = audioCursor
                .getInt(audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
        int audioId = audioCursor
                .getInt(audioCursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));

        audio.setName(title);
        audio.setPath(path);
        audio.setArtist(artist);
        audio.setAlbumId(albumId);
        audio.setAlbum(album);
        audio.setAudioId(audioId);

        return audio;
    }

    /**
     * 根据游标获取 AudioList
     *
     * @param audioCursor
     * @return
     */
    public List<Audio> getAudioListByCursor(Cursor audioCursor) {
        List<Audio> audioList = new ArrayList<Audio>();
        for (int i = 0; audioCursor != null && i < audioCursor.getCount(); i++) {
            audioCursor.moveToNext();
            Audio audio = getAudioByCursor(audioCursor);
            if (audio != null) {
                audioList.add(audio);
            }
        }
        return audioList;
    }

    public Cursor getAudioCursorByCondition(String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor audioCursor = mContext.getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection, selection,
                selectionArgs,
                sortOrder);
        return audioCursor;
    }

    /**
     * 首先判断字符串是否为非中文和英文字符的乱码，
     * 如果是，则先将转回的编码用gbk进行解码，如果
     * 解码后的中文字符串仍有乱码，则返回默认值
     *
     * @param strName  判断字符串
     * @param defValue 返回默认字符串
     * @return 返回校验后的字符串
     */
    private static String checkString(String strName, String defValue) {
        if (strName == null) return "";

        boolean errorCode = false;
        byte[] bytes;
        try {
            bytes = strName.getBytes("ISO8859-1");

            for (int i = 0; i < bytes.length; i++) {
                byte b = bytes[i];
                if (b < 0) {
                    errorCode = true;
                    break;
                }
            }

            if (!errorCode) {
                return strName;
            }
            /*strName=new String(bytes,"GBK");
            if(!isMessyCode(strName)){
                return strName;
            }*/
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (defValue != null && AudioUtils.formatFilter(defValue)) {
            defValue = defValue.substring(0, defValue.lastIndexOf("."));
        }
        return defValue;
    }


    public DiskScanner diskScanner() {
        return new DiskScanner();
    }
}
