package com.research.comperio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.research.comperio.ui.theme.ComperioTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.research.comperio.graphs.RootNavigationGraph

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This is responsible for initializing the Splash Screen.
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }

        // This is responsible for initializing the application itself.
        setContent {
            ComperioTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}
