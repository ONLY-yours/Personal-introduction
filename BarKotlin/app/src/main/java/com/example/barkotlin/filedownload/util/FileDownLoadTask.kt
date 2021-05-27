package com.example.barkotlin.filedownload.util

import android.app.Dialog
import com.bumptech.glide.util.Util
import java.net.HttpURLConnection

/**
 * <pre>
 *     author : lijunjie
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/12/10
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class FileDownLoadTask {
    private lateinit var dialog : Dialog;
    private lateinit var callBack: DownLoadCallBack;
    private lateinit var downurl : String
    private lateinit var filename : String
    private var filePath: String ?=""           //下载文件的存放目录
    private var canProgress : Boolean ?=true
    private var conn : HttpURLConnection? = null

    interface DownLoadCallBack{
        fun callBack(isSucss : Boolean, filePath : String)
    }

}