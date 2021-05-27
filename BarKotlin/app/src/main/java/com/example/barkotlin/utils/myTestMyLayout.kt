package com.example.barkotlin.utils

import android.os.Parcel
import android.os.Parcelable
import android.view.ViewGroup
import com.example.barkotlin.APP.context

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class myTestMyLayout() : ViewGroup(context) {

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        TODO("Not yet implemented")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }

}