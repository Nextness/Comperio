package com.research.comperio.ui.screen.landing

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.research.comperio.R
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.ui.common.comperio_padding
import com.research.comperio.ui.common.component_height
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.header_comperio_logo
import com.research.comperio.ui.common.set_screen_orientation
import com.research.comperio.ui.screen.login.create_new_account_text
import com.research.comperio.ui.screen_navigation.comperio_navigation
import com.research.comperio.ui.screen_navigation.graph_route

@Composable
@SuppressLint("ComposableNaming")
fun landing_screen(navigation_controller: NavController) {

    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val column_modifier: Modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.extended_color_scheme.background_hero)
            .padding(
                top = comperio_padding.top,
                bottom = comperio_padding.bottom,
                start = comperio_padding.start,
                end = comperio_padding.end
            )

    Column(modifier = column_modifier) {

        header_comperio_logo()

        Spacer(modifier = Modifier.weight(1f))

        val landing_screen_animation = LottieCompositionSpec.RawRes(R.raw.landing_illustration)
        val lading_illustration by rememberLottieComposition(landing_screen_animation)
        val progress by animateLottieCompositionAsState(
            composition = lading_illustration,
            iterations = LottieConstants.IterateForever
        )
        LottieAnimation(
            modifier = Modifier.size(400.dp),
            composition = lading_illustration,
            progress = { progress }
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.landing_screen_text_hero_message),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.extended_color_scheme.on_primary_text_color
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.fillMaxWidth().height(component_height.dp),
            text = stringResource(id = R.string.landing_screen_text_action),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.extended_color_scheme.on_primary_text_color
        )

        Spacer(modifier = Modifier.height(20.dp))

        default_button(
            button_label = R.string.landing_screen_text_button_start,
            label_color = MaterialTheme.extended_color_scheme.on_primary_text_color,
            button_color = MaterialTheme.extended_color_scheme.on_background_hero,
            on_click = {
                navigation_controller.navigate(/*graph_route.login*/comperio_navigation.BOTTOM_NAV_ROOT_GRAPH.route)
            }
        )

        // create_new_account_text(
        //     on_click_text = {
        //         navigation_controller.navigate(graph_route.account_creation)
        //     }
        // )
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt")
fun preview_landing_screen_pt() {
    landing_screen(rememberNavController())
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true)
fun preview_landing_screen_en() {
    landing_screen(rememberNavController())
}
