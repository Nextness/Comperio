package com.research.comperio.ui.screen.home

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.research.comperio.R
import com.research.comperio.theme.comperio_black_dark
import com.research.comperio.theme.comperio_light_background
import com.research.comperio.theme.comperio_light_gray
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.ui.common.comperio_component_corner_radius
import com.research.comperio.ui.common.comperio_dropdown_big
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.default_button_with_adjustments
import com.research.comperio.ui.common.set_screen_orientation
import com.research.comperio.ui.screen_navigation.comperio_navigation
import com.research.comperio.theme.main_color
import com.research.comperio.theme.satoshi_font_family
import com.research.comperio.ui.common.header_comperio_logo

@Composable
@SuppressLint("ComposableNaming")
fun home_screen(navigation_controller: NavController, content_padding: PaddingValues) {
    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    Column(
        verticalArrangement = Arrangement.spacedBy((-10).dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.extended_color_scheme.primary)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0x3F633AEF), Color(0x59FFFFFF)),
                        startY = 0f,
                        endY = 1000f
                    )

                )
        ) {
            Column(modifier = Modifier.padding(all = 32.dp)) {
                header_comperio_logo()
                Spacer(modifier = Modifier.height(44.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Você já pode começar\n" + "uma atividade!",
                    color = Color(0xFFFFFFFF),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(44.dp))
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .background(Color(0xFFFFFFFF))
                .padding(all = 15.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Eletromagnetismo",
                color = Color(0xFF101215),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "O eletromagnetismo é uma das forças fundamentais da natureza que lida com a interação entre campos elétricos e magnéticos. Entenda estes conceitos com atividades práticas.",
                color = Color(0xFF101215),
                style = TextStyle(
                    fontFamily = satoshi_font_family,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp
                ),
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(25.dp))
            default_button_with_adjustments(button_label = R.string.home_screen_label_tutorial,
                button_color = MaterialTheme.extended_color_scheme.primary,
                label_color = MaterialTheme.extended_color_scheme.on_primary_text_color,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(5.dp)),
                on_click = {
                    navigation_controller.navigate(route = comperio_navigation.tutorial_activity.route)
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            default_button_with_adjustments(button_label = R.string.home_screen_label_first_activity,
                button_color = MaterialTheme.extended_color_scheme.primary,
                label_color = MaterialTheme.extended_color_scheme.on_primary_text_color,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(5.dp)),
                on_click = {
                    navigation_controller.navigate(route = comperio_navigation.first_activity.route)
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            default_button_with_adjustments(button_label = R.string.home_screen_label_second_activity,
                button_color = comperio_light_background,
                label_color = comperio_black_dark,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(5.dp)),
                on_click = {})
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                text = "Não se preocupe, logo novas atividades serão adicionadas.",
                color = Color(0xFF101215),
                style = TextStyle(
                    fontFamily = satoshi_font_family,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal
            )
        }
    }
}


@Composable
@SuppressLint("ComposableNaming")
fun home_screen_future_implementation(
    navigation_controller: NavController, content_padding: PaddingValues
) {
    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    Spacer(
        modifier = Modifier
            .height(11.dp)
            .padding(content_padding)
    )
    Column(
        modifier = Modifier
            .padding(content_padding)
            .fillMaxSize()
            .background(Color(0xFFF2F3F7)),
        verticalArrangement = Arrangement.spacedBy(space = 11.dp),
        horizontalAlignment = Alignment.Start
    ) {
        activities_lazy_row()
        Column(
            modifier = Modifier
                .background(main_color)
                .padding(vertical = 20.dp, horizontal = 14.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Eletromagnetismo",
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.padding(end = 18.dp),
                text = "O eletromagnetismo é uma das forças fundamentais da natureza que lida com a interação entre campos elétricos e magnéticos.",
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(20.dp))
            default_button_with_adjustments(modifier = Modifier.width(180.dp),
                button_label = R.string.home_screen_label_start_activities,
                button_color = Color(0xFFFFFFFF),
                label_color = Color(0xFF101215),
                on_click = { navigation_controller.navigate(route = comperio_navigation.tutorial_activity.route) })
        }

    }
    alert_dialog_add_activity()
}


@Composable
@SuppressLint("ComposableNaming")
fun activities_lazy_row() {
    Column(
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .padding(vertical = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            text = "Atividades",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .fillMaxWidth()
        )
        val lazy_list_scrollbar = rememberLazyListState()

        LazyRow(
            state = lazy_list_scrollbar,
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(10.dp)
        ) {
            lazy_row_item_content()
            lazy_row_item_content()
            lazy_row_item_content()
            lazy_row_item_content()
            lazy_row_item_content()
            lazy_row_item_content()
            lazy_row_item_content()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .padding(horizontal = 14.dp)
                .simple_horizontal_scroll_bar(state = lazy_list_scrollbar)
        )
    }
}

@Suppress("FunctionName")
fun LazyListScope.lazy_row_item_content() {
    item {
        Button(shape = comperio_component_corner_radius,
            modifier = Modifier
                .width(120.dp)
                .height(130.dp)
                .dashed_border(2.dp, Color(0xFFD9DAE1), 6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF2F3F7), contentColor = Color(0xFF000000)
            ),
            content = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.add_content),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Nova Atividade",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFF76787B),
                        text = "Adicione uma nova atividade do seu interesse",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center
                    )
                }
            },
            contentPadding = PaddingValues(10.dp),
            onClick = {})
    }
}

