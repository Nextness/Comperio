package com.research.comperio.dataclass

import androidx.compose.ui.graphics.vector.ImageVector

@Suppress("ClassName")
data class bottom_navigation_item(
    val screen_name: String,
    val route: String,
    val icon: ImageVector,
    val badge_count: Int = 0
)
