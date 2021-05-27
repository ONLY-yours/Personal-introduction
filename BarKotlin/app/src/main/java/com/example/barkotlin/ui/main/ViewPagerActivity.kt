package com.example.barkotlin.ui.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.barkotlin.R
import com.example.barkotlin.adapter.ExamFragViewPagerAdapter
import com.example.barkotlin.fragment.ExamLineTextFragment
import com.example.barkotlin.fragment.ExamLoadFragment
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {


    val loadFragment = ExamLoadFragment()
    var loadFragment2 = ExamLoadFragment()
    var loadFragment3 = ExamLoadFragment()
    var examLineFragment = ExamLineTextFragment()

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val fragments: List<out Fragment> = arrayListOf(loadFragment2, loadFragment3,examLineFragment)

        var adapter = ExamFragViewPagerAdapter(supportFragmentManager)


        //初始化加载界面
        initLoadingView()
        progressbar.progress =
            (((((1) * 1.0f) / (fragments.size)) * 100).toInt())
        adapter.setFragmentList(fragments)
        viewpager.adapter = adapter
        viewpager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageSelected(position: Int) {
                progressbar.progress =
                    (((((position+1) * 1.0f) / (fragments.size)) * 100).toInt())
            }

        })

    }



    fun initLoadingView(){
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_paper_fragment_container, loadFragment)
            .commit()
            showLoading()

    }

    fun showLoading(){
        var count =100
        var handler : Handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                count--
                if (count > 0) {
                    loadFragment.setLoading(100 - count)
                    Log.d("count", "" + count)
                    handler.postDelayed(this, 50)
                } else if (count == 0) {
                    fl_paper_fragment_container.visibility = View.GONE
                }
            }

        }, 50)

    }

}

