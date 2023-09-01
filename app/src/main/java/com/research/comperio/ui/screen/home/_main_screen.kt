package com.research.comperio.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.research.comperio.R
import com.research.comperio.dataclass.bottom_navigation_item
import com.research.comperio.ui.screen_navigation.home_navigation_graph
import com.research.comperio.ui.screen_navigation.navigation_bar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ComposableNaming")
fun main_screen(navigation_controller: NavHostController = rememberNavController()) {
    /* TODO: Remove this duplicate code and refactor everything for a better alternative */
    val screens: List<bottom_navigation_item> = listOf(
        bottom_navigation_item(
            screen_name = "Início",
            route = navigation_bar.home,
            icon = Icons.Rounded.Home
        ),
        // bottom_navigation_item(
        //     screen_name = "Notificações",
        //     route = navigation_bar.notification,
        //     icon = Icons.Rounded.Notifications
        // ),
        // bottom_navigation_item(
        //     screen_name = "Conta",
        //     route = navigation_bar.account_info,
        //     icon = Icons.Rounded.AccountCircle
        // )
    )
    val navigation_back_stack_entry by navigation_controller.currentBackStackEntryAsState()
    val current_destination = navigation_back_stack_entry?.destination
    val bottom_bar_destination = screens.any { it.route == current_destination?.route }

    Scaffold(
        modifier = Modifier.background(Color(0xFFF2F3F7)),
        // topBar = {
        //     if (bottom_bar_destination) {
        //         TopAppBar(
        //             modifier = Modifier
        //                 .fillMaxWidth()
        //                 .height(60.dp)
        //                 .padding(bottom = 11.dp),
        //             elevation = 6.dp,
        //             backgroundColor = Color(0xFFFFFFFF),
        //             contentPadding = PaddingValues(0.dp)
        //         ) {
        //             Image(
        //                 modifier = Modifier
        //                     .padding(start = 14.dp)
        //                     .size(32.dp),
        //                 painter = painterResource(id = R.drawable.comperio_logo_official),
        //                 contentDescription = "Something"
        //             )
        //         }
        //     }
        // },
        bottomBar = { bottom_navigation_bar(navigation_controller = navigation_controller) }
    ) { padding ->
        home_navigation_graph(
            navigation_controller = navigation_controller,
            content_padding = padding
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, device = "id:pixel_5", locale = "pt")
fun preview_main_screen() {
    main_screen()
}