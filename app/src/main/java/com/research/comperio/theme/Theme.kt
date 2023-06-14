package com.research.comperio.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

private val set_light_colors = comperio_color_scheme(
    // ---------------------------------------------
    background_hero = comperio_purple_light_primary,
    on_background_hero = comperio_purple_dark,
    on_background_hero_label = comperio_white,
    background_alternative = comperio_white,
    on_background_alternative = comperio_purple_light_primary,
    on_background_alternative_label = comperio_white,
    // ---------------------------------------------
    on_primary_text_color = comperio_white,
    primary_text_color_variation_001 = comperio_purple_light_001,
    // Text Field Defaults -------------------------
    focused_text_color = comperio_black_light,
    focused_container_color = comperio_white,
    focused_border_color = comperio_purple_light_primary,
    focused_placeholder_color = comperio_light_gray,
    unfocused_text_color = comperio_black_light,
    unfocused_container_color = comperio_white,
    unfocused_border_color = comperio_light_gray,
    unfocused_placeholder_color = comperio_light_gray,
    disabled_text_Color = comperio_light_gray_002,
    disabled_container_color = comperio_light_gray_001,
    // Material Theme Defaults ---------------------
    material_theme = lightColorScheme(
        primary = comperio_purple_light_primary,
        onPrimary = comperio_white,
        primaryContainer = comperio_white,
        onPrimaryContainer = comperio_black_dark
    ),
)


private val local_colors = staticCompositionLocalOf { set_light_colors }

@Composable
fun ComperioTheme(
    is_dark_theme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val is_dynamic_color_available: Boolean =
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    // Make this better.
    val colorScheme = when {
//        is_dynamic_color_available -> {
//            if (is_dark_theme) dynamicDarkColorScheme(LocalContext.current)
//            else dynamicLightColorScheme(LocalContext.current)
//        }

//        is_dark_theme -> DarkColorScheme
        else -> set_light_colors
    }

    // Make this better
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, window.decorView).apply {
                systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    CompositionLocalProvider(local_colors provides colorScheme) {
        MaterialTheme(
            colorScheme = colorScheme.material_theme,
            typography = comperio_typography,
            content = content
        )
    }
}

// Improve how to handle dark colors
val MaterialTheme.extended_color_scheme: comperio_color_scheme
    @Composable @ReadOnlyComposable
    get() = local_colors.current

