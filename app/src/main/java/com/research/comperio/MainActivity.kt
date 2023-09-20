package com.research.comperio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.research.comperio.ui.screen_navigation.root_navigation_graph
import com.research.comperio.theme.ComperioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val system_ui_controller = rememberSystemUiController()
            system_ui_controller.isStatusBarVisible = false

            WindowCompat.getInsetsController(window, window.decorView).apply {
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }

            ComperioTheme {
                root_navigation_graph(
                    navigation_controller = rememberNavController()
                )
            }
        }
    }
}
