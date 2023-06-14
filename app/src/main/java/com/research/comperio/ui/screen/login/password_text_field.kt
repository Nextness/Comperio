package com.research.comperio.ui.screen.login

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.research.comperio.R
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.ui.common.comperio_component_corner_radius

@Composable
@SuppressLint("ComposableNaming")
fun password_input_field(
    single_line: Boolean = true,
    keyboard_type: KeyboardType = KeyboardType.Password,
    text_input_shape: Shape = comperio_component_corner_radius,
    @StringRes place_holder: Int = R.string.password_text_field_place_holder_write_password
) {
    val password_data: MutableState<TextFieldValue> = remember {
        mutableStateOf(TextFieldValue(text = ""))
    }
    val password_is_visible: MutableState<Boolean> = remember {
        mutableStateOf(value = false)
    }
    val visual_transformation: VisualTransformation = when (password_is_visible.value) {
        true -> VisualTransformation.None
        false -> PasswordVisualTransformation()
    }
    OutlinedTextField(
        value = password_data.value,
        modifier = Modifier.fillMaxWidth(),
        singleLine = single_line,
        keyboardOptions = KeyboardOptions(keyboardType = keyboard_type),
        visualTransformation = visual_transformation,
        onValueChange = { password_data.value = it },
        placeholder = {
            Text(text = stringResource(id = place_holder))
        },
        trailingIcon = {
            if (password_data.value.text.isNotEmpty()) {
                val icon_as_vector_painter: VectorPainter = when (password_is_visible.value) {
                    true -> rememberVectorPainter(Icons.Filled.Visibility)
                    false -> rememberVectorPainter(Icons.Filled.VisibilityOff)
                }
                val content_description: String = when (password_is_visible.value) {
                    true -> stringResource(
                        id = R.string.password_text_field_content_description_show_password
                    )

                    false -> stringResource(
                        id = R.string.password_text_field_content_description_hide_password
                    )
                }
                IconButton(onClick = { password_is_visible.value = !password_is_visible.value }) {
                    Icon(
                        painter = icon_as_vector_painter,
                        contentDescription = content_description,
                        modifier = Modifier,
                        tint = Color(0xFFDDDDDD)
                    )
                }
            }
        },
        shape = text_input_shape,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.extended_color_scheme.focused_text_color,
            focusedContainerColor = MaterialTheme.extended_color_scheme.focused_container_color,
            focusedBorderColor = MaterialTheme.extended_color_scheme.focused_border_color,
            unfocusedTextColor = MaterialTheme.extended_color_scheme.unfocused_text_color,
            unfocusedContainerColor = MaterialTheme.extended_color_scheme.unfocused_container_color,
            unfocusedBorderColor = MaterialTheme.extended_color_scheme.unfocused_border_color,
            focusedPlaceholderColor = MaterialTheme.extended_color_scheme.focused_placeholder_color,
            unfocusedPlaceholderColor = MaterialTheme.extended_color_scheme.unfocused_placeholder_color,
        )
    )
}

@Composable
@SuppressLint("ComposableNaming")
fun password_input_field_with_vm(
    single_line: Boolean = true,
    keyboard_type: KeyboardType = KeyboardType.Password,
    text_input_shape: Shape = comperio_component_corner_radius,
    @StringRes place_holder: Int = R.string.password_text_field_place_holder_write_password,
    default_value: TextFieldValue,
    on_value_change: (TextFieldValue) -> Unit

) {
    val password_is_visible: MutableState<Boolean> = remember {
        mutableStateOf(value = false)
    }
    val visual_transformation: VisualTransformation = when (password_is_visible.value) {
        true -> VisualTransformation.None
        false -> PasswordVisualTransformation()
    }
    OutlinedTextField(
        value = default_value,
        modifier = Modifier.fillMaxWidth(),
        singleLine = single_line,
        keyboardOptions = KeyboardOptions(keyboardType = keyboard_type),
        visualTransformation = visual_transformation,
        onValueChange = on_value_change,
        placeholder = {
            Text(text = stringResource(id = place_holder))
        },
        trailingIcon = {
            if (default_value.text.isNotEmpty()) {
                val icon_as_vector_painter: VectorPainter = when (password_is_visible.value) {
                    true -> rememberVectorPainter(Icons.Filled.Visibility)
                    false -> rememberVectorPainter(Icons.Filled.VisibilityOff)
                }
                val content_description: String = when (password_is_visible.value) {
                    true -> stringResource(
                        id = R.string.password_text_field_content_description_show_password
                    )

                    false -> stringResource(
                        id = R.string.password_text_field_content_description_hide_password
                    )
                }
                IconButton(onClick = { password_is_visible.value = !password_is_visible.value }) {
                    Icon(
                        painter = icon_as_vector_painter,
                        contentDescription = content_description,
                        modifier = Modifier,
                        tint = Color(0xFFDDDDDD)
                    )
                }
            }
        },
        shape = text_input_shape,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.extended_color_scheme.focused_text_color,
            focusedContainerColor = MaterialTheme.extended_color_scheme.focused_container_color,
            focusedBorderColor = MaterialTheme.extended_color_scheme.focused_border_color,
            unfocusedTextColor = MaterialTheme.extended_color_scheme.unfocused_text_color,
            unfocusedContainerColor = MaterialTheme.extended_color_scheme.unfocused_container_color,
            unfocusedBorderColor = MaterialTheme.extended_color_scheme.unfocused_border_color,
            focusedPlaceholderColor = MaterialTheme.extended_color_scheme.focused_placeholder_color,
            unfocusedPlaceholderColor = MaterialTheme.extended_color_scheme.unfocused_placeholder_color,
        )
    )
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, device = "id:pixel_5", locale = "pt")
fun preview_password_input_field() {
    password_input_field()
}
