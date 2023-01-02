package com.research.comperio.screen

sealed class Screens(val route: String) {
    object Onboarding: Screens("onboarding_screen")
    object Authentication: Screens("authentication_screen")
    object Home: Screens("home_screen")
}