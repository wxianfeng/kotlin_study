package com.wxianfeng.kotlin.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Created by haomiao.wxf on 2020/06/10 5:30 PM
 *
 * https://blog.csdn.net/yuzhiqiang_1993/article/details/101022254
 */

suspend fun one(): Int {
    // println(Thread.currentThread().name)
    delay(4000)
    return 1
}

suspend fun two(int: Int): Int {
    // println(Thread.currentThread().name)
    delay(1000)
    return 2 + int
}


fun main() {
    // println(Thread.currentThread().name)

    // GlobalScope.launch {
    repeat(100) {
        // runBlocking {
        GlobalScope.launch(Dispatchers.IO) {
            println(Thread.currentThread().name)

            /*measureTimeMillis返回给定的block代码的执行时间*/
            val time = measureTimeMillis {
                // val sum = withContext(Dispatchers.IO) {
                    val one = one()
                    // return@withContext
                    val two = two(one)
                    val sum = one + two
                // }
                println("两个方法返回值的和：${sum}")
            }
            println("执行耗时：${time}")
        }
        println("----------------")
        /*应为上面的协程代码并不会阻塞掉线程，所以我们这里让线程睡4秒，保证线程的存活，在实际的Android开发中无需这么做*/
        // Thread.sleep(6000)
    }

    Thread.sleep(10000)
    println("main end")
}

