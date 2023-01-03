package com.research.comperio.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.research.comperio.screen.LoginContent

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginContent(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.Signup.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }
            )
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen("LOGIN")
    object Signup : AuthScreen("SIGN_UP")
    object Forgot : AuthScreen("FORGOT")
}
