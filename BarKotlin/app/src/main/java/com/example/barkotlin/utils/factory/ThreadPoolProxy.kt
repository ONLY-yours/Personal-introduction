package com.example.barkotlin.utils.factory

import java.util.concurrent.*
import kotlin.math.max

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/20
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class ThreadPoolProxy (corePoolSize: Int, maximumPoolSize: Int) {

    var mExecutor: ThreadPoolExecutor? = null
    private var mCorePoolSize = corePoolSize
    private var mMaximumPoolSize = maximumPoolSize


    /**
     * @param corePoolSize    核心池的大小
     * @param maximumPoolSize 最大线程数
     */
    fun ThreadPoolProxy(corePoolSize: Int, maximumPoolSize: Int) {
        mCorePoolSize = corePoolSize
        mMaximumPoolSize = maximumPoolSize
    }

    /**
     * 初始化ThreadPoolExecutor
     * 双重检查加锁,只有在第一次实例化的时候才启用同步机制,提高了性能
     */
    private fun initThreadPoolExecutor() {
        if (mExecutor == null || mExecutor!!.isShutdown || mExecutor!!.isTerminated) {
            synchronized(ThreadPoolProxy::class.java) {
                if (mExecutor == null || mExecutor!!.isShutdown || mExecutor!!.isTerminated) {
                    val keepAliveTime: Long = 3000
                    val unit = TimeUnit.MILLISECONDS
                    val workQueue: BlockingQueue<*> =
                        LinkedBlockingDeque<Any?>()
                    val threadFactory =
                        Executors.defaultThreadFactory()
                    val handler: RejectedExecutionHandler =
                        ThreadPoolExecutor.DiscardPolicy()
                    mExecutor = ThreadPoolExecutor(
                        mCorePoolSize, mMaximumPoolSize, keepAliveTime, unit,
                        workQueue as BlockingQueue<Runnable>?,
                        threadFactory, handler
                    )
                }
            }
        }
    }
    /**
    执行任务和提交任务的区别?
    1.有无返回值
    execute->没有返回值
    submit-->有返回值
    2.Future的具体作用?
    1.有方法可以接收一个任务执行完成之后的结果,其实就是get方法,get方法是一个阻塞方法
    2.get方法的签名抛出了异常===>可以处理任务执行过程中可能遇到的异常
     */
    /**
     * 执行任务和提交任务的区别?
     * 1.有无返回值
     * execute->没有返回值
     * submit-->有返回值
     * 2.Future的具体作用?
     * 1.有方法可以接收一个任务执行完成之后的结果,其实就是get方法,get方法是一个阻塞方法
     * 2.get方法的签名抛出了异常===>可以处理任务执行过程中可能遇到的异常
     */
    /**
     * 执行任务
     */
    fun execute(task: Runnable?) {
        initThreadPoolExecutor()
        mExecutor!!.execute(task)
    }

    /**
     * 提交任务
     */
    fun submit(task: Runnable?): Future<*>? {
        initThreadPoolExecutor()
        return mExecutor!!.submit(task)
    }

    /**
     * 移除任务
     */
    fun remove(task: Runnable?) {
        initThreadPoolExecutor()
        mExecutor!!.remove(task)
    }

}