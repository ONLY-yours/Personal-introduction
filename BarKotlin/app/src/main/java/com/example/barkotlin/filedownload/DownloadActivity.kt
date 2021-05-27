package com.example.barkotlin.filedownload

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import com.example.barkotlin.R
import kotlinx.android.synthetic.main.activity_download.*
import java.io.File


class DownloadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)
        initview();
    }

    fun initview(){
        btn_download.setOnClickListener {

        }
    }




}