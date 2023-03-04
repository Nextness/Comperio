package com.research.comperio.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.research.comperio.ui.common.ComperioLogoInScreen
import com.research.comperio.R
import com.research.comperio._debug.DEVEL_Button
import com.research.comperio.structures.ScreenHolder
import com.research.comperio.ui.theme.Satoshi

@Composable
fun LoginScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize()
    ) {

        DEVEL_Button(
            navHostController = navHostController,
            route = ScreenHolder.OnboardingScreenHolder.route
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(onClick = {
                    navHostController.popBackStack()
                }
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "",
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(32.dp)
                    )
                }

                ComperioLogoInScreen(show = true, logoColor = MaterialTheme.colors.primary)
            }
        }

        Spacer(modifier = Modifier.size(78.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Faça seu login",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.primary
            )

            Spacer(modifier = Modifier.size(24.dp))

            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.loginperson),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.size(40.dp))

            Text(
                text = stringResource(id = R.string.label_email),
                modifier = Modifier.padding(start = 6.dp, bottom = 4.dp),
                style = MaterialTheme.typography.body2,
                color = Color(0xFF391E98)
            )

            // TODO: Fix the textfield to be aligned with the design sytem.|
            var text by remember { mutableStateOf(TextFieldValue(text = "")) }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .border(
                        border = BorderStroke(1.dp, Color(0xFFCBC5C9)),
                        shape = MaterialTheme.shapes.medium
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                value = text,
                onValueChange = {it ->
                    text = it
                }
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = stringResource(id = R.string.label_password),
                modifier = Modifier.padding(start = 6.dp, bottom = 4.dp),
                style = MaterialTheme.typography.body2,
                color = Color(0xFF391E98)
            )

            // TODO: Fix the textfield to be aligned with the design sytem.|
            var text2 by remember { mutableStateOf(TextFieldValue(text = "")) }
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .border(
                        border = BorderStroke(1.dp, Color(0xFFCBC5C9)),
                        shape = MaterialTheme.shapes.medium
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                value = text2,
                onValueChange = { it ->
                    text2 = it
                }
            )

            Spacer(modifier = Modifier.size(73.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary,
                ),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                ),
                onClick = {
                    navHostController.navigate(route = ScreenHolder.HomeScreenHolder.route)
                /* TODO:
                *    Create validation function which passes values from the fields.
                *    if it exists move to the main screen, else fail and say the password
                *    or the email are incorrect or do not exist.
                */
                }
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = stringResource(id = R.string.label_access_account),
                )
            }


            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier
                    .height(54.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ClickableText(
                    text = AnnotatedString(text = stringResource(id = R.string.label_forgot_password)),
                    style = TextStyle(
                        color = Color(0xFF8E79F4),
                        fontFamily = Satoshi,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    onClick = { /* TODO: Move to forget password screen */ }
                )
            }
        }
    }
}
