package com.research.comperio.ui.screen.activities

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.research.comperio.R
import com.research.comperio.theme.main_color
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.dialog_box
import com.research.comperio.ui.common.on_back_handler_do_nothing
import com.research.comperio.ui.common.set_screen_orientation
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.ArNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.math.Position
import io.github.sceneview.math.Rotation
import io.github.sceneview.node.Node

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("ComposableNaming")
fun first_activity(navigation_controller: NavController) {
    var open_alert_dialog = remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxWidth()) {
        BackHandler(enabled = true, onBack = {
            open_alert_dialog.value = true
        })
        dialog_box(open_alert_dialog, navigation_controller)
        set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val nodes = remember { mutableStateListOf<Node>() }
        val ar_nodes by remember { mutableStateOf(ArModelNode()) }
        val particle_1 by remember { mutableStateOf(ArModelNode()) }
        val particle_2 by remember { mutableStateOf(ArModelNode()) }
        val arrow_1 by remember { mutableStateOf(ArModelNode()) }
        val arrow_2 by remember { mutableStateOf(ArModelNode()) }
        var force by remember { mutableStateOf(3.0f) }
        var scale by remember { mutableStateOf(0.05f) }

        ar_nodes.placementMode = PlacementMode.BEST_AVAILABLE
        ar_nodes.hitPosition = Position(0.0f, 0.0f, -2.0f)
        ar_nodes.followHitPosition = true
        ar_nodes.instantAnchor = true

        arrow_1.modelRotation = Rotation(x = 0f, y = -90f, z = 0f)
        arrow_2.modelRotation = Rotation(x = 0f, y = 90f, z = 0f)

        ar_nodes.addChild(
            particle_1.loadModelGlbAsync(
                glbFileLocation = "models/particle.glb",
                autoAnimate = false,
                scaleToUnits = scale,
                centerOrigin = Position(x = -force, y = 0f, z = 0f)
            )
        )
        ar_nodes.addChild(
            particle_2.loadModelGlbAsync(
                glbFileLocation = "models/particle.glb",
                autoAnimate = false,
                scaleToUnits = scale,
                centerOrigin = Position(x = force, y = 0f, z = 0f)
            )
        )
        ar_nodes.addChild(
            arrow_1.loadModelGlbAsync(
                glbFileLocation = "models/arrow.glb",
                autoAnimate = false,
                scaleToUnits = scale * 0.95f * ((force + 3) / 8),
                centerOrigin = Position(
                    x = (-force + force * 0.25f) * (1 + scale * 0.95f * ((force + 3) / 8)),
                    y = 0f,
                    z = 0f
                )
            )
        )
        ar_nodes.addChild(
            arrow_2.loadModelGlbAsync(
                glbFileLocation = "models/arrow.glb",
                autoAnimate = false,
                scaleToUnits = scale * 0.95f * ((force + 3) / 8),
                centerOrigin = Position(
                    x = (force - force * 0.25f) * (1 + scale * 0.95f * ((force + 3) / 8)),
                    y = 0f,
                    z = 0f
                )
            )
        )

        ARScene(
            modifier = Modifier.fillMaxSize(),
            nodes = ar_nodes.allChildren,
            planeRenderer = false,
            onTap = {
                ar_nodes.anchor()
            }
        )

        Box(modifier = Modifier.matchParentSize()) {
            val interaction_source: MutableInteractionSource = remember {
                MutableInteractionSource()
            }
            val interaction_source_2: MutableInteractionSource = remember {
                MutableInteractionSource()
            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 16.dp)
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
                fun Float.format(digits: Int) = "%.${digits}f".format(this)
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
                        contentAlignment = Alignment.Center) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Força Elétrica: ${force.format(2)} N",
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
                        value = force,
                        valueRange = 2f..4f,
                        interactionSource = interaction_source,
                        onValueChange = {
                            force = it
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

                    Spacer(modifier = Modifier.height(8.dp))


                    Box(
                        modifier = Modifier
                            .height(25.dp)
                            .clip(RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp))
                            .background(Color(0xFFFFFFFF)),
                        contentAlignment = Alignment.Center) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Escala do Modelo: ${scale.format(2)}",
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
                        value = scale,
                        valueRange = 0.05f..0.2f,
                        interactionSource = interaction_source_2,
                        onValueChange = {
                            scale = it
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
                            ar_nodes.anchor()
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
@SuppressLint("ComposableNaming")
fun preview_first_activity() {
    first_activity(navigation_controller = rememberNavController())
}
