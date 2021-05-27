package com.example.barkotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * <pre>
 *     author : lijunjie
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/09/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ExamFragViewPagerAdapter(var fm: FragmentManager) : FragmentPagerAdapter(fm) {

    lateinit var fr : Fragment;
    lateinit var fragmentList  : List<out Fragment>

    @JvmName("setFragmentList1")
    fun setFragmentList(fragmentList: List<out Fragment>) {
        this.fragmentList = fragmentList
    }


    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

}