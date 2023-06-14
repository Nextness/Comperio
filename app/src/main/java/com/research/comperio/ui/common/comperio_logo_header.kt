package com.research.comperio.ui.common

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.research.comperio.R
import com.research.comperio.theme.main_color

@Composable
@SuppressLint("ComposableNaming")
fun header_comperio_logo(
    interaction_source: MutableInteractionSource = MutableInteractionSource(),
    logo_color: Color = Color(0xFFFFFFFF),
    back_arrow: Boolean = false,
    back_arrow_on_click: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (back_arrow) {
            IconButton(
                modifier = Modifier.width(32.dp),
                onClick = back_arrow_on_click,
                interactionSource = interaction_source,
            ) {
                Icon(
                    painter = rememberVectorPainter(Icons.Filled.ArrowBack),
                    contentDescription = stringResource(
                        id = R.string.comperio_logo_header_content_description_arrow_back
                    ),
                    modifier = Modifier,
                    tint = logo_color,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Comperio",
            color = logo_color,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, backgroundColor = 0, device = "id:pixel_5", group = "Logo")
fun preview_header_comperio_logo() {
    header_comperio_logo()
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, backgroundColor = 0, device = "id:pixel_5", group = "Logo")
fun preview_header_comperio_logo_with_back_arrow() {
    header_comperio_logo(back_arrow = true)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, backgroundColor = 0, device = "id:pixel_5", group = "Logo")
fun preview_header_comperio_logo_with_custom_color() {
    header_comperio_logo(logo_color = main_color)
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, backgroundColor = 0, device = "id:pixel_5", group = "Logo")
fun preview_header_comperio_logo_with_back_arrow_with_custom_color() {
    header_comperio_logo(back_arrow = true, logo_color = main_color)
}