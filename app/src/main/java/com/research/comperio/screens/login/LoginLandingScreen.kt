package com.research.comperio.screens.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.research.comperio.R
import com.research.comperio.structures.ScreenHolder
import com.research.comperio.ui.common.ComperioLogoInScreen
import com.research.comperio.ui.theme.Satoshi

@Composable
fun LoginLandingPage(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .padding(32.dp)
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            ComperioLogoInScreen(show = true, logoColor = Color(0xFFFFFFFF))
            Spacer(modifier = Modifier.size(377.dp))
        }

        Column(
            modifier = Modifier
        ) {

            Text(
                text = stringResource(id = R.string.label_hero_message),
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.onPrimary
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = stringResource(id = R.string.label_hero_sub_message),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onPrimary
            )

            Spacer(modifier = Modifier.size(40.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(86.dp)
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF391E98),
                    contentColor = MaterialTheme.colors.onPrimary,
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                ),
                onClick = {
                    navHostController.navigate(route = ScreenHolder.AuthenticationHolder.route)
                }
            ) {
                Text(
                    modifier = Modifier.align(CenterVertically),
                    text = stringResource(id = R.string.button_lets_start),
                )
            }

            Row(
                modifier = Modifier.align(CenterHorizontally)
            ) {
                Text(
                    text = stringResource(id = R.string.label_no_account_message),
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onPrimary,
                    fontWeight = FontWeight.Bold
                )
                Text(text = " ")
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.label_register_now)),
                    style = TextStyle(
                        color = Color(0xFFFFFFFF),
                        fontFamily = Satoshi,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline,
                        fontSize = 16.sp
                    ),
                    onClick = { offset ->
                        Log.d("ClickableText", "$offset -th character is clicked.")
                    }
                )
            }
        }
    }
}
