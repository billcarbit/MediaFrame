package com.bill.wang.mediaframe.sdk.utils;

import java.io.File;
import java.util.List;

/**
 * Created by bill.wang on 2016/9/9.
 * https://github.com/billcarbit/MediaFrame.git
 */
public class FileUtils {

    public static void getFileList(File path, List<String> fileList) {
        if (path.isDirectory()) {//如果是文件夹的话
            File[] files = path.listFiles();//返回文件夹中有的数据
            if (null == files) {
                return;
            }
            for (int i = 0; i < files.length; i++) {
                getFileList(files[i], fileList);
            }
        } else {//如果是文件的话直接加入
            String filePath = path.getAbsolutePath();
            if (AudioUtils.formatFilter(filePath)) {//进行文件的过滤
                fileList.add(filePath);
            }
        }
    }
}
