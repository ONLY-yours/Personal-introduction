package com.example.barkotlin.`interface`

/**
 * <pre>
 *     author : i m yours
 *     e-mail : onlyyoulove3@gmail.com
 *     time   : 2020/08/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AnnotationClass
    (val id: Int = 1, val name: String)
