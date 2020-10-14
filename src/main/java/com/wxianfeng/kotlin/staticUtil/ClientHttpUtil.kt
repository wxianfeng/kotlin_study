package com.wxianfeng.kotlin.staticUtil

/**
 * Created by haomiao.wxf on 2020/06/08 2:34 PM
 */
object ClientHttpUtil {
    fun doGet() {
        println("doGet")
    }

    fun doPost() {
        println("doPost")
    }
}

fun main() {
    ClientHttpUtil.doGet()
    ClientHttpUtil.doPost()
}