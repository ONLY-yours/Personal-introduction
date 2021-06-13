package com.example.barkotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.amap.api.maps.AMap
import com.amap.api.maps.MapView
import com.example.barkotlin.R
import kotlinx.android.synthetic.main.activity_message_add.*
import java.util.*


class MessageAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_add)

        btn_add.setOnClickListener {
            addEvent(""+add_thing.text,""+add_location.text)
        }
    }

    fun addEvent(title: String, location: String, begin: Long = java.util.Calendar.getInstance().timeInMillis, end: Long = java.util.Calendar.getInstance().timeInMillis + 30000) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}


