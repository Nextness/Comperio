package com.research.comperio.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.research.comperio.R

val satoshi_font_family: FontFamily = FontFamily(
    Font(
        resId = R.font.satoshi_light,
        weight = FontWeight.Light,
        style = FontStyle.Normal,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_light_italic,
        weight = FontWeight.Light,
        style = FontStyle.Italic,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_regular,
        weight = FontWeight.Normal,
        style = FontStyle.Normal,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_italic,
        weight = FontWeight.Normal,
        style = FontStyle.Italic,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_medium,
        weight = FontWeight.Medium,
        style = FontStyle.Normal,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_medium_italic,
        weight = FontWeight.Medium,
        style = FontStyle.Italic,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_bold,
        weight = FontWeight.Bold,
        style = FontStyle.Normal,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_bold_italic,
        weight = FontWeight.Bold,
        style = FontStyle.Italic,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_black,
        weight = FontWeight.Black,
        style = FontStyle.Normal,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
    Font(
        resId = R.font.satoshi_black_italic,
        weight = FontWeight.Black,
        style = FontStyle.Italic,
        loadingStrategy = FontLoadingStrategy.Blocking
    ),
)