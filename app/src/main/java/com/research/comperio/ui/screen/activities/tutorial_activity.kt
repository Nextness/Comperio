package com.research.comperio.ui.screen.activities

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.research.comperio.R
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.on_back_handler_do_nothing
import com.research.comperio.ui.common.set_screen_orientation
import com.research.comperio.theme.main_color
import com.research.comperio.view_model.init_3d_model_view_model
import io.github.sceneview.ar.ARScene

@Composable
@SuppressLint("ComposableNaming")
fun tutorial_activity(navigation_controller: NavController) {
    val init_3d_model_view_model = viewModel<init_3d_model_view_model>()
    init_3d_model_view_model.set_3d_model_location("models/sports_car.glb")
    init_3d_model_view_model.load_3d_model()

    Box(modifier = Modifier.fillMaxWidth()) {
        /* TODO: Improve back handler with pop asking if user want to go back */
        on_back_handler_do_nothing()
        set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        ARScene(
            modifier = Modifier.fillMaxSize(),
            nodes = init_3d_model_view_model.ar_nodes.collectAsState().value,
            planeRenderer = false,
            onCreate = { init_3d_model_view_model.show_3d_model() }
        )
        tutorial_activity_overlay(
            navigation_controller = navigation_controller,
            init_3d_model_view_model = init_3d_model_view_model
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("ComposableNaming")
private fun BoxScope.tutorial_activity_overlay(
    navigation_controller: NavController,
    init_3d_model_view_model: init_3d_model_view_model
) {
    Box(modifier = Modifier.matchParentSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(Color(0x55000000)),
                    onClick = {
                        navigation_controller.popBackStack()
                    },
                ) {
                    Icon(
                        painter = rememberVectorPainter(Icons.Rounded.ArrowBack),
                        contentDescription = stringResource(
                            id = R.string.comperio_logo_header_content_description_arrow_back
                        ),
                        tint = Color(0xFFFFFFFF),
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(Color(0x55000000)),
                    onClick = {

                    },
                ) {
                    Icon(
                        painter = rememberVectorPainter(Icons.Rounded.Menu),
                        contentDescription = stringResource(
                            id = R.string.comperio_logo_header_content_description_arrow_back
                        ),
                        modifier = Modifier,
                        tint = Color(0xFFFFFFFF),
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            val animation_duration = 400
            val off_set_duration = 700
            var show_button: Boolean by remember { mutableStateOf(true) }
            val button_content_alpha by animateFloatAsState(
                if (show_button) 1f else 0f,
                animationSpec = tween(durationMillis = animation_duration)
            )
            val button_color_alpha by animateColorAsState(
                if (show_button) Color(0x55000000) else Color(0x00000000),
                animationSpec = tween(durationMillis = animation_duration)
            )
            val off_set by animateIntAsState(
                if (show_button) 0 else 60, animationSpec = tween(durationMillis = off_set_duration)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
                    .offset(y = off_set.dp)
            ) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(32.dp))
                        .background(Color(0x55000000)),
                    onClick = {
                        show_button = !show_button
                    },
                ) {
                    Icon(
                        painter = rememberVectorPainter(
                            if (show_button) Icons.Rounded.ExpandMore else Icons.Rounded.ExpandLess
                        ),
                        contentDescription = null,
                        modifier = Modifier,
                        tint = Color(0xFFFFFFFF),
                    )
                }
            }
            var slider_value by remember { mutableStateOf(0f) }
            val interaction_source: MutableInteractionSource =
                remember { MutableInteractionSource() }
            var slider_value2 by remember { mutableStateOf(0f) }
            val interaction_source2: MutableInteractionSource =
                remember { MutableInteractionSource() }
            Column(
                modifier = Modifier
                    .offset(y = off_set.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(button_color_alpha)
                    .padding(16.dp)
                    .alpha(button_content_alpha),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Slider(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .height(54.dp)
                        .background(Color(0xFFFFFFFF))
                        .padding(8.dp),
                    value = init_3d_model_view_model.y.collectAsState().value,
                    valueRange = 0f..1f,
                    interactionSource = interaction_source2,
                    onValueChange = {
                        init_3d_model_view_model.update_y(it)
                        init_3d_model_view_model.model_3d_node.value.position.y = it
                    },
                    thumb = {
                        SliderDefaults.Thumb( //androidx.compose.material3.SliderDefaults
                            modifier = Modifier.padding(2.5.dp),
                            interactionSource = interaction_source2,
                            thumbSize = DpSize(15.dp, 15.dp),
                            colors = SliderDefaults.colors(thumbColor = main_color)
                        )
                    },
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF8E79F4),
                        inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                Slider(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .height(54.dp)
                        .background(Color(0xFFFFFFFF))
                        .padding(8.dp),
                    value = slider_value,
                    valueRange = -0.99f..0.99f,
                    interactionSource = interaction_source,
                    onValueChange = {
                        slider_value = it
                        init_3d_model_view_model.model_3d_node.value.position.x = it
                    },
                    thumb = {
                        SliderDefaults.Thumb( //androidx.compose.material3.SliderDefaults
                            modifier = Modifier.padding(2.5.dp),
                            interactionSource = interaction_source,
                            thumbSize = DpSize(15.dp, 15.dp),
                            colors = SliderDefaults.colors(thumbColor = main_color)
                        )
                    },
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF8E79F4),
                        inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                default_button(button_enabled = show_button,
                    button_label = R.string.tutorial_activity_label_add_model,
                    label_color = Color(0xFFFFFFFF),
                    button_color = main_color,
                    on_click = {
                        if (!init_3d_model_view_model.model_3d_node.value.isAnchored) {
                            init_3d_model_view_model.model_3d_node.value.anchor()
                        } else {
                            init_3d_model_view_model.model_3d_node.value.detachAnchor()
                        }
                    })
            }
        }
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, device = "id:pixel_5", locale = "pt")
fun preview_tutorial_activity() {
    tutorial_activity(navigation_controller = rememberNavController())
}