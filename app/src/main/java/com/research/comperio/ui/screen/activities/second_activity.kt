@file:Suppress("FunctionName")

package com.research.comperio.ui.screen.activities

import android.content.pm.ActivityInfo
import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.RestartAlt
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.ar.core.TrackingFailureReason
import com.research.comperio.R
import com.research.comperio.common.format
import com.research.comperio.theme.main_color
import com.research.comperio.theme.transparent
import com.research.comperio.ui.common.component_height
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.dialog_box
import com.research.comperio.ui.common.set_screen_orientation
import dev.romainguy.kotlin.math.Float3
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.math.Position


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BoxScope.second_activity_ui_element(
    back_handler_dialog_box: MutableState<Boolean>,
    distance: MutableState<Float>,
    scale: MutableState<Float>,
    are_nodes_anchored: MutableState<Boolean>,
    ar_nodes: MutableList<ArModelNode>
) {
    val interaction_source_1 = remember { MutableInteractionSource() }
    val interaction_source_2 = remember { MutableInteractionSource() }
    val show_button = remember { mutableStateOf(true) }
    val button_content_alpha = animateFloatAsState(
        if (show_button.value) 1f else 0f, animationSpec = tween(durationMillis = 400), label = ""
    )
    val button_color_alpha = animateColorAsState(
        if (show_button.value) Color(0x55000000) else Color(0x00000000),
        animationSpec = tween(durationMillis = 400),
        label = ""
    )
    val off_set = animateIntAsState(
        if (show_button.value) 0 else 200, animationSpec = tween(durationMillis = 400), label = ""
    )

    Box(modifier = Modifier.matchParentSize()) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                IconButton(
                    onClick = { back_handler_dialog_box.value = true },
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(Color(0x55000000)),
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
                    onClick = { },
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(Color(0x55000000)),
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
                    .offset(y = off_set.value.dp)
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
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
                verticalArrangement = Arrangement.spacedBy((-1).dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                        .background(Color(0xFFFFFFFF)), contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Distância entre linha e carga: ${distance.value.format(2)} metros",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Slider(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 6.dp, bottomEnd = 6.dp
                            )
                        )
                        .height(54.dp)
                        .background(Color(0xFFFFFFFF))
                        .padding(8.dp),
                    value = distance.value,
                    valueRange = 2f..9f,
                    interactionSource = interaction_source_1,
                    onValueChange = {
                        distance.value = it
                    },
                    thumb = {
                        SliderDefaults.Thumb( //androidx.compose.material3.SliderDefaults
                            modifier = Modifier.padding(2.5.dp),
                            interactionSource = interaction_source_1,
                            thumbSize = DpSize(15.dp, 15.dp),
                            colors = SliderDefaults.colors(thumbColor = main_color)
                        )
                    },
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF8E79F4), inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                        .background(Color(0xFFFFFFFF)), contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Escala dos Modelos: ${scale.value.format(2)} ",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Slider(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 6.dp, bottomEnd = 6.dp
                            )
                        )
                        .height(54.dp)
                        .background(Color(0xFFFFFFFF))
                        .padding(8.dp),
                    value = scale.value,
                    valueRange = 0.05f..0.2f,
                    interactionSource = interaction_source_2,
                    onValueChange = {
                        scale.value = it
                    },
                    thumb = {
                        SliderDefaults.Thumb( //androidx.compose.material3.SliderDefaults
                            modifier = Modifier.padding(2.5.dp),
                            interactionSource = interaction_source_2,
                            thumbSize = DpSize(15.dp, 15.dp),
                            colors = SliderDefaults.colors(thumbColor = main_color)
                        )
                    },
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color(0xFF8E79F4), inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                    default_button(button_enabled = true,
                        button_label = if (!are_nodes_anchored.value) R.string.tutorial_activity_label_add_model else R.string.tutorial_activity_label_unfix_model,
                        label_color = Color(0xFFFFFFFF),
                        button_color = main_color,
                        modifier = Modifier
                            .fillMaxWidth(0.82f)
                            .height(component_height.dp)
                            .background(color = transparent),
                        on_click = {
                            if (!are_nodes_anchored.value) {
                                for (node in ar_nodes) {
                                    node.anchor()
                                }
                                are_nodes_anchored.value = !are_nodes_anchored.value
                            } else {
                                for (node in ar_nodes) {
                                    node.detachAnchor()
                                }
                                are_nodes_anchored.value = !are_nodes_anchored.value
                            }
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(
                        modifier = Modifier
                            .width(component_height.dp)
                            .height(component_height.dp)
                            .clip(shape = RoundedCornerShape(6.dp))
                            .background(main_color),
                        onClick = {
                            ar_nodes.forEach { node ->
                                node.detachAnchor()
                                node.scale = Float3(1f, 1f, 1f)
                                node.rotation = Float3(0f, 0f, 0f)
                                scale.value = 0.05f
                                distance.value = 5f
                            }
                            are_nodes_anchored.value = false
                        },
                    ) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Rounded.RestartAlt),
                            contentDescription = stringResource(
                                id = R.string.comperio_logo_header_content_description_arrow_back
                            ),
                            modifier = Modifier,
                            tint = Color(0xFFFFFFFF),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun second_activity(navigation_controller: NavController) {
    val back_handler_dialog_box = remember { mutableStateOf(false) }
    val are_nodes_anchored = remember { mutableStateOf(false) }
    val charged_line = remember { ar_node_init() }
    val particle_1 = remember { ar_node_init() }
    val ar_nodes = remember { mutableListOf<ArModelNode>() }
    val distance = remember { mutableStateOf(4.0f) }
    val scale = remember { mutableStateOf(0.05f) }

    charged_line.value.name = "charged_line"
    particle_1.value.name = "particle_1"

    ar_node_load(
        particle_1,
        "models/particle.glb",
        false,
        scale.value,
        Position(x = -distance.value, y = 0f, z = 0f)
    )
    ar_node_load(
        charged_line,
        "models/charged_line.glb",
        true,
        0.5f + scale.value,
        Position(x = 4f, y = 0f, z = 0f)
    )
    ar_nodes.addAll(
        listOf(
            charged_line.value,
            particle_1.value
        )
    )

    BackHandler { back_handler_dialog_box.value = true }
    dialog_box(back_handler_dialog_box, navigation_controller)

    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    Box(modifier = Modifier.fillMaxSize()) {
        ARScene(modifier = Modifier.fillMaxSize(),
            nodes = ar_nodes,
            planeRenderer = false,
            onTrackingFailureChanged = {
                TrackingFailureReason.EXCESSIVE_MOTION
            }
        )
        second_activity_ui_element(
            back_handler_dialog_box = back_handler_dialog_box,
            distance = distance,
            scale = scale,
            ar_nodes = ar_nodes,
            are_nodes_anchored = are_nodes_anchored
        )
    }
}

@Preview
@Composable
fun preview_second_activity() {
    second_activity(navigation_controller = rememberNavController())
}