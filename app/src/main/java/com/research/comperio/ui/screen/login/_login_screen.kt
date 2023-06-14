package com.research.comperio.ui.screen.login

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.research.comperio.R
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.ui.common.comperio_padding
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.header_comperio_logo
import com.research.comperio.ui.common.set_screen_orientation
import com.research.comperio.ui.common.text_input_field
import com.research.comperio.ui.screen_navigation.comperio_navigation

@Composable
@SuppressLint("ComposableNaming")
fun login_screen(navigation_controller: NavController) {

    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val column_modifier: Modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.extended_color_scheme.background_alternative)
            .padding(
                top = comperio_padding.top,
                bottom = comperio_padding.bottom,
                start = comperio_padding.start,
                end = comperio_padding.end
            )

    Column(modifier = column_modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        header_comperio_logo(
            logo_color = MaterialTheme.extended_color_scheme.on_background_alternative,
            back_arrow = true,
            back_arrow_on_click = {
                navigation_controller.popBackStack()
            }
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.login_screen_text_action_login),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(id = R.drawable.login_application),
            contentDescription = stringResource(id = R.string.login_screen_content_description_login_image)
        )

        Spacer(modifier = Modifier.weight(1f))

        val text_modifier = Modifier
            .fillMaxWidth()
            .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp)

        Text(
            modifier = text_modifier,
            text = stringResource(id = R.string.login_screen_text_email),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        text_input_field(
            place_holder = R.string.password_text_field_place_holder_write_email,
            single_line = true,
            keyboard_type = KeyboardType.Email,
            text_input_enabled = true,
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            modifier = text_modifier,
            text = stringResource(id = R.string.login_screen_text_password),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        password_input_field()

        Spacer(modifier = Modifier.height(70.dp))

        default_button(
            button_label = R.string.login_screen_label_button_login,
            label_color = MaterialTheme.extended_color_scheme.on_background_alternative_label,
            button_color = MaterialTheme.extended_color_scheme.on_background_alternative,
            on_click = {
                navigation_controller.navigate(comperio_navigation.BOTTOM_NAV_ROOT_GRAPH.route)
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.login_screen_text_button_forgot_password),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.extended_color_scheme.primary_text_color_variation_001,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt")
fun preview_login_screen_pt() {
    login_screen(rememberNavController())
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true)
fun preview_login_screen_en() {
    login_screen(rememberNavController())
}
