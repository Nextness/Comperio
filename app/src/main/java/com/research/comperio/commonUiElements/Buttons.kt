package com.research.comperio.commonUiElements

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComperioButton() {
    Button(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
            .width(170.dp)
            .height(65.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF68BB96)),
        onClick = { },
    ) {
        Text(
            modifier = Modifier.padding(6.dp),
            text = "Acesar Conta",
            color = Color(0xFF1D1B1E),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(letterSpacing = 0.sp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun PreviewComperioButton() {
    ComperioButton()
}