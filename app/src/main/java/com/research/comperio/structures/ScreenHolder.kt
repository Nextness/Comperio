package com.research.comperio.structures

sealed class ScreenHolder(val route: String) {
    object OnboardingScreenHolder: ScreenHolder(route = "OnboardingScreenRoute")
    object HomeScreenHolder: ScreenHolder(route = "HomeScreenRoute")
}
