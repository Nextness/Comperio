@file:Suppress("FunctionName")

package com.research.comperio.ui.screen.activities

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Slider
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
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.dialog_box
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.math.Position
import io.github.sceneview.math.Rotation


fun ar_node_init(
    placement_mode: PlacementMode = PlacementMode.BEST_AVAILABLE,
    hit_position: Position = Position(0.0f, 0.0f, -2.0f),
    follow_hit_position: Boolean = true,
    instant_anchor: Boolean = false
): MutableState<ArModelNode> {
    return mutableStateOf(
        ArModelNode(
            placementMode = placement_mode,
            hitPosition = hit_position,
            followHitPosition = follow_hit_position,
            instantAnchor = instant_anchor,
        )
    )
}

fun ar_node_load(
    node: MutableState<ArModelNode>,
    file_location: String,
    auto_animate: Boolean,
    scale_to_units: Float,
    center_origin: Position
) {
    node.value.loadModelGlbAsync(
        glbFileLocation = file_location,
        autoAnimate = auto_animate,
        scaleToUnits = scale_to_units,
        centerOrigin = center_origin
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BoxScope.first_activity_ui_elements(
    back_handler_dialog_box: MutableState<Boolean>,
    force: MutableState<Float>,
    scale: MutableState<Float>,
    are_nodes_anchored: MutableState<Boolean>,
    ar_nodes: MutableList<ArModelNode>
) {
    val interaction_source_1 = remember { MutableInteractionSource() }
    val interaction_source_2 = remember { MutableInteractionSource() }
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
                    .fillMaxWidth()
                    .padding(bottom = 6.dp)
            ) {
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(32.dp))
                        .background(Color(0x55000000)),
                    onClick = { },
                ) {
                    Icon(
                        painter = rememberVectorPainter(
                            if (true) Icons.Rounded.ExpandMore else Icons.Rounded.ExpandLess
                        ),
                        contentDescription = null,
                        modifier = Modifier,
                        tint = Color(0xFFFFFFFF),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0x55000000))
                    .padding(16.dp)
                    .alpha(1f),
                verticalArrangement = Arrangement.spacedBy((-1).dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                        .background(Color(0xFFFFFFFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Força Elétrica: ${force.value.format(2)} N",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Slider(
                    modifier = Modifier
                        .clip(RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp))
                        .height(54.dp)
                        .background(Color(0xFFFFFFFF))
                        .padding(8.dp),
                    value = force.value,
                    valueRange = 2f..4f,
                    interactionSource = interaction_source_1,
                    onValueChange = {
                        force.value = it
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
                        activeTrackColor = Color(0xFF8E79F4),
                        inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                        .background(Color(0xFFFFFFFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Escala do Modelo: ${scale.value.format(2)}",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Slider(
                    modifier = Modifier
                        .clip(RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp))
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
                        activeTrackColor = Color(0xFF8E79F4),
                        inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                default_button(
                    button_enabled = true,
                    button_label = R.string.tutorial_activity_label_add_model,
                    label_color = Color(0xFFFFFFFF),
                    button_color = main_color,
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
            }
        }
    }
}

@Composable
fun first_activity(navigation_controller: NavController) {
    val back_handler_dialog_box = remember { mutableStateOf(false) }
    val are_nodes_anchored = remember { mutableStateOf(false) }
    val ar_nodes = remember { mutableListOf<ArModelNode>() }
    val particle_1 = remember { ar_node_init() }
    val particle_2 = remember { ar_node_init() }
    val arrow_1 = remember { ar_node_init() }
    val arrow_2 = remember { ar_node_init() }
    val force = remember { mutableStateOf(3.0f) }
    val scale = remember { mutableStateOf(0.05f) }

    arrow_1.value.modelRotation = Rotation(x = 0f, y = -90f, z = 0f)
    arrow_2.value.modelRotation = Rotation(x = 0f, y = 90f, z = 0f)

    ar_node_load(
        particle_1,
        "models/particle.glb",
        false,
        scale.value,
        Position(x = -force.value, y = 0f, z = 0f)
    )
    ar_node_load(
        particle_2,
        "models/particle.glb",
        false,
        scale.value,
        Position(x = force.value, y = 0f, z = 0f)
    )
    ar_node_load(
        arrow_1,
        "models/arrow.glb",
        false,
        scale.value * 0.95f * ((force.value + 3) / 8),
        Position(
            x = (-force.value + force.value * 0.25f) * (1 + scale.value * 0.95f * ((force.value + 3) / 8)),
            y = 0f,
            z = 0f
        )
    )
    ar_node_load(
        arrow_2,
        "models/arrow.glb",
        false,
        scale.value * 0.95f * ((force.value + 3) / 8),
        Position(
            x = (force.value - force.value * 0.25f) * (1 + scale.value * 0.95f * ((force.value + 3) / 8)),
            y = 0f,
            z = 0f
        )
    )

    ar_nodes.addAll(
        listOf(
            particle_1.value,
            particle_2.value,
            arrow_1.value,
            arrow_2.value
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        BackHandler { back_handler_dialog_box.value = true }
        dialog_box(back_handler_dialog_box, navigation_controller)

        ARScene(
            modifier = Modifier.fillMaxSize(),
            nodes = ar_nodes,
            planeRenderer = false,
            onTrackingFailureChanged = {
                TrackingFailureReason.EXCESSIVE_MOTION
            }
        )

        first_activity_ui_elements(
            back_handler_dialog_box,
            force,
            scale,
            are_nodes_anchored,
            ar_nodes
        )
    }
}

@Preview
@Composable
fun preview_first_activity() {
    first_activity(navigation_controller = rememberNavController())
}