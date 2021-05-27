package com.example.barkotlin.utils.curstomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/22
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class curstomView extends View {

    public curstomView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(10.0f);
        paint.setColor(Color.parseColor("#88880000"));
        canvas.drawCircle(300,300,50,paint);
    }

}
