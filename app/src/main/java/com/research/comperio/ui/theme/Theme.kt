package com.research.comperio.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = BasePrimary,
//    onPrimary = ,
//    primaryContainer = ,
//    onPrimaryContainer = ,
//    inversePrimary = ,
    secondary = BaseSecondary,
//    onSecondary = ,
//    secondaryContainer = ,
//    onSecondaryContainer = ,
    tertiary = BaseTertiary,
//    onTertiary = ,
//    tertiaryContainer = ,
//    onTertiaryContainer = ,
//    background = ,
//    onBackground = ,
//    surface = ,
//    onSurface = ,
//    surfaceVariant = ,
//    onSurfaceVariant = ,
//    inverseSurface = ,
//    inverseOnSurface = ,
    error = BaseError,
//    onError = ,
//    errorContainer = ,
//    onErrorContainer = ,
//    outline =
)

// TODO: Better handle colors below.
// MaterialTheme Neutral Colors
@Suppress("unused") @get:Composable val Colors.Neutral:   Color get() = BaseNeutral
@Suppress("unused") @get:Composable val Colors.Neutral99: Color get() = BaseNeutral99
@Suppress("unused") @get:Composable val Colors.Neutral95: Color get() = BaseNeutral95
@Suppress("unused") @get:Composable val Colors.Neutral90: Color get() = BaseNeutral90
@Suppress("unused") @get:Composable val Colors.Neutral80: Color get() = BaseNeutral80
@Suppress("unused") @get:Composable val Colors.Neutral70: Color get() = BaseNeutral70
@Suppress("unused") @get:Composable val Colors.Neutral60: Color get() = BaseNeutral60
@Suppress("unused") @get:Composable val Colors.Neutral50: Color get() = BaseNeutral50
@Suppress("unused") @get:Composable val Colors.Neutral40: Color get() = BaseNeutral40
@Suppress("unused") @get:Composable val Colors.Neutral30: Color get() = BaseNeutral30
@Suppress("unused") @get:Composable val Colors.Neutral20: Color get() = BaseNeutral20
@Suppress("unused") @get:Composable val Colors.Neutral10: Color get() = BaseNeutral10

// MaterialTheme Neutral Variant Colors
@Suppress("unused") @get:Composable val Colors.NeutralVariant:   Color get() = BaseNeutralVariant
@Suppress("unused") @get:Composable val Colors.NeutralVariant99: Color get() = BaseNeutralVariant99
@Suppress("unused") @get:Composable val Colors.NeutralVariant95: Color get() = BaseNeutralVariant95
@Suppress("unused") @get:Composable val Colors.NeutralVariant90: Color get() = BaseNeutralVariant90
@Suppress("unused") @get:Composable val Colors.NeutralVariant80: Color get() = BaseNeutralVariant80
@Suppress("unused") @get:Composable val Colors.NeutralVariant70: Color get() = BaseNeutralVariant70
@Suppress("unused") @get:Composable val Colors.NeutralVariant60: Color get() = BaseNeutralVariant60
@Suppress("unused") @get:Composable val Colors.NeutralVariant50: Color get() = BaseNeutralVariant50
@Suppress("unused") @get:Composable val Colors.NeutralVariant40: Color get() = BaseNeutralVariant40
@Suppress("unused") @get:Composable val Colors.NeutralVariant30: Color get() = BaseNeutralVariant30
@Suppress("unused") @get:Composable val Colors.NeutralVariant20: Color get() = BaseNeutralVariant20
@Suppress("unused") @get:Composable val Colors.NeutralVariant10: Color get() = BaseNeutralVariant10

// MaterialTheme Primary Colors
@Suppress("unused") @get:Composable val Colors.Primary99: Color get() = BasePrimary99
@Suppress("unused") @get:Composable val Colors.Primary95: Color get() = BasePrimary95
@Suppress("unused") @get:Composable val Colors.Primary90: Color get() = BasePrimary90
@Suppress("unused") @get:Composable val Colors.Primary80: Color get() = BasePrimary80
@Suppress("unused") @get:Composable val Colors.Primary70: Color get() = BasePrimary70
@Suppress("unused") @get:Composable val Colors.Primary60: Color get() = BasePrimary60
@Suppress("unused") @get:Composable val Colors.Primary50: Color get() = BasePrimary50
@Suppress("unused") @get:Composable val Colors.Primary40: Color get() = BasePrimary40
@Suppress("unused") @get:Composable val Colors.Primary30: Color get() = BasePrimary30
@Suppress("unused") @get:Composable val Colors.Primary20: Color get() = BasePrimary20
@Suppress("unused") @get:Composable val Colors.Primary10: Color get() = BasePrimary10

// MaterialTheme Secondary Colors
@Suppress("unused") @get:Composable val Colors.Secondary99: Color get() = BaseSecondary99
@Suppress("unused") @get:Composable val Colors.Secondary95: Color get() = BaseSecondary95
@Suppress("unused") @get:Composable val Colors.Secondary90: Color get() = BaseSecondary90
@Suppress("unused") @get:Composable val Colors.Secondary80: Color get() = BaseSecondary80
@Suppress("unused") @get:Composable val Colors.Secondary70: Color get() = BaseSecondary70
@Suppress("unused") @get:Composable val Colors.Secondary60: Color get() = BaseSecondary60
@Suppress("unused") @get:Composable val Colors.Secondary50: Color get() = BaseSecondary50
@Suppress("unused") @get:Composable val Colors.Secondary40: Color get() = BaseSecondary40
@Suppress("unused") @get:Composable val Colors.Secondary30: Color get() = BaseSecondary30
@Suppress("unused") @get:Composable val Colors.Secondary20: Color get() = BaseSecondary20
@Suppress("unused") @get:Composable val Colors.Secondary10: Color get() = BaseSecondary10

