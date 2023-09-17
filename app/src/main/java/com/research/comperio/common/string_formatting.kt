package com.research.comperio.common

fun Float.format(digits: Int) = "%.${digits}f".format(this)
