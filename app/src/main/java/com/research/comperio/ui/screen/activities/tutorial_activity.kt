@file:Suppress("FunctionName")

package com.research.comperio.ui.screen.activities

import android.content.pm.ActivityInfo
import androidx.activity.compose.BackHandler
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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.ar.core.TrackingFailureReason
import com.research.comperio.R
import com.research.comperio.theme.main_color
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.dialog_box
import com.research.comperio.ui.common.set_screen_orientation
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.math.Position


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxScope.tutorial_activity_ui_elements(
    back_handler_dialog_box: MutableState<Boolean>,
    navigation_controller: NavController,
    scale: MutableState<Float>,
    is_node_anchored: MutableState<Boolean>,
    ar_nodes: MutableList<ArModelNode>
) {
    val slider_value = remember { mutableStateOf(0f) }
    val slider_value2 = remember { mutableStateOf(0f) }
    val interaction_source = remember { MutableInteractionSource() }
    val interaction_source2 = remember { MutableInteractionSource() }
    val animation_duration = 400
    val off_set_duration = 700
    val show_button = remember { mutableStateOf(true) }
    val button_content_alpha = animateFloatAsState(
        if (show_button.value) 1f else 0f,
        animationSpec = tween(durationMillis = animation_duration),
        label = ""
    )
    val button_color_alpha = animateColorAsState(
        if (show_button.value) Color(0x55000000) else Color(0x00000000),
        animationSpec = tween(durationMillis = animation_duration),
        label = ""
    )
    val off_set = animateIntAsState(
        if (show_button.value) 0 else 60,
        animationSpec = tween(durationMillis = off_set_duration),
        label = ""
    )

    Box(modifier = Modifier.matchParentSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            dialog_box(back_handler_dialog_box, navigation_controller)

            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(Color(0x55000000)),
                    onClick = {
                        back_handler_dialog_box.value = true
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
                        back_handler_dialog_box.value = true
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
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
                    .offset(y = off_set.value.dp)
            ) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(32.dp))
                        .background(Color(0x55000000)),
                    onClick = {
                        show_button.value = !show_button.value
                    },
                ) {
                    Icon(
                        painter = rememberVectorPainter(
                            if (show_button.value) Icons.Rounded.ExpandMore else Icons.Rounded.ExpandLess
                        ),
                        contentDescription = null,
                        modifier = Modifier,
                        tint = Color(0xFFFFFFFF),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .offset(y = off_set.value.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(button_color_alpha.value)
                    .padding(16.dp)
                    .alpha(button_content_alpha.value),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Slider(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .height(54.dp)
                        .background(Color(0xFFFFFFFF))
                        .padding(8.dp),
                    value = 0f,
                    valueRange = 0f..1f,
                    interactionSource = interaction_source2,
                    onValueChange = { },
                    thumb = {
                        SliderDefaults.Thumb( //androidx.compose.material3.SliderDefaults
                            modifier = Modifier.padding(2.5.dp),
                            interactionSource = interaction_source2,
                            thumbSize = DpSize(15.dp, 15.dp),
                            colors = SliderDefaults.colors(thumbColor = main_color)
                        )
                    },
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF8E79F4), inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                Slider(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .height(54.dp)
                        .background(Color(0xFFFFFFFF))
                        .padding(8.dp),
                    value = slider_value.value,
                    valueRange = -0.99f..0.99f,
                    interactionSource = interaction_source,
                    onValueChange = { },
                    thumb = {
                        SliderDefaults.Thumb( //androidx.compose.material3.SliderDefaults
                            modifier = Modifier.padding(2.5.dp),
                            interactionSource = interaction_source,
                            thumbSize = DpSize(15.dp, 15.dp),
                            colors = SliderDefaults.colors(thumbColor = main_color)
                        )
                    },
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF8E79F4), inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                default_button(
                    button_enabled = show_button.value,
                    button_label = R.string.tutorial_activity_label_add_model,
                    label_color = Color(0xFFFFFFFF),
                    button_color = main_color,
                    on_click = {
                        if (!is_node_anchored.value) {
                            for (node in ar_nodes) {
                                node.anchor()
                            }
                            is_node_anchored.value = !is_node_anchored.value
                        } else {
                            for (node in ar_nodes) {
                                node.detachAnchor()
                            }
                            is_node_anchored.value = !is_node_anchored.value
                        }
                    }
                )
            }

        }
    }
}

@Composable
fun tutorial_activity(navigation_controller: NavController) {
    val back_handler_dialog_box = remember { mutableStateOf(false) }
    val ar_nodes = remember { mutableListOf<ArModelNode>() }
    val car_node = remember { ar_node_init() }
    val scale = remember { mutableStateOf(0.05f) }
    val is_node_anchored = remember { mutableStateOf(false) }

    ar_node_load(
        car_node,
        "models/sports_car.glb",
        false,
        scale.value,
        Position(x = 0f, y = 0f, z = 0f)
    )
    ar_nodes.add(car_node.value)

    Box(modifier = Modifier.fillMaxWidth()) {
        set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        BackHandler { back_handler_dialog_box.value = true }

        ARScene(
            modifier = Modifier.fillMaxSize(),
            nodes = ar_nodes,
            planeRenderer = false,
            onTrackingFailureChanged = {
                TrackingFailureReason.EXCESSIVE_MOTION
            }
        )

        tutorial_activity_ui_elements(
            back_handler_dialog_box,
            navigation_controller,
            scale,
            is_node_anchored,
            ar_nodes
        )
    }
}

@Preview
@Composable
fun preview_tutorial_activity() {
    tutorial_activity(rememberNavController())
}
