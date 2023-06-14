package com.research.comperio.ui.common

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable @SuppressLint("ComposableNaming")
fun on_back_handler_do_nothing() = BackHandler(enabled = true, onBack = {})