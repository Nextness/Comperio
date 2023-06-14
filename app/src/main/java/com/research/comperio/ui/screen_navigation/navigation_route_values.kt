package com.research.comperio.ui.screen_navigation

@Suppress("ClassName")
object graph_route {
    const val root = "root_app_navigation"
    const val splash = "splash_navigation"
    //    const val onboarding = "onboarding_navigation"
    const val landing = "landing_navigation"
    const val login = "login_navigation"
    const val account_creation = "account_creation_navigation"
    const val home = "home_navigation"
}

object navigation_bar {
    const val root = "root_navigation_bar"
    const val home = "home_navigation"
    const val notification = "notification_navigation"
    const val account_info = "account_info_navigation"
}

@Suppress("ClassName")
sealed class comperio_navigation(
    val route: String,
    val screen_name: String?
) {
    object APP_ROOT_GRAPH : comperio_navigation("root_app_navigation", null)
    object splash : comperio_navigation("splash_navigation", "Splash")
    object onboarding : comperio_navigation("onboarding_navigation", "Onboarding")
    object landing : comperio_navigation("landing_navigation", "Landing")
    object login : comperio_navigation("login_navigation", "Login")
    object account_creation : comperio_navigation("account_creation_navigation", "Account Creation")

    object BOTTOM_NAV_ROOT_GRAPH : comperio_navigation("root_bottom_nav", null)
    object home : comperio_navigation("home_navigation", "Home")
    object notification : comperio_navigation("notification_navigation", "Notification")
    object account_info : comperio_navigation("account_info_navigation", "Account Information")

    object tutorial_activity : comperio_navigation("tutorial_activity_navigation", "Tutorial Activity")
}