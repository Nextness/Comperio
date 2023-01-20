package com.research.comperio.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.research.comperio.R
import com.research.comperio.commonUiElements.ComperioButton
import com.research.comperio.commonUiElements.PasswordInputField
import com.research.comperio.commonUiElements.TextInputField
import androidx.compose.ui.graphics.Color

@Composable
fun LoginContent(
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF2E004D))
            .drawBehind {
                drawOval(
                    color = Color(0xFFFFFFFF),
                    size = Size(
                        width = 640.dp.toPx(),
                        height = 500.dp.toPx()
                    ),
                    topLeft = Offset(
                        x = -100.dp.toPx(),
                        y = -100.dp.toPx()
                    )

                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.app_name),
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3C1F52)
        )


        Spacer(modifier = Modifier.height(300.dp))

        TextInputField()

        PasswordInputField()

        Spacer(modifier = Modifier.height(40.dp))


        Row(verticalAlignment = Alignment.CenterVertically){
            ComperioButton()

            Spacer(modifier = Modifier.width(6.dp))

            ComperioButton()
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            modifier = Modifier.clickable { onClick() },
            text = "LOGIN",
            fontSize = MaterialTheme.typography.h6.fontSize,
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
