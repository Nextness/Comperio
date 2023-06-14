package com.research.comperio.ui.screen_navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import com.research.comperio.ui.screen.activities.tutorial_activity
import com.research.comperio.ui.screen.home.account_info_screen
import com.research.comperio.ui.screen.home.home_screen
import com.research.comperio.ui.screen.home.main_screen
import com.research.comperio.ui.screen.home.notification_screen
import com.research.comperio.ui.screen.landing.landing_screen
import com.research.comperio.ui.screen.login.account_creation_screen
import com.research.comperio.ui.screen.login.login_screen
import com.research.comperio.ui.screen.splash.animated_splash

@Composable
@SuppressLint("ComposableNaming")
fun root_navigation_graph(navigation_controller: NavHostController) {
    NavHost(
        navController = navigation_controller,
        route = comperio_navigation.APP_ROOT_GRAPH.route,
        startDestination = comperio_navigation.splash.route
    ) {
        composable(route = comperio_navigation.splash.route) {
            animated_splash(navigation_controller = navigation_controller)
        }
        composable(route = comperio_navigation.landing.route) {
            landing_screen(navigation_controller = navigation_controller)
        }
        composable(route = comperio_navigation.login.route) {
            login_screen(navigation_controller = navigation_controller)
        }
        composable(route = comperio_navigation.account_creation.route) {
            account_creation_screen(navigation_controller = navigation_controller)
        }
        composable(route = comperio_navigation.BOTTOM_NAV_ROOT_GRAPH.route) {
            main_screen()
        }
    }
}

@Composable
@SuppressLint("ComposableNaming")
fun home_navigation_graph(
    navigation_controller: NavHostController,
    content_padding: PaddingValues
) {
    NavHost(
        navController = navigation_controller,
        route = comperio_navigation.BOTTOM_NAV_ROOT_GRAPH.route,
        startDestination = comperio_navigation.home.route
    ) {
        composable(route = comperio_navigation.home.route) {
            home_screen(
                navigation_controller = navigation_controller,
                content_padding = content_padding
            )
        }
        composable(route = comperio_navigation.notification.route) {
            notification_screen()
        }
        composable(route = comperio_navigation.account_info.route) {
            account_info_screen()
        }
        composable(route = comperio_navigation.tutorial_activity.route) {
            tutorial_activity(navigation_controller = navigation_controller)
        }
    }
}
