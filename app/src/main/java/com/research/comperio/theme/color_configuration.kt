package com.research.comperio.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

@Suppress("ClassName")
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class comperio_exclusive

@Suppress("ClassName")
data class comperio_color_scheme(
    // ---------------------------------------------
    @comperio_exclusive val background_hero: Color,
    @comperio_exclusive val on_background_hero: Color,
    @comperio_exclusive val on_background_hero_label: Color,
    @comperio_exclusive val background_alternative: Color,
    @comperio_exclusive val on_background_alternative: Color,
    @comperio_exclusive val on_background_alternative_label: Color,
    // ---------------------------------------------
    @comperio_exclusive val on_primary_text_color: Color,
    @comperio_exclusive val primary_text_color_variation_001: Color,
    // Text Field Defaults -------------------------
    @comperio_exclusive val focused_text_color: Color,
    @comperio_exclusive val focused_container_color: Color,
    @comperio_exclusive val focused_border_color: Color,
    @comperio_exclusive val focused_placeholder_color: Color,
    @comperio_exclusive val unfocused_text_color: Color,
    @comperio_exclusive val unfocused_container_color: Color,
    @comperio_exclusive val unfocused_border_color: Color,
    @comperio_exclusive val unfocused_placeholder_color: Color,
    @comperio_exclusive val disabled_text_Color: Color,
    @comperio_exclusive val disabled_container_color: Color,


    // ---------------------------------------------
    val material_theme: ColorScheme,
) {
    val primary: Color get() = material_theme.primary
    val onPrimary: Color get() = material_theme.onPrimary
    val primaryContainer: Color get() = material_theme.primaryContainer
    val onPrimaryContainer: Color get() = material_theme.onPrimaryContainer
    val inversePrimary: Color get() = material_theme.inversePrimary
    val secondary: Color get() = material_theme.secondary
    val onSecondary: Color get() = material_theme.onSecondary
    val secondaryContainer: Color get() = material_theme.secondaryContainer
    val onSecondaryContainer: Color get() = material_theme.onSecondaryContainer
    val tertiary: Color get() = material_theme.tertiary
    val onTertiary: Color get() = material_theme.onTertiary
    val tertiaryContainer: Color get() = material_theme.tertiaryContainer
    val onTertiaryContainer: Color get() = material_theme.onTertiaryContainer
    val background: Color get() = material_theme.background
    val onBackground: Color get() = material_theme.onBackground
    val surface: Color get() = material_theme.surface
    val onSurface: Color get() = material_theme.onSurface
    val surfaceVariant: Color get() = material_theme.surfaceVariant
    val onSurfaceVariant: Color get() = material_theme.onSurfaceVariant
    val surfaceTint: Color get() = material_theme.surfaceTint
    val inverseSurface: Color get() = material_theme.inverseSurface
    val inverseOnSurface: Color get() = material_theme.inverseOnSurface
    val error: Color get() = material_theme.error
    val onError: Color get() = material_theme.onError
    val errorContainer: Color get() = material_theme.errorContainer
    val onErrorContainer: Color get() = material_theme.onErrorContainer
    val outline: Color get() = material_theme.outline
    val outlineVariant: Color get() = material_theme.outlineVariant
    val scrim: Color get() = material_theme.scrim
}