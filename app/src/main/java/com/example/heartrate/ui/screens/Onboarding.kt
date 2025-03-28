package com.example.heartrate.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.heartrate.ui.theme.RoundBackground
import com.example.heartrate.R
import com.example.heartrate.ui.models.BottomButton
import com.example.heartrate.ui.models.PageIndicator
import kotlinx.coroutines.launch

data class OnBoardingData(val image: Int, val imageDesc: String, val title: String, val desc: String)

@Composable
fun OnboardingScreen(navController: NavController) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {
        3
    })

    val onBoardingScreens = ArrayList<OnBoardingData>()

    onBoardingScreens.add(
        OnBoardingData(
            R.drawable.onboarding1,
            "Measuring pulse image",
            "Ваш трекер тиску",
            "Зазначайте, відстежуйте та аналізуйте свої показники артеріального тиску."
        )
    )

    onBoardingScreens.add(
        OnBoardingData(
            R.drawable.onboarding2,
            "Checking personal card image",
            "Персоналізовані поради",
            "Програма надає дієві поради, які допоможуть вам підтримувати оптимальний" +
                    " рівень артеріального тиску та зменшити фактори ризику " +
                    "серцево-судинних захворювань."
        )
    )

    onBoardingScreens.add(
        OnBoardingData(
            R.drawable.onboarding3,
            "Reminders image",
            "Нагадування",
            "Не відставайте від графіка контролю артеріального тиску та прийому ліків" +
                    " за допомогою спеціальних нагадувань."
        )
    )



        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState,
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

                ) { page ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = onBoardingScreens[page].image),
                        contentDescription = onBoardingScreens[page].imageDesc,
                        Modifier.size(256.dp)
                    )
                    Spacer(modifier = Modifier.height(36.dp))
                    Text(
                        text = onBoardingScreens[page].title,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = onBoardingScreens[page].desc,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(24.dp),
                        textAlign = TextAlign.Center
                    )

                }
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .padding(36.dp)
            ) {
                PageIndicator(
                    amountOfPages = onBoardingScreens.size,
                    currentPage = pagerState.currentPage
                )
                Spacer(modifier = Modifier.height(24.dp))
                BottomButton(
                    text = if (pagerState.currentPage == 1) "Продовжити" else "Почати!" ,
                    onClick = {

                        scope.launch {
                            pagerState.scrollToPage(pagerState.currentPage+1)
                        }
                    },
                )
            }
        }
    }

