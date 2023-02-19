package com.research.comperio.commonui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.research.comperio.R
import com.research.comperio.ui.theme.Contour

@Composable
fun TextInputField() {
    // mutableState: It return an observable value for Compose. If value changed UI get changed automatically.
    // TextFieldValue: A class holding information about the editing state.
    var text by remember { mutableStateOf(TextFieldValue("")) }

    // Construction of the input text field
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        label = {
            Text(
                text = stringResource(id = R.string.label_email),
                color = MaterialTheme.colors.Contour
            )},
        placeholder = {
            Text(text = stringResource(id = R.string.place_holder_email))
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "emailIcon",
                tint = MaterialTheme.colors.Contour
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.Contour,
            cursorColor = MaterialTheme.colors.Contour,
            focusedBorderColor = MaterialTheme.colors.Contour,
            unfocusedBorderColor = MaterialTheme.colors.Contour,
            focusedLabelColor = MaterialTheme.colors.Contour,
            unfocusedLabelColor = MaterialTheme.colors.Contour,
            placeholderColor = MaterialTheme.colors.Contour
        )
    )
}

// Place where information comes from:
// - https://stackoverflow.com/questions/65304229/toggle-password-field-jetpack-compose
@Composable
fun PasswordInputField() {
    // mutableState: It return an observable value for Compose. If value changed UI get changed automatically.
    // TextFieldValue: A class holding information about the editing state.
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    // Construction of the input text field
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = stringResource(id = R.string.label_password)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = { Text(text = stringResource(id = R.string.place_holder_password)) },
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) stringResource(id = R.string.hide_password_icon_description) else stringResource(id = R.string.show_password_icon_description)

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(
                    imageVector  = image,
                    contentDescription = description,
                    tint = MaterialTheme.colors.Contour
                )
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.Contour,
            cursorColor = MaterialTheme.colors.Contour,
            focusedBorderColor = MaterialTheme.colors.Contour,
            unfocusedBorderColor = MaterialTheme.colors.Contour,
            focusedLabelColor = MaterialTheme.colors.Contour,
            unfocusedLabelColor = MaterialTheme.colors.Contour,
            placeholderColor = MaterialTheme.colors.Contour
        )
    )
}



@Preview(showBackground = true, backgroundColor = 0xFF2E004D)
@Composable
fun PreviewTextField() {
    TextInputField()
}

@Preview(showBackground = true, backgroundColor = 0xFF2E004D)
@Composable
fun PreviewPasswordInputField() {
    PasswordInputField()
}
