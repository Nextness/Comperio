package com.research.comperio.ui.screen.login

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.research.comperio.R
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.theme.main_color
import com.research.comperio.ui.common.comperio_dropdown_big_with_vm
import com.research.comperio.ui.common.comperio_dropdown_small_with_vm
import com.research.comperio.ui.common.comperio_padding
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.header_comperio_logo
import com.research.comperio.ui.common.set_screen_orientation
import com.research.comperio.ui.common.text_input_field_with_vm
import com.research.comperio.ui.screen_navigation.comperio_navigation
import com.research.comperio.ui.screen_navigation.graph_route
import com.research.comperio.view_model.account_creation_view_model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
@SuppressLint("ComposableNaming")
fun account_creation_one(account_creation_view_model: account_creation_view_model) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.account_creation_text_what_is_your_name_question),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.extended_color_scheme.on_background_alternative,
        )

        Spacer(modifier = Modifier.height(30.dp))

        val text_modifier = Modifier
            .fillMaxWidth()
            .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp)

        Text(
            modifier = text_modifier,
            text = stringResource(id = R.string.account_creation_text_first_name),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        text_input_field_with_vm(
            place_holder = R.string.account_creation_place_holder_first_name,
            single_line = true,
            keyboard_type = KeyboardType.Text,
            text_input_enabled = true,
            default_value = account_creation_view_model.user_first_name.collectAsState().value,
            on_change_value = {
                account_creation_view_model.update_user_first_name(it)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = text_modifier,
            text = stringResource(id = R.string.account_creation_text_last_name),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        text_input_field_with_vm(
            place_holder = R.string.account_creation_place_holder_first_name,
            single_line = true,
            keyboard_type = KeyboardType.Text,
            text_input_enabled = true,
            default_value = account_creation_view_model.user_last_name.collectAsState().value,
            on_change_value = {
                account_creation_view_model.update_user_last_name(it)
            }
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
fun account_creation_two(account_creation_view_model: account_creation_view_model) {

    val dropdown_day = IntArray(31) { it + 1 }.map { it.toString() }
    val dropdown_month = IntArray(12) { it + 1 }.map { it.toString() }
    val dropdown_year = IntArray(100) { it + 1924 }.map { it.toString() }.reversed()

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.account_creation_text_additional_information),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.extended_color_scheme.on_background_alternative,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp),
            text = stringResource(id = R.string.account_creation_text_born_date),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        Row(modifier = Modifier.fillMaxWidth()) {

            comperio_dropdown_small_with_vm(
                dropdown_content = dropdown_day,
                place_holder = R.string.account_creation_place_holder_screen_born_day,
                default_value = account_creation_view_model.user_born_date_day.collectAsState().value,
                on_select = {
                    account_creation_view_model.update_user_born_date_day(it)
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            comperio_dropdown_small_with_vm(
                dropdown_content = dropdown_month,
                place_holder = R.string.account_creation_place_holder_screen_born_month,
                default_value = account_creation_view_model.user_born_date_month.collectAsState().value,
                on_select = {
                    account_creation_view_model.update_user_born_date_month(it)
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            comperio_dropdown_small_with_vm(
                dropdown_content = dropdown_year,
                place_holder = R.string.account_creation_place_holder_screen_born_year,
                default_value = account_creation_view_model.user_born_date_year.collectAsState().value,
                on_select = {
                    account_creation_view_model.update_user_born_date_year(it)
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp),
            text = stringResource(id = R.string.account_creation_text_gender),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        comperio_dropdown_big_with_vm(
            place_holder = R.string.account_creation_place_holder_screen_gender,
            dropdown_content = listOf(
                stringResource(id = R.string.account_creation_dropdown_gender_option_1),
                stringResource(id = R.string.account_creation_dropdown_gender_option_2),
                stringResource(id = R.string.account_creation_dropdown_gender_option_3),
                stringResource(id = R.string.account_creation_dropdown_gender_option_4),
                stringResource(id = R.string.account_creation_dropdown_gender_option_5)
            ),
            default_value = account_creation_view_model.user_gender.collectAsState().value,
            on_select = {
                account_creation_view_model.update_user_gender(it)
            }
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
fun account_creation_three(account_creation_view_model: account_creation_view_model) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.account_creation_text_what_is_your_email_question),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.extended_color_scheme.on_background_alternative,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp),
            text = "E-mail",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        text_input_field_with_vm(
            place_holder = R.string.password_text_field_place_holder_write_email,
            single_line = true,
            keyboard_type = KeyboardType.Email,
            text_input_enabled = true,
            default_value = account_creation_view_model.user_email.collectAsState().value,
            on_change_value = { account_creation_view_model.update_user_email(it) }
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
fun account_creation_four(account_creation_view_model: account_creation_view_model) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.account_creation_text_create_password),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.extended_color_scheme.on_background_alternative,
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp),
            text = stringResource(id = R.string.account_creation_text_password),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        password_input_field_with_vm(
            place_holder = R.string.account_creation_place_holder_create_password,
            default_value = account_creation_view_model.user_password.collectAsState().value,
            on_value_change = { account_creation_view_model.update_user_password(it) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp),
            text = stringResource(id = R.string.account_creation_text_confirm_password),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.extended_color_scheme.on_background_alternative
        )

        password_input_field_with_vm(
            place_holder = R.string.account_creation_place_holder_confirm_password,
            default_value = account_creation_view_model.user_password_validation.collectAsState().value,
            on_value_change = {
                account_creation_view_model.update_user_password_validation(it)
            }
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
fun account_creation_five(
    navigation_controller: NavController,
    account_creation_view_model: account_creation_view_model
) {

    val user_email: String = account_creation_view_model.user_email.collectAsState().value.text

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(id = R.string.account_creation_text_successful_account_creation),
            color = MaterialTheme.extended_color_scheme.on_background_alternative,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.send_email_confirmation),
            contentDescription = stringResource(id = R.string.account_creation_content_description_confirmation_email_sent)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = stringResource(id = R.string.account_creation_text_confirmation_email_sent),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Text(
            text = user_email,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(40.dp))

        default_button(
            button_enabled = true,
            button_label = R.string.account_creation_place_holder_access_account,
            label_color = MaterialTheme.extended_color_scheme.on_background_alternative_label,
            button_color = MaterialTheme.extended_color_scheme.on_background_alternative,
            on_click = {
                navigation_controller.popBackStack()
                navigation_controller.navigate(graph_route.login)
            }
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalFoundationApi::class)
fun account_creation_screen(navigation_controller: NavController, initial_page: Int = 0) {

    val account_creation_view_model = viewModel<account_creation_view_model>()
    val pager_state: PagerState = rememberPagerState(initialPage = initial_page)
    val coroutine_scope: CoroutineScope = rememberCoroutineScope()
    val interaction_source: MutableInteractionSource = remember { MutableInteractionSource() }
    val icon_pressed: Boolean by interaction_source.collectIsPressedAsState()

    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    BackHandler(enabled = true) {
        when (pager_state.currentPage) {
            0 -> {
                navigation_controller.popBackStack()
                navigation_controller.navigate(comperio_navigation.landing.route)
            }

            in 1..3 -> {
                coroutine_scope.launch {
                    pager_state.scrollToPage(pager_state.currentPage - 1)
                }
            }

            else -> {
                navigation_controller.popBackStack()
                navigation_controller.navigate(comperio_navigation.landing.route)
            }
        }
    }

    val column_modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.extended_color_scheme.background_alternative)
            .padding(
                top = comperio_padding.top,
                bottom = comperio_padding.bottom,
                start = comperio_padding.start,
                end = comperio_padding.end
            )

    Column(
        modifier = column_modifier
    ) {

        if (pager_state.currentPage <= 3) {
            header_comperio_logo(
                logo_color = main_color,
                back_arrow = true,
                interaction_source = interaction_source,
                back_arrow_on_click = {
                    if (pager_state.currentPage == 0 && icon_pressed) {
                        navigation_controller.popBackStack()
                    }
                    if (pager_state.currentPage > 0) {
                        coroutine_scope.launch {
                            pager_state.scrollToPage(pager_state.currentPage - 1)
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(5.dp))

            horizontal_scroller_page(account_creation_view_model, pager_state)

            Spacer(modifier = Modifier.height(80.dp))
        }

        HorizontalPager(
            pageCount = account_creation_view_model.account_creation_page_count,
            state = pager_state,
            userScrollEnabled = false,
        ) { page ->
            when (page) {
                0 -> account_creation_one(account_creation_view_model = account_creation_view_model)
                1 -> account_creation_two(account_creation_view_model = account_creation_view_model)
                2 -> account_creation_three(account_creation_view_model = account_creation_view_model)
                3 -> account_creation_four(account_creation_view_model = account_creation_view_model)
                4 -> account_creation_five(
                    navigation_controller = navigation_controller,
                    account_creation_view_model = account_creation_view_model
                )
            }
        }

        if (pager_state.currentPage <= 3) {

            Spacer(modifier = Modifier.weight(1f))

            default_button(
                button_enabled = true,
                button_label = R.string.account_creation_text_continue,
                label_color = MaterialTheme.extended_color_scheme.on_background_alternative_label,
                button_color = MaterialTheme.extended_color_scheme.on_background_alternative,
                on_click = {
                    coroutine_scope.launch {
                        pager_state.scrollToPage(pager_state.currentPage + 1)
                    }
                }
            )
        }
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt", group = "Portuguese: Brazil")
fun preview_account_creation_screen_one_pt() {
    account_creation_screen(rememberNavController(), initial_page = 0)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt", group = "Portuguese: Brazil")
fun preview_account_creation_screen_two_pt() {
    account_creation_screen(rememberNavController(), initial_page = 1)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt", group = "Portuguese: Brazil")
fun preview_account_creation_screen_three_pt() {
    account_creation_screen(rememberNavController(), initial_page = 2)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt", group = "Portuguese: Brazil")
fun preview_account_creation_screen_four_pt() {
    account_creation_screen(rememberNavController(), initial_page = 3)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt", group = "Portuguese: Brazil")
fun preview_account_creation_screen_five_pt() {
    account_creation_screen(rememberNavController(), initial_page = 4)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, group = "English: United States")
fun preview_account_creation_screen_one_en() {
    account_creation_screen(rememberNavController(), initial_page = 0)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, group = "English: United States")
fun preview_account_creation_screen_two_en() {
    account_creation_screen(rememberNavController(), initial_page = 1)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, group = "English: United States")
fun preview_account_creation_screen_three_en() {
    account_creation_screen(rememberNavController(), initial_page = 2)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, group = "English: United States"
)
fun preview_account_creation_screen_four_en() {
    account_creation_screen(rememberNavController(), initial_page = 3)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, group = "English: United States")
fun preview_account_creation_screen_five_en() {
    account_creation_screen(rememberNavController(), initial_page = 4)
}
