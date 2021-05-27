package com.example.barkotlin.ui.main

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.barkotlin.R
import com.example.barkotlin.`interface`.AnnotationClass
import kotlinx.android.synthetic.main.activity_custom_view.*


@AnnotationClass(name = "Tyle")
class CustomViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        testAnnotation()

        btn_translate.setOnClickListener {
            var annotation = iv_custom_view.animate()

                annotation.translationX(100.0F)
                annotation.translationY(300.0F)
                annotation.duration = 1200
                annotation.interpolator = OvershootInterpolator()

            annotation.setUpdateListener {

            }
        }
    }

    private fun testAnnotation(){
        var hasAnnotation = CustomViewActivity()::class.java.isAnnotationPresent(AnnotationClass::class.java)
        if (hasAnnotation){
            var annotationClass = CustomViewActivity()::class.java.getAnnotation(AnnotationClass::class.java)

        }

        //java转kotlin
//        val hasAnnotation: Boolean =
//            Main::class.java.isAnnotationPresent(AnnotationClass::class.java)
//        if (hasAnnotation) {
//            //获取到注解实例
//            val annotationClass: AnnotationClass =
//                Main::class.java.getAnnotation(AnnotationClass::class.java)
//            val name: String = annotationClass.name()
//            val id: Int = annotationClass.id()
//            println("name：$name，id：$id")
//        }


    }
}