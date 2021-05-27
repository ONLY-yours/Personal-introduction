package com.example.barkotlin;

import android.app.Application;
import android.bluetooth.BluetoothSocket;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;

/**
 * Created by  Huanglinqing on 2018/8/24/024.
 * APPlication 类
 * 初始化 Logger 等
 */

public class APP extends Application {

    //不管是蓝牙连接方还是服务器方，得到socket对象后都传入
    public static BluetoothSocket bluetoothSocket;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
