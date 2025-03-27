package com.example.heartrate.ui.screens

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.heartrate.R
import com.example.heartrate.ui.theme.RoundBackground
import kotlinx.coroutines.launch

@Preview
@Composable
fun LoadingScreen() {
    val scope = rememberCoroutineScope() // Create a coroutine scope


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(color = RoundBackground, shape = RoundedCornerShape(0.dp, 0.dp, 144.dp, 144.dp))
                    .weight(3f)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "Heart image",
                    Modifier
                        .size(256.dp)
                )

                Text(
                    text = "Heart Rate",
                    fontSize = 52.sp,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center


                )

            }

            Row(
                modifier = Modifier
                    .padding(48.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .weight(1f)
                        .size(12.dp)

                )
            }
        }


    }
}