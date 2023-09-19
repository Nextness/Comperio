package com.research.comperio.common

import kotlin.math.floor

fun Float.format(digits: Int) = "%.${digits}f".format(this)
