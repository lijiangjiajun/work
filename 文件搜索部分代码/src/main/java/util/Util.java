package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static final String DATA_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static String[] SIZE_NAMES = {"B","KB","MB","GB"};

    private static DateFormat df = new SimpleDateFormat(DATA_PATTERN);

    //文件大小转化类型
    public static String parseSize(Long size) {
        int n=0;
        while(size>=1024){
            size=size/1024;
            n++;
        }
        return size+SIZE_NAMES[n];
    }


    //日期类型解析
    public static String parseDate(Long lastModified) {
        return df.format(new Date(lastModified));

    }
}
