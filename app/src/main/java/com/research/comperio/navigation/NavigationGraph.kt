package com.research.comperio.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi
import com.research.comperio.screens.onboarding.OnboardingScreen
import androidx.navigation.compose.composable
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
    }
}
