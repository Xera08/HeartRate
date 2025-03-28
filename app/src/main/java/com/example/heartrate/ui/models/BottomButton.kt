package com.example.heartrate.ui.models

import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartrate.ui.theme.ButtonBackground

@Composable
fun BottomButton(
    text: String,
    fontSize: TextUnit = 16.sp,
    textColor: Color = Color.White,
    backgroundColor: Color = ButtonBackground,
    cornerRadius: Dp = 24.dp,
    onClick: () -> Unit,
    ) {
    Surface (
        color = backgroundColor,
        shape = RoundedCornerShape(cornerRadius),
        onClick = onClick,
        modifier = Modifier
            .height(44.dp)
            .width(333.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = text,
                fontSize = fontSize,
                color = textColor,
                textAlign = TextAlign.Center
            )
        }




    }

}
