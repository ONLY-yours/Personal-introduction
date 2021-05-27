package com.example.barkotlin.ui.main

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barkotlin.R
import com.example.barkotlin.adapter.RvListAdapter
import com.example.barkotlin.adapter.TestAdapter
import com.example.barkotlin.manger.BltManger
import com.example.barkotlin.receivers.BlueToothReceiver
import com.example.barkotlin.utils.ToastUtil
import com.example.barkotlin.utils.factory.ThreadPoolProxyFactory
import kotlinx.android.synthetic.main.activity_blue_tooth.*


class BlueToothActivity : AppCompatActivity() {

    private val blueToothReceiver: BlueToothReceiver = BlueToothReceiver()

    var bluetoothmanger : BluetoothManager? =null
    var bluetoothadapter :BluetoothAdapter? = null

    lateinit var list :MutableList<Map<String, String>>
    lateinit var listdevice : ArrayList<BluetoothDevice>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blue_tooth)
//        initview()
//        //初始化蓝牙，判断是否能使用蓝牙
//        initbluetooth()
//        onclick()

        var namelist: MutableList<String> = arrayOf("笔记本电脑","红米手机","mi8").toMutableList()

        var adapter : TestAdapter= TestAdapter(namelist)
        rv_bluetooth_list.layoutManager = LinearLayoutManager(this)
        rv_bluetooth_list.adapter = adapter

        //item中子项点击事件注册（不要再adapter中注册，具体版本有区别，2.x是在adapter的convert中注册）
        adapter.addChildClickViewIds(R.id.tv_bluetooth_name,R.id.tv_bluetooth_mac)
        //添加具体item里子项点击事件
        adapter.setOnItemChildClickListener { adapter, view, position ->
            Log.d("click","on item child click")
            if (view.id == R.id.tv_bluetooth_name){
                ToastUtil.shortShow("您点击了name:   ${view.id}   这是第{$position}个")
            }else{
                ToastUtil.shortShow("您点击了mac:   ${view.id}   这是第{$position}个")
            }
        }

        //整个item的点击事件
        adapter.setOnItemClickListener { adapter, view, position ->
            ToastUtil.shortShow("this is onitem click : $adapter   $view    $position")
            Log.d("click","on item click")
        }

    }

    fun initview(){
        registerReceiver(blueToothReceiver, blueToothReceiver.makeFilter())
        BltManger.initBltManager(this)

        /**
         * recyclerview监听事件
         */
//        var rvadapter  = RvListAdapter(listdevice!!)
//        rv_bluetooth_list.layoutManager = LinearLayoutManager(this)
//        rv_bluetooth_list.adapter = rvadapter

    }

    fun initbluetooth(){
        bluetoothmanger = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothadapter = bluetoothmanger?.getAdapter()
        if (bluetoothadapter == null) {
            Toast.makeText(this@BlueToothActivity, "设备不支持蓝牙", Toast.LENGTH_SHORT).show()
        }

    }

    fun onclick(){
        btn_scan.setOnClickListener{
            //获取本地蓝牙名称
            //获取本地蓝牙名称
            val name = bluetoothadapter?.name

            val address = bluetoothadapter?.address
            tv_my_bluetooth.setText("本地蓝牙名称:" + name + "本地蓝牙地址:" + address)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(blueToothReceiver)
    }

}