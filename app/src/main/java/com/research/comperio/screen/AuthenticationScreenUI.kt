package com.research.comperio.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.research.comperio.ui.theme.Contour
import com.research.comperio.ui.theme.Neutral10
import com.research.comperio.ui.theme.Primary10
import com.research.comperio.ui.theme.Primary90

@Composable
fun LoginContent(
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    val ovalColor = MaterialTheme.colors.Primary90
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.Contour)
            .drawBehind {
                drawOval(
                    color = ovalColor,
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

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.app_name),
            fontSize = MaterialTheme.typography.h2.fontSize,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.Primary10
        )

        Spacer(modifier = Modifier.height(39.dp))

        Icon(
            painter = painterResource(id = R.drawable.personinmobile),
            contentDescription = "Women Using Mobile Phone",
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.height(130.dp))

        Text(
            modifier = Modifier
                .width(265.dp),
            text = "Entendendo o mundo de um jeito diferente.",
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(45.dp))

        // TODO: Fix the font size to be algined with the design system.
        //   Do not use values, always should use variables.
        Text(
            modifier = Modifier
                .width(265.dp),
            text = "Aprenda diversos assuntos utilizando realidade aumentada na palma de sua mão.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(70.dp))

        Row(modifier = Modifier) {
            ComperioButton(
                displayString = "Registre-se",
                backgroundColor = MaterialTheme.colors.Neutral10,
                fontColor = MaterialTheme.colors.Primary90,
                onClick = {}
            )
            Spacer(modifier = Modifier.width(20.dp))
            ComperioButton(
                displayString = "Acessar Conta",
                backgroundColor = MaterialTheme.colors.Primary90,
                fontColor = MaterialTheme.colors.Primary10,
                onClick = onClick
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
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
