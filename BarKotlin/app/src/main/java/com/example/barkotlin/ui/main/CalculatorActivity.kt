package com.example.barkotlin.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.barkotlin.R


class CalculatorActivity : AppCompatActivity() , View.OnClickListener{
 //    结果集
    private var editText: EditText? = null

    //数字1-9
    private val main_btn1: Button? = null
    private val main_btn2: Button? = null
    private val main_btn3: Button? = null
    private val main_btn4: Button? = null
    private val main_btn5: Button? = null
    private val main_btn6: Button? = null
    private val main_btn7: Button? = null
    private val main_btn8: Button? = null
    private val main_btn9: Button? = null
    private val main_btn0: Button? = null

    //运算符
    private val main_btn1a // +
            : Button? = null
    private val main_btnj // -
            : Button? = null
    private val main_btnx // *
            : Button? = null
    private val main_btnc // /
            : Button? = null
    private val main_btnd //小数点
            : Button? = null
    private val main_btn1d //=
            : Button? = null

    //清除
    private val main_btndel: Button? = null
    var clear_flag //清空标识
            = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        //数字1-9
        val main_btn1 = findViewById<View>(R.id.main_btn1)
        val main_btn2 = findViewById<View>(R.id.main_btn2)
        val main_btn3 = findViewById<View>(R.id.main_btn3)
        val main_btn4 = findViewById<View>(R.id.main_btn4)
        val main_btn5 = findViewById<View>(R.id.main_btn5)
        val main_btn6 = findViewById<View>(R.id.main_btn6)
        val main_btn7 = findViewById<View>(R.id.main_btn7)
        val main_btn8 = findViewById<View>(R.id.main_btn8)
        val main_btn9 = findViewById<View>(R.id.main_btn9)
        val main_btn0 = findViewById<View>(R.id.main_btn0)
        //运算符
        val main_btn1a = findViewById<View>(R.id.main_btn1a) // +
        val main_btnj = findViewById<View>(R.id.main_btnj) // -
        val main_btnx = findViewById<View>(R.id.main_btnx) // *
        val main_btnc = findViewById<View>(R.id.main_btnc) // /
        val main_btnd = findViewById<View>(R.id.main_btnd) //小数点
        val main_btn1d = findViewById<View>(R.id.main_btn1d) //=
        val main_btndel = findViewById<View>(R.id.main_btndel) //清空
        editText = findViewById<View>(R.id.main_et_result) as EditText //结果集


        //添加点击事件
        main_btn0.setOnClickListener(this)
        main_btn1.setOnClickListener(this)
        main_btn2.setOnClickListener(this)
        main_btn3.setOnClickListener(this)
        main_btn4.setOnClickListener(this)
        main_btn5.setOnClickListener(this)
        main_btn6.setOnClickListener(this)
        main_btn7.setOnClickListener(this)
        main_btn8.setOnClickListener(this)
        main_btn9.setOnClickListener(this)
        main_btnd.setOnClickListener(this)
        main_btndel.setOnClickListener(this)
        main_btn1a.setOnClickListener(this)
        main_btnj.setOnClickListener(this)
        main_btnx.setOnClickListener(this)
        main_btnc.setOnClickListener(this)
        main_btn1d.setOnClickListener(this)
    }

    //读取每个按钮的点击的内容
    override fun onClick(view: View) {
        //获取文本内容
        var input = editText!!.text.toString()
        when (view.id) {
            R.id.main_btn0, R.id.main_btn1, R.id.main_btn2, R.id.main_btn3, R.id.main_btn4, R.id.main_btn5, R.id.main_btn6, R.id.main_btn7, R.id.main_btn8, R.id.main_btn9, R.id.main_btnd -> {
                if (clear_flag) {
                    clear_flag = false
                    editText!!.setText("") //赋值为空
                }
                editText!!.setText(input + (view as Button).text) //结果集就为本身
            }
            R.id.main_btn1a, R.id.main_btnj, R.id.main_btnx, R.id.main_btnc -> {
                if (clear_flag) {
                    clear_flag = false
                    input = ""
                    editText!!.setText("")
                }
                editText!!.setText(input + " " + (view as Button).text + " ")
            }
            R.id.main_btndel -> if (clear_flag) {
                clear_flag = false
                input = ""
                editText!!.setText("")
            } else if (input != null || input != "") { //如果获取到的内容为空
                editText!!.setText(input.substring(0, input.length - 1)) //结果集为空
            }
            R.id.main_btn1d -> result //调用处理结果集的方法
        }
    }//如果是只输入运算符后面的数

    //运算符前没有输入数字
//如果是只输入运算符前的数
    //直接返回当前文本框的内容
//都是整形//如果是整数类型//否则执行正常是除法运算//如果被除数是0
    //则结果是0
//如果是 +//则数字都是double类型//如果包含小数点的运算//获取文本框的内容

    //进行截取
    //运算符前的数字
    //运算符
    //运算符后的数字
    //运算结果的方法
    private val result: Unit
        private get() {
            val exp = editText!!.text.toString() //获取文本框的内容
            if (exp == null || exp == "") {
                return
            }
            if (!exp.contains(" ")) {
                return
            }
            if (clear_flag) {
                clear_flag = false
                return
            }
            clear_flag = true
            var result = 0.0

            //进行截取
            //运算符前的数字
            val s1 = exp.substring(0, exp.indexOf(" "))
            //运算符
            val op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2)
            //运算符后的数字
            val s2 = exp.substring(exp.indexOf(" ") + 3)
            if (s1 != "" && s2 != "") { //如果包含小数点的运算
                val d1 = s1.toDouble() //则数字都是double类型
                val d2 = s2.toDouble()
                if (op == "+") { //如果是 +
                    result = d1 + d2
                } else if (op == "-") {
                    result = d1 - d2
                } else if (op == "*") {
                    result = d1 * d2
                } else if (op == "/") {
                    result = if (d2 == 0.0) { //如果被除数是0
                        0.0 //则结果是0
                    } else { //否则执行正常是除法运算
                        d1 / d2
                    }
                }
                if (!s1.contains(".") && !s2.contains(".") && op != "/") { //如果是整数类型
                    val r = result.toInt() //都是整形
                    editText!!.setText(r.toString() + "")
                } else {
                    editText!!.setText(result.toString() + "")
                }
            } else if (s1 != "" && s2 == "") { //如果是只输入运算符前的数
                editText!!.setText(exp) //直接返回当前文本框的内容
            } else if (s1 == "" && s2 != "") { //如果是只输入运算符后面的数
                val d2 = s2.toDouble()

                //运算符前没有输入数字
                if (op == "+") {
                    result = 0 + d2
                } else if (op == "-") {
                    result = 0 - d2
                } else if (op == "*") {
                    result = 0.0
                } else if (op == "/") {
                    result = 0.0
                }
                if (!s1.contains(".") && !s2.contains(".")) {
                    val r = result.toInt()
                    editText!!.setText(r.toString() + "")
                } else {
                    editText!!.setText(result.toString() + "")
                }
            } else {
                editText!!.setText("")
            }
        }
}
