package com.research.comperio.ui.common

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.research.comperio.R
import com.research.comperio.theme.extended_color_scheme

@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun text_input_field(
    @StringRes place_holder: Int?,
    single_line: Boolean,
    keyboard_type: KeyboardType,
    text_input_enabled: Boolean,
    colors: Text_field_default_colors = Text_field_default_colors()
) {
    val input_text_value: MutableState<TextFieldValue> = remember {
        mutableStateOf(TextFieldValue(text = ""))
    }
    OutlinedTextField(
        value = input_text_value.value,
        singleLine = single_line,
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 48.dp),
        enabled = text_input_enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboard_type),
        onValueChange = { input_text_value.value = it },
        placeholder = {
            if (place_holder != null) {
                Text(text = stringResource(place_holder))
            }
        },
        shape = comperio_component_corner_radius,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.extended_color_scheme.focused_text_color,
            focusedContainerColor = MaterialTheme.extended_color_scheme.focused_container_color,
            focusedBorderColor = MaterialTheme.extended_color_scheme.focused_border_color,
            unfocusedTextColor = MaterialTheme.extended_color_scheme.unfocused_text_color,
            unfocusedContainerColor = MaterialTheme.extended_color_scheme.unfocused_container_color,
            unfocusedBorderColor = MaterialTheme.extended_color_scheme.unfocused_border_color,
            focusedPlaceholderColor = MaterialTheme.extended_color_scheme.focused_placeholder_color,
            unfocusedPlaceholderColor = MaterialTheme.extended_color_scheme.unfocused_placeholder_color,
        ),
    )
}

@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun text_input_field_with_vm(
    @StringRes place_holder: Int?,
    single_line: Boolean,
    keyboard_type: KeyboardType,
    text_input_enabled: Boolean,
    colors: Text_field_default_colors = Text_field_default_colors(),
    default_value: TextFieldValue,
    on_change_value: (TextFieldValue) -> Unit,
) {
    OutlinedTextField(
        value = default_value,
        singleLine = single_line,
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 48.dp),
        enabled = text_input_enabled,
        keyboardOptions = KeyboardOptions(keyboardType = keyboard_type),
        onValueChange = on_change_value,
        placeholder = {
            if (place_holder != null) {
                Text(text = stringResource(place_holder))
            }
        },
        shape = comperio_component_corner_radius,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.extended_color_scheme.focused_text_color,
            focusedContainerColor = MaterialTheme.extended_color_scheme.focused_container_color,
            focusedBorderColor = MaterialTheme.extended_color_scheme.focused_border_color,
            unfocusedTextColor = MaterialTheme.extended_color_scheme.unfocused_text_color,
            unfocusedContainerColor = MaterialTheme.extended_color_scheme.unfocused_container_color,
            unfocusedBorderColor = MaterialTheme.extended_color_scheme.unfocused_border_color,
            focusedPlaceholderColor = MaterialTheme.extended_color_scheme.focused_placeholder_color,
            unfocusedPlaceholderColor = MaterialTheme.extended_color_scheme.unfocused_placeholder_color,
        ),
    )
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, device = "id:pixel_5", group = "buttons")
fun preview_text_input_field() {
    text_input_field(
        place_holder = R.string.app_name,
        single_line = false,
        text_input_enabled = true,
        keyboard_type = KeyboardType.Text
    )
}
