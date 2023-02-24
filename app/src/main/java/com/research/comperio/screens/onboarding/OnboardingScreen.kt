package com.research.comperio.screens.onboarding

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.research.comperio.R
import com.research.comperio.structures.ScreenHolder
import com.research.comperio.structures.onboardingStruct.OnboardingPage
import com.research.comperio.ui.common.ComperioLogoInScreen
import com.research.comperio.viewmodel.WelcomeViewModel

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val pagerState = rememberPagerState(pageCount = 3)
    val pages = listOf(
        OnboardingPage.Page01,
        OnboardingPage.Page02,
        OnboardingPage.Page03
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            ComperioLogoInScreen(
                show = true,
                logoColor = MaterialTheme.colors.primary,
                modifier = Modifier.padding(end = 32.dp, top = 32.dp)
            )

            Spacer(modifier = Modifier.size(5.dp))

            HorizontalPagerIndicator(
                modifier = Modifier.padding(end = 32.dp),
                activeColor = MaterialTheme.colors.primary,
                inactiveColor = Color(0xFFD9DAE1),
                pagerState = pagerState
            )
        }

        Spacer(modifier = Modifier.size(144.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HorizontalPager(
                modifier = Modifier,
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically
            ) { position ->
                PagerScreen(onBoardingPage = pages[position])
            }

            Spacer(modifier = Modifier.size(70.dp))

            Button(
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .width(326.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                ),
                onClick = {
                    welcomeViewModel.saveOnboardingState(completed = true)
                    navController.popBackStack()
                    navController.navigate(ScreenHolder.HomeScreenHolder.route)
                }
            ) {
                Text(
                    text = stringResource(id = R.string.onboarding_completion_button),
                    style = MaterialTheme.typography.button
                )
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnboardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            modifier = Modifier
                .align(CenterHorizontally)
                .height(226.dp)
                .padding(horizontal = 32.dp),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Description"
        )

        Spacer(modifier = Modifier.size(70.dp))

        Text(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(vertical = 32.dp, horizontal = 10.dp)
                .width(326.dp),
            text = stringResource(onBoardingPage.title),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Left
        )
    }
}
