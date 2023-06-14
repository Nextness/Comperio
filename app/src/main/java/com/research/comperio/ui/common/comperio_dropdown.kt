package com.research.comperio.ui.common

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.research.comperio.R


@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun comperio_dropdown_small(
    dropdown_width: Dp = 100.dp,
    @StringRes place_holder: Int,
    dropdown_content: List<String> = listOf(""),
    colors: Text_field_default_colors = Text_field_default_colors()
) {
    var is_expanded: Boolean by remember { mutableStateOf(false) }
    var selected_text: String by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.width(dropdown_width)
    ) {
        ExposedDropdownMenuBox(
            expanded = is_expanded,
            onExpandedChange = { is_expanded = !is_expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = selected_text, // selected_text,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = is_expanded)
                },
//                style = MaterialTheme.typography.bodyMedium,
                placeholder = { Text(text = stringResource(id = place_holder)) },
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .menuAnchor()
                    .defaultMinSize(minHeight = 48.dp),
                shape = comperio_component_corner_radius,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colors.text_color,
                    focusedBorderColor = colors.focused_border_color,
                    unfocusedBorderColor = colors.unfocused_border_color,
                    unfocusedLabelColor = colors.unfocused_label_color,
                    focusedPlaceholderColor = colors.placeholder_color,
                )
            )
            DropdownMenu(
                modifier = Modifier
                    .height(200.dp)
                    .background(Color(0xFFFFFFFF))
                    .exposedDropdownSize(),
                expanded = is_expanded,
                offset = DpOffset(0.dp, 5.dp),
                onDismissRequest = { is_expanded = false }
            ) {
                dropdown_content.forEachIndexed { idx, item ->
                    if (idx > 0) {
                        Divider(
                            modifier = Modifier.padding(5.dp),
                            color = colors.placeholder_color,
                            thickness = 0.5.dp
                        )
                    }
                    DropdownMenuItem(
                        modifier = Modifier,
                        text = {
                            Text(
                                text = item, modifier = Modifier,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        onClick = {
                            selected_text = item
                            is_expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun comperio_dropdown_small_with_vm(
    dropdown_width: Dp = 100.dp,
    @StringRes place_holder: Int,
    dropdown_content: List<String> = listOf(""),
    colors: Text_field_default_colors = Text_field_default_colors(),
    default_value: Int?,
    on_select: (Int) -> Unit

) {
    var is_expanded: Boolean by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.width(dropdown_width)
    ) {
        ExposedDropdownMenuBox(
            expanded = is_expanded,
            onExpandedChange = { is_expanded = !is_expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = default_value?.toString() ?: "", // selected_text,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = is_expanded)
                },
//                style = MaterialTheme.typography.bodyMedium,
                placeholder = { Text(text = stringResource(id = place_holder)) },
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .menuAnchor()
                    .defaultMinSize(minHeight = 48.dp),
                shape = comperio_component_corner_radius,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colors.text_color,
                    focusedBorderColor = colors.focused_border_color,
                    unfocusedBorderColor = colors.unfocused_border_color,
                    unfocusedLabelColor = colors.unfocused_label_color,
                    focusedPlaceholderColor = colors.placeholder_color,
                )
            )
            DropdownMenu(
                modifier = Modifier
                    .height(200.dp)
                    .background(Color(0xFFFFFFFF))
                    .exposedDropdownSize(),
                expanded = is_expanded,
                offset = DpOffset(0.dp, 5.dp),
                onDismissRequest = { is_expanded = false }
            ) {
                dropdown_content.forEachIndexed { idx, item ->
                    if (idx > 0) {
                        Divider(
                            modifier = Modifier.padding(5.dp),
                            color = colors.placeholder_color,
                            thickness = 0.5.dp
                        )
                    }
                    DropdownMenuItem(
                        modifier = Modifier,
                        text = {
                            Text(
                                text = item, modifier = Modifier,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        onClick = {
                            on_select(item.toInt())
                            is_expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun comperio_dropdown_big(
    @StringRes place_holder: Int,
    dropdown_content: List<String> = listOf(""),
    colors: Text_field_default_colors = Text_field_default_colors()
) {
    var is_expanded: Boolean by remember { mutableStateOf(false) }
    var selected_text: String by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            expanded = is_expanded,
            onExpandedChange = { is_expanded = !is_expanded },
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = selected_text,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(text = stringResource(id = place_holder)) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = is_expanded)
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 48.dp),
                shape = comperio_component_corner_radius,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colors.text_color,
                    focusedBorderColor = colors.focused_border_color,
                    unfocusedBorderColor = colors.unfocused_border_color,
                    unfocusedLabelColor = colors.unfocused_label_color,
                    focusedPlaceholderColor = colors.placeholder_color,
                )
            )
            DropdownMenu(
                modifier = Modifier
                    .height(200.dp)
                    .background(Color(0xFFFFFFFF))
                    .exposedDropdownSize(),
                expanded = is_expanded,
                offset = DpOffset(0.dp, 5.dp),
                onDismissRequest = { is_expanded = false }
            ) {
                dropdown_content.forEachIndexed { idx, item ->
                    if (idx > 0) {
                        Divider(
                            modifier = Modifier.padding(5.dp),
                            color = colors.placeholder_color,
                            thickness = 0.5.dp
                        )
                    }
                    DropdownMenuItem(
                        modifier = Modifier,
                        text = {
                            Text(
                                text = item, modifier = Modifier.fillMaxWidth(),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        onClick = {
                            selected_text = item
                            is_expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalMaterial3Api::class)
fun comperio_dropdown_big_with_vm(
    @StringRes place_holder: Int,
    dropdown_content: List<String> = listOf(""),
    colors: Text_field_default_colors = Text_field_default_colors(),
    default_value: String,
    on_select: (String) -> Unit
) {
    var is_expanded: Boolean by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            expanded = is_expanded,
            onExpandedChange = { is_expanded = !is_expanded },
            modifier = Modifier.fillMaxWidth(),
        ) {
            OutlinedTextField(
                value = default_value,
                onValueChange = {},
                readOnly = true,
                placeholder = { Text(text = stringResource(id = place_holder)) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = is_expanded)
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 48.dp),
                shape = comperio_component_corner_radius,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = colors.text_color,
                    focusedBorderColor = colors.focused_border_color,
                    unfocusedBorderColor = colors.unfocused_border_color,
                    unfocusedLabelColor = colors.unfocused_label_color,
                    focusedPlaceholderColor = colors.placeholder_color,
                )
            )
            DropdownMenu(
                modifier = Modifier
                    .height(200.dp)
                    .background(Color(0xFFFFFFFF))
                    .exposedDropdownSize(),
                expanded = is_expanded,
                offset = DpOffset(0.dp, 5.dp),
                onDismissRequest = { is_expanded = false }
            ) {
                dropdown_content.forEachIndexed { idx, item ->
                    if (idx > 0) {
                        Divider(
                            modifier = Modifier.padding(5.dp),
                            color = colors.placeholder_color,
                            thickness = 0.5.dp
                        )
                    }
                    DropdownMenuItem(
                        modifier = Modifier,
                        text = {
                            Text(
                                text = item, modifier = Modifier.fillMaxWidth(),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        },
                        onClick = {
                            on_select(item)
                            is_expanded = false
                        }
                    )
                }
            }
        }
    }
}


@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, device = "id:pixel_5", locale = "pt")
fun preview_comperio_dropdown_small() {
    comperio_dropdown_small(place_holder = R.string.test_comperio_hello_test)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, device = "id:pixel_5", locale = "pt")
fun preview_comperio_dropdown_big() {
    comperio_dropdown_big(place_holder = R.string.test_comperio_hello_test)
}
