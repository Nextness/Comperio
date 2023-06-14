package com.research.comperio.ui.common

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext

/** Description:
 *  This functions was created based on code below. Perhaps some adjustments could be made later.
 *  https://stackoverflow.com/questions/69230049/how-to-force-orientation-for-some-screens-in-jetpack-compose
 *
**/

@Composable
@SuppressLint("ComposableNaming")
fun set_screen_orientation(orientation: Int) {
    val local_context: Context = LocalContext.current
    DisposableEffect(orientation) {
        val activity: Activity = local_context.find_activity() ?: return@DisposableEffect onDispose {}
        val original_orientation: Int = activity.requestedOrientation
        activity.requestedOrientation = orientation
        onDispose {
            activity.requestedOrientation = original_orientation
        }
    }
}


@Suppress("FunctionName")
fun Context.find_activity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.find_activity()
    else -> null
}
