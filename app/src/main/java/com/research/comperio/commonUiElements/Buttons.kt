package com.research.comperio.commonUiElements

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.research.comperio.ui.theme.Neutral10
import com.research.comperio.ui.theme.Primary10
import com.research.comperio.ui.theme.Primary90

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

@Preview(showBackground = true)
@Composable
fun PreviewComperioButton() {
    ComperioButton("Acessar Conta", MaterialTheme.colors.Neutral10, MaterialTheme.colors.Primary90, {})
}
