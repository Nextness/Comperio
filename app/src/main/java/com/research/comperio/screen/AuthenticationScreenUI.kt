package com.research.comperio.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.research.comperio.R

@Composable
fun LoginContent(
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.app_name),
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier)

        Text(
            modifier = Modifier.clickable { onClick() },
            text = "LOGIN",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.clickable { onSignUpClick() },
            text = "Sign Up",
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Medium
        )

        Text(
            modifier = Modifier.clickable { onForgotClick() },
            text = "Forgot Password",
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Medium
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PrevLoginContent() {
    LoginContent(
        onClick = { },
        onSignUpClick = { },
        onForgotClick = { }
    )
}
