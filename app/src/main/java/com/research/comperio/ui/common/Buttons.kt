package com.research.comperio.ui.common

import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// FIXME: Fix colors in this button to match material theme 2.
@Composable
fun ComperioButton(displayString: String, backgroundColor: Color, fontColor: Color, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp, 25.dp, 25.dp, 25.dp))
            .width(160.dp)
            .height(55.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        onClick = onClick,
    ) {
        Text(
            modifier = Modifier,
            text = displayString,
            color = fontColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(letterSpacing = 0.sp),
            textAlign = TextAlign.Center
        )

    }

}
