package com.research.comperio._debug

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


var DEVEL_DEBUG: Boolean = false

@Composable
fun DEVEL_Button(navHostController: NavHostController, route: String, visible: Boolean = DEVEL_DEBUG) {
    if (visible) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(10.dp)
                .background(color = Color(0xFFF0F0F0), shape = MaterialTheme.shapes.large),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "DEBUG ONLY:", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFA1A1A1)
                ),
                onClick = {
                    navHostController.navigate(route)
                }) {
                Text(text = "Go back", fontWeight = FontWeight.Bold)
            }
        }
    }
}
