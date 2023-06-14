package com.research.comperio.ui.common

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.research.comperio.R
import com.research.comperio.theme.disable_background
import com.research.comperio.theme.disabled_foreground
import com.research.comperio.theme.main_color
import com.research.comperio.theme.main_light
import com.research.comperio.theme.transparent

@Composable
@SuppressLint("ComposableNaming")
fun default_button(
    button_enabled: Boolean = true,
    @StringRes button_label: Int,
    label_color: Color,
    button_color: Color,
    on_click: () -> Unit,
) {
    Button(
        enabled = button_enabled,
        modifier = Modifier
            .fillMaxWidth()
            .height(component_height.dp)
            .background(color = transparent),
        shape = comperio_component_corner_radius,
        colors = ButtonDefaults.buttonColors(
            containerColor = button_color,
            contentColor = label_color,
            disabledContainerColor = disable_background,
            disabledContentColor = disabled_foreground
        ),
        onClick = on_click
    ) {
        Text(
            text = stringResource(id=button_label),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
fun default_button_with_adjustments(
    button_enabled: Boolean = true,
    @StringRes button_label: Int,
    label_color: Color,
    button_color: Color,
    modifier: Modifier,
    on_click: () -> Unit,
) {
    Button(
        enabled = button_enabled,
        modifier = modifier,
        shape = comperio_component_corner_radius,
        colors = ButtonDefaults.buttonColors(
            containerColor = button_color,
            contentColor = label_color,
            disabledContainerColor = disable_background,
            disabledContentColor = disabled_foreground
        ),
        onClick = on_click
    ) {
        Text(
            text = stringResource(id=button_label),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, backgroundColor = 0, device = "id:pixel_5", group = "buttons")
fun preview_enabled_default_button() {
    default_button(
        button_enabled = true,
        button_label = R.string.test_comperio_hello_test,
        label_color = main_light,
        button_color = main_color,
        on_click = {},
    )
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, backgroundColor = 0, device = "id:pixel_5", group = "buttons")
fun preview_disabled_default_button() {
    default_button(
        button_enabled = false,
        button_label = R.string.test_comperio_hello_test,
        label_color = main_light,
        button_color = main_color,
        on_click = {},
    )
}
