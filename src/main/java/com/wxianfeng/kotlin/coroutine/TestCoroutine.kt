package com.wxianfeng.kotlin.coroutine

import kotlinx.coroutines.*

/**
 * Created by haomiao.wxf on 2020/06/10 11:09 AM
 */

suspend fun work(i: Int) = withContext(Dispatchers.Default) {
    Thread.sleep(1000)
    println("Work $i done")
}

fun main() {
    GlobalScope.launch {
        delay(2000)
        println("corountine")
        // return@launch
        // this.cancel()

        // throw Exception("xx")

        launch {
            work(10)
        }

        println("cant touch")
    }

    // job.cancelAndJoin()

    println("main")
    Thread.sleep(10000)
}