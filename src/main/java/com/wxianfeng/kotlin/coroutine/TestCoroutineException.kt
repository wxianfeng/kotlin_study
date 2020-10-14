package com.wxianfeng.kotlin.coroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

/**
 * Created by haomiao.wxf on 2020/06/10 7:13 PM
 */

suspend fun one1(): Int {
    // println(Thread.currentThread().name)
    delay(4000)
    return 1
}

suspend fun two1(int: Int): Int {
    // println(Thread.currentThread().name)
    delay(1000)
    throw Exception("two exception")
    return 2 + int
}


fun main() {
    // println(Thread.currentThread().name)

    // GlobalScope.launch {
    repeat(100) {
        // runBlocking {
        GlobalScope.launch(Dispatchers.IO) {
            println(Thread.currentThread().name)
            val time =

            try {/*measureTimeMillis返回给定的block代码的执行时间*/
                measureTimeMillis {
                    // val sum = withContext(Dispatchers.IO) {
                    val one = one1()
                    // return@withContext
                    val two = two1(one)
                    val sum = one + two
                    // }
                    println("两个方法返回值的和：${sum}")
                }
            } catch (e: Exception) {
                println("MyException:")
                println(e.message)
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