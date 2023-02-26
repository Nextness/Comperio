package com.research.comperio.structures

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.research.comperio.R

sealed class OnboardingPage (
    @DrawableRes
    val image: Int,
    val title: Int,
    val backgroundColor: Color?
    ) {

    object Page01: OnboardingPage(
        image = R.drawable.personinmobile,
        title = R.string.onboarding_title_01,
        backgroundColor = null
    )

    object Page02: OnboardingPage(
        image = R.drawable.personinaugmentedreality,
        title = R.string.onboarding_title_02,
        backgroundColor = null
    )

    object Page03: OnboardingPage(
        image = R.drawable.personinplaying,
        title = R.string.onboarding_title_03,
        backgroundColor = null
    )
}
