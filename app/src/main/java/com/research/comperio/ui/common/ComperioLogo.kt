package com.research.comperio.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.research.comperio.R

@Composable
fun ComperioLogoInScreen(show: Boolean, logoColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
//            .padding(top = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = if (show) stringResource(id = R.string.app_name) else stringResource(id = R.string.empty_string),
            color = logoColor,
            style = MaterialTheme.typography.h1
        )
    }
}
