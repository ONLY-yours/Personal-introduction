package com.example.barkotlin.utils

import android.widget.Toast
import com.example.barkotlin.APP

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/19
 *     desc   : Toast工具类
 *     version: 1.0
 * </pre>
 */
object ToastUtil {

    //长
    fun show(message:String){
        Toast.makeText(APP.context, message, Toast.LENGTH_LONG).show()
    }

    //短
    fun shortShow(message: String?) {
        Toast.makeText(APP.context, message, Toast.LENGTH_SHORT).show()
    }

}
