package com.research.comperio.ui.screen.login

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.research.comperio.theme.main_color
import com.research.comperio.view_model.account_creation_view_model

@Composable
@SuppressLint("ComposableNaming")
@OptIn(ExperimentalFoundationApi::class)
fun horizontal_scroller_page(
    account_creation_view_model: account_creation_view_model,
    pager_state: PagerState
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        repeat(account_creation_view_model.account_creation_page_count - 1) { iteration ->
            val color = if (pager_state.currentPage == iteration) main_color else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(if (pager_state.currentPage == iteration) 6.dp else 5.dp)
                    .align(Alignment.CenterVertically),
            )
        }
    }
}