// MaterialTheme Tertiary Colors
@Suppress("unused") @get:Composable val Colors.Tertiary99: Color get() = BaseTertiary99
@Suppress("unused") @get:Composable val Colors.Tertiary95: Color get() = BaseTertiary95
@Suppress("unused") @get:Composable val Colors.Tertiary90: Color get() = BaseTertiary90
@Suppress("unused") @get:Composable val Colors.Tertiary80: Color get() = BaseTertiary80
@Suppress("unused") @get:Composable val Colors.Tertiary70: Color get() = BaseTertiary70
@Suppress("unused") @get:Composable val Colors.Tertiary60: Color get() = BaseTertiary60
@Suppress("unused") @get:Composable val Colors.Tertiary50: Color get() = BaseTertiary50
@Suppress("unused") @get:Composable val Colors.Tertiary40: Color get() = BaseTertiary40
@Suppress("unused") @get:Composable val Colors.Tertiary30: Color get() = BaseTertiary30
@Suppress("unused") @get:Composable val Colors.Tertiary20: Color get() = BaseTertiary20
@Suppress("unused") @get:Composable val Colors.Tertiary10: Color get() = BaseTertiary10

// MaterialTheme Blue Colors
@Suppress("unused") @get:Composable val Colors.Blue: Color get() = BaseBlue
@Suppress("unused") @get:Composable val Colors.Blue99: Color get() = BaseBlue99
@Suppress("unused") @get:Composable val Colors.Blue95: Color get() = BaseBlue95
@Suppress("unused") @get:Composable val Colors.Blue90: Color get() = BaseBlue90
@Suppress("unused") @get:Composable val Colors.Blue80: Color get() = BaseBlue80
@Suppress("unused") @get:Composable val Colors.Blue70: Color get() = BaseBlue70
@Suppress("unused") @get:Composable val Colors.Blue60: Color get() = BaseBlue60
@Suppress("unused") @get:Composable val Colors.Blue50: Color get() = BaseBlue50
@Suppress("unused") @get:Composable val Colors.Blue40: Color get() = BaseBlue40
@Suppress("unused") @get:Composable val Colors.Blue30: Color get() = BaseBlue30
@Suppress("unused") @get:Composable val Colors.Blue20: Color get() = BaseBlue20
@Suppress("unused") @get:Composable val Colors.Blue10: Color get() = BaseBlue10

// MaterialTheme Yellow Colors
@Suppress("unused") @get:Composable val Colors.Yellow: Color get() = BaseYellow
@Suppress("unused") @get:Composable val Colors.Yellow99: Color get() = BaseYellow99
@Suppress("unused") @get:Composable val Colors.Yellow95: Color get() = BaseYellow95
@Suppress("unused") @get:Composable val Colors.Yellow90: Color get() = BaseYellow90
@Suppress("unused") @get:Composable val Colors.Yellow80: Color get() = BaseYellow80
@Suppress("unused") @get:Composable val Colors.Yellow70: Color get() = BaseYellow70
@Suppress("unused") @get:Composable val Colors.Yellow60: Color get() = BaseYellow60
@Suppress("unused") @get:Composable val Colors.Yellow50: Color get() = BaseYellow50
@Suppress("unused") @get:Composable val Colors.Yellow40: Color get() = BaseYellow40
@Suppress("unused") @get:Composable val Colors.Yellow30: Color get() = BaseYellow30
@Suppress("unused") @get:Composable val Colors.Yellow20: Color get() = BaseYellow20
@Suppress("unused") @get:Composable val Colors.Yellow10: Color get() = BaseYellow10

// MaterialTheme Error Colors
@Suppress("unused") @get:Composable val Colors.Error99: Color get() = BaseError99
@Suppress("unused") @get:Composable val Colors.Error95: Color get() = BaseError95
@Suppress("unused") @get:Composable val Colors.Error90: Color get() = BaseError90
@Suppress("unused") @get:Composable val Colors.Error80: Color get() = BaseError80
@Suppress("unused") @get:Composable val Colors.Error70: Color get() = BaseError70
@Suppress("unused") @get:Composable val Colors.Error60: Color get() = BaseError60
@Suppress("unused") @get:Composable val Colors.Error50: Color get() = BaseError50
@Suppress("unused") @get:Composable val Colors.Error40: Color get() = BaseError40
@Suppress("unused") @get:Composable val Colors.Error30: Color get() = BaseError30
@Suppress("unused") @get:Composable val Colors.Error20: Color get() = BaseError20
@Suppress("unused") @get:Composable val Colors.Error10: Color get() = BaseError10

// Contour color used for different outlines, icons that are white or black, etc..
// TODO: To comply with the design system, the colors white and black might change...
@get:Composable
val Colors.Contour: Color
    get() = if (isLight) BaseWhite else BaseBlack

// Logic to see if the system theme is dark or light version.
@Composable
fun ComperioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    val systemUiController = rememberSystemUiController()
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme

            // TODO: When the theme is set to light, the color should be white,
            //  else when the theme is set to dark, the color must match the
            //  dark theme (probably purple).
            systemUiController.setStatusBarColor(color = Color.White)
        }
    }



    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
