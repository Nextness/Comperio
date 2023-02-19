package com.research.comperio

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
    In the manifest file, the application is initialized using this onboarding class,
    and then it is changed to the main application.
 */

@HiltAndroidApp
class Onboarding: Application()

