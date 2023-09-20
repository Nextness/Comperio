@file:Suppress("FunctionName")

package com.research.comperio.ui.screen.activities

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.util.Log
import android.view.View
import android.view.Window
import androidx.activity.compose.BackHandler
import androidx.compose.animation.Animatable
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.ar.core.TrackingFailureReason
import com.research.comperio.R
import com.research.comperio.common.format
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.theme.main_color
import com.research.comperio.theme.satoshi_font_family
import com.research.comperio.theme.transparent
import com.research.comperio.ui.common.component_height
import com.research.comperio.ui.common.default_button
import com.research.comperio.ui.common.dialog_box
import com.research.comperio.ui.common.set_screen_orientation
import dev.romainguy.kotlin.math.Float3
import io.github.sceneview.ar.ARScene
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.math.Position
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.floor
import kotlin.math.round

@Composable
fun set_dim_level_none(disable_dim: MutableState<Boolean>) {
    val curView = LocalView.current
    /* Change the transparency of the dialog window */
    LaunchedEffect(curView) {
        tailrec fun Context.findWindow(): Window? = when (this) {
            is Activity -> window
            is ContextWrapper -> baseContext.findWindow()
            else -> null
        }

        fun View.findWindow(): Window? =
            (parent as? DialogWindowProvider)?.window ?: context.findWindow()

        try {
            val window = curView.findWindow() ?: return@LaunchedEffect
            val lp = window.attributes
            val default_dim_level = lp.dimAmount

            if (disable_dim.value)
                lp.dimAmount = 0f
            else
                lp.dimAmount = default_dim_level

            window.attributes = lp
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BoxScope.tutorial_activity_ui_elements(
    back_handler_dialog_box: MutableState<Boolean>,
    navigation_controller: NavController,
    scale: MutableState<Float>,
    is_node_anchored: MutableState<Boolean>,
    ar_nodes: MutableList<ArModelNode>
) {
    val slider_value = remember { mutableStateOf(0f) }
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
        if (show_button.value) 0 else 200,
        animationSpec = tween(durationMillis = off_set_duration),
        label = ""
    )

    val skip_tutorial = remember { mutableStateOf(false) }
    val tutorial_1 = remember { mutableStateOf(false) }
    val tutorial_1_completed = remember { mutableStateOf(false) }
    val tutorial_2 = remember { mutableStateOf(false) }
    val tutorial_2_completed = remember { mutableStateOf(false) }
    val tutorial_3 = remember { mutableStateOf(false) }
    val tutorial_3_completed = remember { mutableStateOf(false) }
    val tutorial_dialog_1 = remember { mutableStateOf(false) }
    val tutorial_dialog_2 = remember { mutableStateOf(false) }
    val tutorial_dialog_3 = remember { mutableStateOf(false) }
    val tutorial_dialog_4 = remember { mutableStateOf(false) }

    val disable_dim_tutorial = remember { mutableStateOf(false) }

    val tutorial_color_highlight = rememberInfiniteTransition(label = "").animateColor(
        initialValue = Color(0x55000000),
        targetValue = Color(0xFF391E98),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )
    val tutorial_color_highlight_contrast = rememberInfiniteTransition(label = "").animateColor(
        initialValue = Color(0xFFFFFFFF),
        targetValue = Color(0xFF000000),
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = ""
    )

    LaunchedEffect(Unit) {
        delay(2000)
        tutorial_dialog_1.value = true
    }

    if (tutorial_dialog_1.value && !skip_tutorial.value) {
        AlertDialog(
            title = {
                Text(
                    "Tutorial",
                    color = main_color,
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                )
            },
            text = {
                Text(
                    "Este tutorial contêm informações de como utilizar o aplicativo durante as atividades em sala de aula.",
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                )
            },
            confirmButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = {
                        tutorial_dialog_1.value = false
                        tutorial_1_completed.value = true
                    }
                ) {
                    androidx.compose.material3.Text(text = "Continuar")
                }
            },
            dismissButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = { skip_tutorial.value = true }
                ) {
                    androidx.compose.material3.Text(text = "Pular tutorial")
                }
            },
            onDismissRequest = {},
            shape = RoundedCornerShape(6.dp),
            containerColor = Color(0xFFFFFFFF),
            titleContentColor = MaterialTheme.extended_color_scheme.primary,
            textContentColor = Color(0xFF272727)
        )
    }

    if (tutorial_1_completed.value && !skip_tutorial.value) {
        LaunchedEffect(Unit) {
            delay(1000)
            tutorial_dialog_2.value = true
        }
    }

    if (tutorial_dialog_2.value && !skip_tutorial.value) {
        AlertDialog(
            title = {
                disable_dim_tutorial.value = true
                set_dim_level_none(disable_dim_tutorial)
                tutorial_1.value = true
                Text(
                    "Tutorial",
                    color = main_color,
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                )
            },
            text = {
                Text(
                    "Você pode sair da atividade a qualquer momento, utilizando o icone no canto superior esquerdo.",
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                )
            },
            confirmButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = {
                        tutorial_dialog_2.value = false
                        tutorial_1.value = false
                        tutorial_2_completed.value = true
                    }
                ) {
                    androidx.compose.material3.Text(text = "Continuar")
                }
            },
            dismissButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = { skip_tutorial.value = true }
                ) {
                    androidx.compose.material3.Text(text = "Pular tutorial")
                }
            },
            onDismissRequest = {},
            shape = RoundedCornerShape(6.dp),
            containerColor = Color(0xFFFFFFFF),
            titleContentColor = MaterialTheme.extended_color_scheme.primary,
            textContentColor = Color(0xFF272727)
        )
    }

    if (tutorial_2_completed.value && !skip_tutorial.value) {
        LaunchedEffect(Unit) {
            delay(1000)
            tutorial_dialog_3.value = true
        }
    }

    if (tutorial_dialog_3.value && !skip_tutorial.value) {
        AlertDialog(
            title = {
                disable_dim_tutorial.value = true
                set_dim_level_none(disable_dim_tutorial)
                tutorial_2.value = true
                Text(
                    "Tutorial",
                    color = main_color,
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                )
            },
            text = {
                Text(
                    "Você também pode pausar a qualquer momento, utilizando o icone no canto superior direito.",
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                )
            },
            confirmButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = {
                        tutorial_2.value = false
                        tutorial_dialog_3.value = false
                        tutorial_3_completed.value = true
                    }
                ) {
                    androidx.compose.material3.Text(text = "Continuar")
                }
            },
            dismissButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = { skip_tutorial.value = true }
                ) {
                    androidx.compose.material3.Text(text = "Pular tutorial")
                }
            },
            onDismissRequest = {},
            shape = RoundedCornerShape(6.dp),
            containerColor = Color(0xFFFFFFFF),
            titleContentColor = MaterialTheme.extended_color_scheme.primary,
            textContentColor = Color(0xFF272727)
        )
    }

    if (tutorial_3_completed.value && !skip_tutorial.value) {
        LaunchedEffect(Unit) {
            delay(1000)
            tutorial_dialog_4.value = true
        }
    }

    if (tutorial_dialog_4.value && !skip_tutorial.value) {
        AlertDialog(
            title = {
                disable_dim_tutorial.value = true
                set_dim_level_none(disable_dim_tutorial)
                tutorial_3.value = true
                Text(
                    "Tutorial",
                    color = main_color,
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                )
            },
            text = {
                Text(
                    "Finalmente, você pode interagir com o modelo 3D utilizando os comandos abaixo.",
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                )
            },
            confirmButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = {
                        tutorial_3.value = false
                        tutorial_dialog_4.value = false
                    }
                ) {
                    androidx.compose.material3.Text(text = "Continuar")
                }
            },
            dismissButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = { skip_tutorial.value = true }
                ) {
                    androidx.compose.material3.Text(text = "Pular tutorial")
                }
            },
            onDismissRequest = {},
            shape = RoundedCornerShape(6.dp),
            containerColor = Color(0xFFFFFFFF),
            titleContentColor = MaterialTheme.extended_color_scheme.primary,
            textContentColor = Color(0xFF272727)
        )
    }


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
                        .background(
                            if (tutorial_1.value)
                                tutorial_color_highlight.value
                            else
                                Color(0x55000000)
                        ),
                    onClick = {
                        back_handler_dialog_box.value = true
                    },
                ) {
                    Icon(
                        painter = rememberVectorPainter(Icons.Rounded.ArrowBack),
                        contentDescription = stringResource(
                            id = R.string.comperio_logo_header_content_description_arrow_back
                        ),
                        tint = if (tutorial_1.value)
                            tutorial_color_highlight_contrast.value
                        else
                            Color(0xFFFFFFFF),
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(6.dp))
                        .background(
                            if (tutorial_2.value)
                                tutorial_color_highlight.value
                            else
                                Color(0x55000000)
                        ),
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
                        tint = if (tutorial_2.value)
                            tutorial_color_highlight_contrast.value
                        else
                            Color(0xFFFFFFFF),
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
                        .background(
                            if (tutorial_3.value)
                                tutorial_color_highlight.value
                            else
                                Color(0x55000000)
                        ),
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
                        tint = if (tutorial_3.value)
                            tutorial_color_highlight_contrast.value
                        else
                            Color(0xFFFFFFFF),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .offset(y = off_set.value.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        if (tutorial_3.value)
                            tutorial_color_highlight.value
                        else
                            button_color_alpha.value
                    )
                    .padding(16.dp)
                    .alpha(button_content_alpha.value),
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
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Rotação do Modelo: ${slider_value.value.format(2)}°",
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
                    value = slider_value.value,
                    valueRange = 0f..360f,
                    interactionSource = interaction_source2,
                    onValueChange = {
                        ar_nodes.forEach { node ->
                            node.rotation = Float3(0f, slider_value.value, 0f)
                        }
                        slider_value.value = it
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
                    valueRange = 0.05f..0.5f,
                    interactionSource = interaction_source,
                    onValueChange = {
                        scale.value = it
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
                        activeTrackColor = Color(0xFF8E79F4), inactiveTrackColor = Color(0xFFD9DAE1)
                    ),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                    default_button(
                        button_enabled = show_button.value,
                        button_label = R.string.tutorial_activity_label_add_model,
                        label_color = Color(0xFFFFFFFF),
                        button_color = main_color,
                        modifier = Modifier
                            .fillMaxWidth(0.82f)
                            .height(component_height.dp)
                            .background(color = transparent),
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
                                slider_value.value = 0f
                                is_node_anchored.value = !is_node_anchored.value
                            }
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
    set_screen_orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    Box(modifier = Modifier.fillMaxWidth()) {
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
