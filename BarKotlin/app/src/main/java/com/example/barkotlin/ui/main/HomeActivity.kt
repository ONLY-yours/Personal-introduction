package com.example.barkotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.barkotlin.R
import com.example.barkotlin.utils.ToastUtil
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val toggle = ActionBarDrawerToggle(
            this, drawlayout, R.string.draw_open, R.string.drwa_close
        )

        toggle.syncState()
//        drawlayout.setOnDragListener(toggle)

        fab.setOnClickListener{
//            startActivity(Intent(this, BlueToothActivity::class.java))
            startActivity(Intent(this, MessageAddActivity::class.java))
        }

//        iv_cardview_demo
        var roundconners :RoundedCorners = RoundedCorners(360)
        var optin : RequestOptions = RequestOptions.bitmapTransform(roundconners).override(200, 200)
        Glide.with(this@HomeActivity)
            .load(R.mipmap.cardview_demo)
            .apply(optin)
            .into(iv_cardview_demo)

        navigation.getHeaderView(0).setOnClickListener {
            ToastUtil.shortShow("您点击的是头部！")
            startActivity(Intent(HomeActivity@this,ViewPagerActivity::class.java))
        }


        navigation.setNavigationItemSelectedListener {
            ToastUtil.shortShow(it.title.toString())
            if (it.title.toString().equals("信息")){
                startActivity(Intent(this@HomeActivity,CustomViewActivity::class.java))
            }
            true
        }

    }

    }
