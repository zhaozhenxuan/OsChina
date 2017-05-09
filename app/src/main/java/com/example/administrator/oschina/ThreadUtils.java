package com.example.administrator.oschina;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class ThreadUtils {

    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public static void RunUiThread(Runnable runnable){
        mHandler.post(runnable);
    }

    public static void RunStubThread(Runnable runnable){
        new Thread(runnable).start();
    }
}
