package com.kevin.io.bio;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author caonanqing
 * @version 1.0
 * @description     IO流工具类
 * @createDate 2019/5/27
 */
public class IOUtil {

    /**
     * 关闭流的通用方法
     * @param closes
     */
    public static void closes(Closeable...closes){
        for (Closeable closeable : closes) {
            try {
                if(closeable != null) {
                    closeable.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
