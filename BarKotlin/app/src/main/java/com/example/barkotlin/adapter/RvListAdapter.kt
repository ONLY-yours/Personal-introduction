package com.example.barkotlin.adapter

import android.bluetooth.BluetoothDevice
import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.barkotlin.R

class RvListAdapter(var meslist: ArrayList<BluetoothDevice>):
    BaseQuickAdapter<BluetoothDevice, BaseViewHolder>(R.layout.item_bluetooth,meslist) {

    override fun convert(holder: BaseViewHolder, item: BluetoothDevice) {
        holder.setText(R.id.tv_bluetooth_name,item.name)
        holder.setText(R.id.tv_bluetooth_mac,item.address)
    }


}


