package com.example.barkotlin.fragment

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.barkotlin.R
import com.example.barkotlin.intentactivity.IntentActivity
import com.example.barkotlin.lineView.LinkLineBean
import com.example.barkotlin.utils.ToastUtil
import kotlinx.android.synthetic.main.fragment_exam_line_text.*

/**
 * <pre>
 *     author : lijunjie
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/09/26
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ExamLineTextFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exam_line_text, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iv_left.setOnClickListener {
            var startX :Float= iv_left.right+0.0f
            var startY :Float= (iv_left.top + iv_left.bottom)/2.0f

            var endX :Float= (iv_right.left).toFloat()
            var endY :Float= (iv_right.top+iv_right.bottom)/2.0f
            var bean = LinkLineBean(startX,startY,endX,endY)

            linklineLayout.setDate(bean)
            ToastUtil.shortShow("onclick")
        }

        iv_right.setOnClickListener{
            startActivity(Intent(context,
                IntentActivity::class.java))
        }


    }



}