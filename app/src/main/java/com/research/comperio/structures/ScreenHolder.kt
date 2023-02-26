package com.research.comperio.structures

sealed class ScreenHolder(val route: String) {
    object OnboardingScreenHolder : ScreenHolder(route = "OnboardingScreenRoute")
    object LadingLoginHolder : ScreenHolder(route = "LadingLoginHolderRoute")
    object AuthenticationHolder : ScreenHolder(route = "AuthenticationRoute")
    object HomeScreenHolder : ScreenHolder(route = "HomeScreenRoute")
}
