package com.example.barkotlin.receivers

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.example.barkotlin.bean.BluRxBean
import com.example.barkotlin.utils.ToastUtil
import org.greenrobot.eventbus.EventBus

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class BlueToothReceiver  : BroadcastReceiver() {


    private val TAG = "蓝牙广播"
    private val findDevice = 1 //查找设备

    private val findDeviceIsFinished = 2 //扫描完成

    private val findtart = 3 //开始扫描

    private val connectionSuccess = 4 //配对成功


    override fun onReceive(context: Context?, intent: Intent?) {



        when(intent?.action){
            BluetoothAdapter.ACTION_STATE_CHANGED -> {
                var blueState: Int = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0)
                when (blueState) {
                    BluetoothAdapter.STATE_TURNING_ON -> Log.d(TAG, "蓝牙打开中")
                    BluetoothAdapter.STATE_ON -> Log.e(TAG, "蓝牙打开完成")
                    BluetoothAdapter.STATE_TURNING_OFF -> Log.d(TAG, "蓝牙关闭中")
                    BluetoothAdapter.STATE_OFF -> Log.e(TAG, "蓝牙关闭完成")
                }
            }
            //找到设备
            BluetoothDevice.ACTION_FOUND -> {
                Log.d(TAG, "查找设备")
                val device = intent
                    .getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                EventBus.getDefault().post(BluRxBean( bluetoothDevice =  device,id =findDevice))
            }
            //搜索完成
            BluetoothAdapter.ACTION_DISCOVERY_FINISHED -> {
                EventBus.getDefault().post(BluRxBean(id = findDeviceIsFinished));
            }
            //开始扫描
            BluetoothAdapter.ACTION_DISCOVERY_STARTED -> {
                Log.d("开始扫描", "开始扫描")
                EventBus.getDefault().post(BluRxBean(id = findtart))
            }
            //状态改变
            BluetoothDevice.ACTION_BOND_STATE_CHANGED -> {

                var de: BluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                when (de.getBondState()) {
                    BluetoothDevice.BOND_NONE -> {

                    }
                    BluetoothDevice.BOND_BONDING -> {
                        ToastUtil.shortShow("配对中")
                    }
                    BluetoothDevice.BOND_BONDED -> {
                        ToastUtil.shortShow("配对成功");
                    }

                }
            }
        }

    }

    /**
     * 蓝牙广播过滤器
     * 蓝牙状态改变
     * 找到设备
     * 搜索完成
     * 开始扫描
     * 状态改变
     *
     * @return
     */
    fun makeFilter(): IntentFilter? {
        val filter = IntentFilter()
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED) //蓝牙状态改变的广播
        filter.addAction(BluetoothDevice.ACTION_FOUND) //找到设备的广播
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED) //搜索完成的广播
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED) //开始扫描的广播
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED) //状态改变
        return filter
    }
}