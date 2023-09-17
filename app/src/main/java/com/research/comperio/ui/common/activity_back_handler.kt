package com.research.comperio.ui.common

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.theme.satoshi_font_family

@Composable
@SuppressLint("ComposableNaming")
fun dialog_box(show: MutableState<Boolean>, navigation_controller: NavController) {
    if (show.value) {
        AlertDialog(
            title = { Text(text = "Parar Atividade") },
            text = {
                Text(
                    text = "Você tem certeza que deseja sair da atividade?",
                    style = TextStyle(
                        fontFamily = satoshi_font_family,
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp
                    )
                )
            },
            confirmButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = {
                        show.value = false
                        navigation_controller.popBackStack()
                    }
                ) {
                    Text(text = "Sim")
                }
            },
            dismissButton = {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color(0xFF272727),
                        containerColor = Color(0xFFFFFFFF)
                    ),
                    onClick = { show.value = false }
                ) {
                    Text(text = "Não")
                }
            },
            onDismissRequest = { show.value = false },
            shape = RoundedCornerShape(6.dp),
            containerColor = Color(0xFFFFFFFF),
            titleContentColor = MaterialTheme.extended_color_scheme.primary,
            textContentColor = Color(0xFF272727)
        )
    }
}