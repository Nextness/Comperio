package com.research.comperio.ui.common

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.research.comperio.theme.disabled_foreground
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.theme.main_color
import com.research.comperio.theme.main_dark

internal const val component_height: Int = 54
internal const val component_padding: Int = 32


@Suppress("ClassName")
internal data class default_padding(
    var top: Dp = Dp(value = 32f),
    var bottom: Dp = Dp(value = 64f),
    var start: Dp = Dp(value = 32f),
    var end: Dp = Dp(value = 32f)
)

internal val comperio_component_corner_radius: Shape = RoundedCornerShape(Dp(value = 6f))
internal val comperio_padding: default_padding = default_padding()

data class Text_field_default_colors(
    val text_color: Color = main_dark,
    val unfocused_label_color: Color = disabled_foreground,
    val unfocused_border_color: Color = disabled_foreground,
    val placeholder_color: Color = disabled_foreground,
    val focused_border_color: Color = main_color
)
