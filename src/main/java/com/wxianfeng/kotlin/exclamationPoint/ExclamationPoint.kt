package com.wxianfeng.kotlin.exclamationPoint

/**
 * Created by haomiao.wxf on 2020/06/08 3:03 PM
 */
class ExclamationPoint {
    var name: String? = null
}

fun main() {
    val exclamationPoint = ExclamationPoint()
    // name 可为 null，为 null 返回 null;
    exclamationPoint.name?.length

    // name 不能为 null，为 null 抛 KotlinNullPointerException 异常
    exclamationPoint.name!!.length
}