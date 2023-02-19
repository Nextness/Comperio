package com.research.comperio.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.research.comperio.structures.ScreenHolder
import com.research.comperio.structures.onboardingStruct.OnboardingPage
import com.research.comperio.viewmodel.WelcomeViewModel

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
    onCompletion: () -> Unit,
    onSkipIntroduction: () -> Unit
) {

    val pages = listOf(
        OnboardingPage.Page01,
        OnboardingPage.Page02,
        OnboardingPage.Page03
    )

    val pagerState = rememberPagerState(pageCount = 3)

    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            pagerState = pagerState
        )
        CompletionButton(Modifier, pagerState) {
            welcomeViewModel.saveOnboardingState(completed = true)
            navController.popBackStack()
            navController.navigate(ScreenHolder.HomeScreenHolder.route)
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnboardingPage){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Image(
            modifier = Modifier,
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Description"
        )
        Text(
            modifier = Modifier,
            text = stringResource(onBoardingPage.title),
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
    }
}


@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun CompletionButton(modifier: Modifier, pagerState: PagerState, onClick: () -> Unit) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}

@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun SkipButton(modifier: Modifier, onClick: () -> Unit) {

}

// Previews

@Preview(showBackground = true)
@Composable
fun PreviewFirstOnboardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnboardingPage.Page01)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondOnboardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnboardingPage.Page02)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewThirdOnboardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnboardingPage.Page03)
    }
}
