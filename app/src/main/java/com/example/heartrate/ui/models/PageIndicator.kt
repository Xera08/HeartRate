package com.example.heartrate.ui.models

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.heartrate.ui.theme.HighlightedDot
import com.example.heartrate.ui.theme.RegularDot

@Composable
fun PageIndicator(
    amountOfPages: Int,
    currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ) {
        repeat(amountOfPages) {
            Indicator(highlighted = (it == currentPage))
        }
    }
}

@Composable
fun Indicator(highlighted: Boolean) {
    val width = animateDpAsState(targetValue = if (highlighted) 35.dp else 15.dp, label = "")

    Box(modifier = Modifier
        .padding(2.dp)
        .height(15.dp)
        .width(width.value)
        .clip(CircleShape)
        .background( if (highlighted == true) HighlightedDot else RegularDot)
    )
}
