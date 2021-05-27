package com.example.barkotlin.utils.curstomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.example.barkotlin.APP.context

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/22
 *     desc   : 自定义imageview
 *     version: 1.0
 * </pre>
 */
class curstomImageView(context: Context?,attrs: AttributeSet?) : androidx.appcompat.widget.AppCompatImageView(context,attrs){
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 10.0f
        paint.color = Color.parseColor("#88880000")
        canvas!!.drawCircle(300f, 300f, 50f, paint)
    }
}
