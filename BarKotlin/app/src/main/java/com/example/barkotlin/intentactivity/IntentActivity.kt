package com.example.barkotlin.intentactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import com.example.barkotlin.R
import kotlinx.android.synthetic.main.activity_intent.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        initview();
    }


    fun initview(){
        //设置闹钟
        btn_clock.setOnClickListener {
            var message ="this is a message"
            var hour ="3"
            var minutes="30"
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, message)
                putExtra(AlarmClock.EXTRA_HOUR, hour)
                putExtra(AlarmClock.EXTRA_MINUTES, minutes)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }



    }





    suspend fun SetTimeOutRun(){
        withContext(Dispatchers.IO){

        }
    }


}