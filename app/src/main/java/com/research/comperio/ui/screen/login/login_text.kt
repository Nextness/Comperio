package com.research.comperio.ui.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.research.comperio.R
import com.research.comperio.theme.extended_color_scheme
import com.research.comperio.theme.satoshi_font_family
import com.research.comperio.ui.common.component_height

@Composable
@SuppressLint("ComposableNaming")
fun create_new_account_text(on_click_text: (Int) -> Unit = {}) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.extended_color_scheme.background_hero)
            .fillMaxWidth()
            .height(component_height.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.login_text_text_no_account),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.extended_color_scheme.on_background_hero_label,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.width(4.dp))
        ClickableText(
            text = AnnotatedString(text = stringResource(id = R.string.login_text_text_register)),
            style = TextStyle(
                color = MaterialTheme.extended_color_scheme.on_background_hero_label,
                fontFamily = satoshi_font_family,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                fontSize = 16.sp
            ),
            onClick = on_click_text
        )
    }
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, locale = "pt", group = "Portuguese: Brazil")
fun preview_create_new_account_text_pt() {
    create_new_account_text()
}

@Composable
@SuppressLint("ComposableNaming")
@Preview(showBackground = true, group = "English: United States")
fun preview_create_new_account_text_en() {
    create_new_account_text()
}