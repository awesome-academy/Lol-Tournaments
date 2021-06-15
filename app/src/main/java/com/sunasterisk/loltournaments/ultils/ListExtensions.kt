package com.sunasterisk.loltournaments.ultils

import java.lang.StringBuilder

fun<T> List<T>.toListString(): String {
    val builder = StringBuilder()
    for (item in this) {
        builder.append(item.toString())
        builder.append(COMMA)
    }
    return builder.toString()
}

const val COMMA = ","
