package com.example.barkotlin.lineView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;


/**
 * <pre>
 *     author : lijunjie
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/09/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class LinkLineLayout extends RelativeLayout {

    LinkLineBean linkLineBean;

    public LinkLineLayout(Context context) {
        super(context);
    }

    public LinkLineLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinkLineLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LinkLineLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void setDate(LinkLineBean bean){
        linkLineBean= bean;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LinkLineBean item = linkLineBean;
        if (item!=null){
            Paint paint = new Paint();
            paint.setColor(Color.parseColor(item.getColorString()));
            paint.setStrokeWidth(20);
            paint.setAntiAlias(true);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(item.getStartX(), item.getStartY(), item.getEndX(), item.getEndY(), paint);
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        LinkLineBean item = linkLineBean;
        Log.d("TAG","dispatchDraw");
        if (item!=null){
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#1391EB"));
            paint.setStrokeWidth(2.0f);
            canvas.drawLine(item.getStartX(), item.getStartY(), item.getEndX(), item.getEndY(), paint);
        }
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#1391EB"));
        paint.setStrokeWidth(200f);
        canvas.drawLine(0, 0, 300, 300, paint);
    }
}
