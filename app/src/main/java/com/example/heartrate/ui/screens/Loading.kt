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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.heartrate.Onboarding
import com.example.heartrate.R
import com.example.heartrate.ui.theme.RoundBackground
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoadingScreen(navController: NavController) {
    var currentProgress by remember { mutableStateOf(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = null) {
        scope.launch {
            loadProgress { progress ->
                currentProgress = progress
            }
        }


    }
    if (currentProgress == 1F) {
        navController.navigate(Onboarding.route)
    }

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
                    .background(color = RoundBackground, shape = RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 35,
                        bottomEndPercent = 35
                    ))
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


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(48.dp),
            ) {
                LinearProgressIndicator(
                    progress = {currentProgress},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)

                )
                Text(
                    text = "${(currentProgress*100).toInt()}%",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
        }


    }


}


suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    delay(150)
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(50)
    }

}