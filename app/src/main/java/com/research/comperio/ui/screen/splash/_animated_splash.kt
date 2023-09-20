package com.research.comperio.ui.screen.splash

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.navigation.NavController
import com.research.comperio.R
import com.research.comperio.ui.common.set_screen_orientation
import com.research.comperio.ui.screen_navigation.graph_route
import kotlinx.coroutines.delay

@Composable
@SuppressLint("ComposableNaming")
fun animated_splash(navigation_controller: NavController) {
    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    var start_animation: Boolean by remember {
        mutableStateOf(false)
    }
    val alpha_animation by animateFloatAsState(
        targetValue = if (start_animation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect(key1 = true) {
        start_animation = true
        delay(1500)
        navigation_controller.popBackStack()
        navigation_controller.navigate(graph_route.landing)
    }
    splash(alpha_animation)
}

@Composable
@SuppressLint("ComposableNaming")
fun splash(alpha: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha),
            painter = painterResource(id = R.drawable.comperio_logo_official),
            contentDescription = "Something"
        )
    }
}
