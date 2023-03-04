package com.research.comperio.navigation

import android.graphics.Color
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi
import com.research.comperio.screens.onboarding.OnboardingScreen
import androidx.navigation.compose.composable
import com.research.comperio.TestLayout
import com.research.comperio.databinding.TestLayoutBinding
import com.research.comperio.screens.login.LoginLandingPage
import com.research.comperio.screens.login.LoginScreen
import com.research.comperio.structures.ScreenHolder

@Composable
@ExperimentalAnimationApi @ExperimentalPagerApi
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = ScreenHolder.OnboardingScreenHolder.route) {
            OnboardingScreen(
                navController = navController,
            )
        }

        composable(route = ScreenHolder.LadingLoginHolder.route){
            LoginLandingPage(navHostController = navController)
        }

        composable(route = ScreenHolder.AuthenticationHolder.route){
            LoginScreen(navHostController = navController)
        }

        composable(route = ScreenHolder.HomeScreenHolder.route){
            XmlLayout()
        }
    }
}

@Composable
fun XmlLayout() {
    AndroidViewBinding(factory = TestLayoutBinding::inflate)
}
