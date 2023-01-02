package com.research.comperio.structures

import androidx.annotation.DrawableRes
import com.research.comperio.R

sealed class OnboardingPage(
    @DrawableRes
    val Image: Int,
    val Title: String,
    val Description: String
) {
    object FirstPage: OnboardingPage(
        Image = R.drawable.splashscreen,
        Title = "First Page",
        Description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sed luctus urna."
    )

    object SecondPage: OnboardingPage(
        Image = R.drawable.splashscreen,
        Title = "Second Page",
        Description = "Fusce dolor tellus, volutpat iaculis ligula ut, varius tristique odio."
    )

    object ThirdPage: OnboardingPage(
        Image = R.drawable.splashscreen,
        Title = "Third Page",
        Description = " Phasellus lacinia nunc quis enim varius, at suscipit sapien pellentesque."
    )
}
