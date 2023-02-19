package com.research.comperio.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi
import com.research.comperio.screens.onboarding.OnboardingScreen
import androidx.navigation.compose.composable
import com.research.comperio.structures.ScreenHolder


@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = ScreenHolder.OnboardingScreenHolder.route){
            OnboardingScreen(
                navController = navController,
                onCompletion = { /*TODO*/ },
                onSkipIntroduction = {/*TODO*/}
            )
        }
        composable(route = ScreenHolder.HomeScreenHolder.route) {
//            HomeScreen()
        }
    }
}