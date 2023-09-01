package com.research.comperio.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.research.comperio.ui.screen_navigation.navigation_bar
import com.research.comperio.theme.main_color
import com.research.comperio.dataclass.bottom_navigation_item

@Composable
@SuppressLint("ComposableNaming")
fun bottom_navigation_bar(
    navigation_controller: NavHostController,
) {
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

    if (bottom_bar_destination) {
        BottomNavigation(
            modifier = Modifier,
            elevation = 6.dp,
            backgroundColor = Color(0xFFFFFFFF)
        ) {
            screens.forEach {
                add_item(
                    screen = it,
                    current_destination = current_destination,
                    navigation_controller = navigation_controller
                )

            }
        }
    }
}


@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun RowScope.add_item(
    screen: bottom_navigation_item,
    current_destination: NavDestination?,
    navigation_controller: NavHostController
) {
    val is_selected = current_destination?.hierarchy?.any {
        it.route == screen.route
    } == true
    BottomNavigationItem(
        icon = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                if (screen.badge_count > 0) {
                    BadgedBox(
                        badge = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = null,
                                tint = if (is_selected) main_color else Color(0xFF000000)
                            )
                        },
                        content = {
                            Text(text = screen.badge_count.toString())
                        }
                    )
                    Text(
                        text = screen.screen_name,
                        fontWeight = if (is_selected) FontWeight.Bold else FontWeight.Normal,
                        color = if (is_selected) main_color else Color(0xFF000000)
                    )
                } else {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null,
                        tint = if (is_selected) main_color else Color(0xFF000000)
                    )
                    Text(
                        text = screen.screen_name,
                        fontWeight = if (is_selected) FontWeight.Bold else FontWeight.Normal,
                        color = if (is_selected) main_color else Color(0xFF000000)
                    )
                }
            }
        },
        selected = is_selected,
        selectedContentColor = main_color,
        unselectedContentColor = Color(0xFFFFFFFF),
        onClick = {
            navigation_controller.navigate(screen.route) {
                popUpTo(navigation_controller.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, device = "id:pixel_5", locale = "pt")
fun preview_bottom_navigation_bar() {
    bottom_navigation_bar(navigation_controller = rememberNavController())
}