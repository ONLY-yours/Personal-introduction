package com.example.barkotlin.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.barkotlin.R

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/23
 *     desc   : 测试adapter
 *     version: 1.0
 * </pre>
 */
class TestAdapter(var namelist: MutableList<String>) :
    BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_bluetooth,namelist) {

    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_bluetooth_name,item)

    }

}