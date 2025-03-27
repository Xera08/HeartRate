package com.example.heartrate.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heartrate.ui.theme.RoundBackground
import com.example.heartrate.R


@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    Column() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = RoundBackground, shape = RoundedCornerShape(
                    topStartPercent = 0,
                    topEndPercent = 0,
                    bottomStartPercent = 35,
                    bottomEndPercent = 35
                )
                )
                .weight(3f)
        ) {}
        HorizontalPager(state = pagerState) {

            Image(
                painter = painterResource(id = R.drawable.onboarding1),
                contentDescription = "A man measuring woman's pulse",
                Modifier.size(256.dp)
            )
//            Text(
//                modifier = Modifier
//
//            )
//            Text(
//
//            )
        }



    }
}