@Suppress("FunctionName")
fun Modifier.dashed_border(strokeWidth: Dp, color: Color, cornerRadiusDp: Dp) = composed(factory = {
    val density = LocalDensity.current
    val strokeWidthPx = density.run { strokeWidth.toPx() }
    val cornerRadiusPx = density.run { cornerRadiusDp.toPx() }

    this.then(Modifier.drawWithCache {
        onDrawBehind {
            val stroke = Stroke(
                width = strokeWidthPx,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 10f), 0f)
            )
            drawRoundRect(
                color = color, style = stroke, cornerRadius = CornerRadius(cornerRadiusPx)
            )
        }
    })
})

@Suppress("FunctionName")
fun Modifier.simple_horizontal_scroll_bar(
    state: LazyListState, height: Dp = 6.dp
) = composed(factory = {

    val scroll_bar_color by animateColorAsState(
        targetValue = if (state.isScrollInProgress) Color(0xFFD9DAE1) else Color(0xFFF2F3F7),
        animationSpec = tween(durationMillis = 300)
    )

    drawWithContent {
        drawContent()

        val first_visible_element_index = state.layoutInfo.visibleItemsInfo.firstOrNull()?.index

        if (first_visible_element_index != null) {
            val element_width = this.size.width / state.layoutInfo.totalItemsCount
            val scroll_bar_offset_x = first_visible_element_index * element_width
            val scroll_bar_width = state.layoutInfo.visibleItemsInfo.size * element_width

            if (this.size.width != scroll_bar_width) {
                drawRoundRect(
                    color = scroll_bar_color,
                    topLeft = Offset(
                        x = scroll_bar_offset_x,
                        y = this.size.height - height.toPx() + 8.dp.toPx()
                    ),
                    size = Size(width = scroll_bar_width, height = height.toPx()),
                    alpha = 1f,
                    cornerRadius = CornerRadius(6.dp.toPx())
                )
            }
        }
    }
})

@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun alert_dialog_add_activity(is_open_dialog: Boolean = false) {
    var open_dialog by remember { mutableStateOf(is_open_dialog) }
    if (open_dialog) {
        AlertDialog(modifier = Modifier
            .height(350.dp)
            .width(300.dp),
            onDismissRequest = { open_dialog = false }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(Color(0xFFFFFFFF))
                    .padding(vertical = 16.dp, horizontal = 28.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Adicionar Nova Atividade",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    IconButton(onClick = { open_dialog = false }) {
                        Icon(imageVector = Icons.Rounded.Close, contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.height(28.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp),
                    text = "Curso",
                    style = MaterialTheme.typography.bodyLarge,
                    color = main_color
                )
                comperio_dropdown_big(
                    place_holder = R.string.home_screen_place_holder_course,
                    dropdown_content = listOf("Engenharia Elétrica")
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 6.dp, end = 6.dp, top = 0.dp, bottom = 4.dp),
                    text = "Classe",
                    style = MaterialTheme.typography.bodyLarge,
                    color = main_color
                )
                comperio_dropdown_big(
                    place_holder = R.string.home_screen_place_holder_class,
                    dropdown_content = listOf("Eletromagnetismo")
                )
                Spacer(modifier = Modifier.height(28.dp))
                default_button(button_label = R.string.home_screen_label_add_activity,
                    button_color = main_color,
                    label_color = Color(0xFFFFFFFF),
                    on_click = {})
            }
        }
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt")
fun preview_home_screen() {
    home_screen(navigation_controller = rememberNavController(), content_padding = PaddingValues())
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt")
fun preview_alert_dialog_add_activity() {
    alert_dialog_add_activity(true)
}
