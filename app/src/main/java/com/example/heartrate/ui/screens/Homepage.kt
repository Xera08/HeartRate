package com.example.heartrate.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.heartrate.R
import com.example.heartrate.ui.theme.RoundBackground
import com.example.heartrate.ui.theme.Typography
import com.example.heartrate.ui.theme.UpperBarBackground


@Preview
@Composable
fun HomepageScreen() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth()
                .background(UpperBarBackground),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Історія",
                style = Typography.labelMedium

            )
            Image(
                painter = painterResource(id = R.drawable.history),
                contentDescription = "History icon",
                modifier = Modifier
                    .padding(12.dp)
                    .size(38.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(4f)
                .background(
                    color = RoundBackground, shape = RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 35,
                        bottomEndPercent = 35
                    )
                )
        ){
            Text(
                text = "Натисність кпонку щоб виміряти пульс!",
                style = Typography.titleMedium,
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 48.dp)
                    .padding(24.dp)
            )

            Image(
                painter = painterResource(R.drawable.heart),
                contentDescription = "Heart image",
                modifier = Modifier.size(256.dp)
            )

        }

        Image(
            painter = painterResource(R.drawable.button_heart_rate),
            contentDescription = "Hear rate button",
            modifier = Modifier
                .padding(12.dp)
                .size(114.dp)
            )
    }
}