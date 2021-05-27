package com.example.barkotlin.utils.factory

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
object ThreadPoolProxyFactory {

        var mNormalThreadPoolProxy: ThreadPoolProxy? = null
        var mDownLoadThreadPoolProxy: ThreadPoolProxy? = null

        /**
         * 得到普通线程池代理对象mNormalThreadPoolProxy
         */
        fun getNormalThreadPoolProxy(): ThreadPoolProxy? {
            if (mNormalThreadPoolProxy == null) {
                synchronized(ThreadPoolProxyFactory::class.java) {
                    if (mNormalThreadPoolProxy == null) {
                        mNormalThreadPoolProxy = ThreadPoolProxy(5, 5)
                    }
                }
            }
            return mNormalThreadPoolProxy
        }

        /**
         * 得到下载线程池代理对象mDownLoadThreadPoolProxy
         */
        fun getDownLoadThreadPoolProxy(): ThreadPoolProxy? {
            if (mDownLoadThreadPoolProxy == null) {
                synchronized(ThreadPoolProxyFactory::class.java) {
                    if (mDownLoadThreadPoolProxy == null) {
                        mDownLoadThreadPoolProxy = ThreadPoolProxy(3, 3)
                    }
                }
            }
            return mDownLoadThreadPoolProxy
        }



}