package com.wxianfeng.kotlin.klass

/**
 * @author haomiao.wxf
 * @date 2020/10/14 11:48 AM
 */
class ByLazy {
    val s: String by lazy { "wxianfeng" }
}

fun main() {
    val byLazy = ByLazy()

    print(byLazy.s)
}