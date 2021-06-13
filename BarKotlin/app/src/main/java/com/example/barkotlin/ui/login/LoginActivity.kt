package com.example.barkotlin.ui.login

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import com.example.barkotlin.R
import com.example.barkotlin.ui.main.HomeActivity
import com.example.barkotlin.utils.ToastUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.item_bluetooth.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
                if(et_username.length() <= 0 || et_password.length()<=0){
                    ToastUtil.show("账号密码不正确！")
                }else{
                    if (btn_login.text == "LOGIN"){
                        ToastUtil.show("登录成功")
                    }else{
                        ToastUtil.show("注册成功！ 自动帮您登录")
                    }
                    startActivity(Intent(this@LoginActivity,HomeActivity::class.java))
                }
            }
        btn_way_login.setOnClickListener{
            checkstate("login")
        }
        btn_way_regist.setOnClickListener{
            checkstate("regist")
        }
    }


    fun checkstate(way : String){
        if (way.equals("regist")){
            image_login_key.visibility = View.INVISIBLE
            image_regist_key.visibility=View.VISIBLE

            login_background.setImageResource(R.drawable.circle_gray)
            regist_background.setImageResource(R.drawable.circle_blue)

            et_varcode.visibility = View.VISIBLE

            btn_login.text = "REGIST"
        }else{
            image_login_key.visibility = View.VISIBLE
            image_regist_key.visibility=View.INVISIBLE

            login_background.setImageResource(R.drawable.circle_blue)
            regist_background.setImageResource(R.drawable.circle_gray)

            et_varcode.visibility = View.INVISIBLE

            btn_login.text = "LOGIN"
        }
    }

}