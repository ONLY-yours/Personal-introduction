package com.example.barkotlin.bean

import android.bluetooth.BluetoothDevice

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/19
 *     desc   :eventbus传输的信息体
 *     version: 1.0
 * </pre>
 */

data class BluRxBean (
    var id: Int?=0,
    var bluetoothDevice: BluetoothDevice? = null
)

