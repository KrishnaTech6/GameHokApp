package rana.krishna.gamehokapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import rana.krishna.gamehokapp.R
import rana.krishna.gamehokapp.ui.screens.PremiumShape
import rana.krishna.gamehokapp.ui.theme.Green50
import rana.krishna.gamehokapp.ui.theme.Orange
import kotlin.math.absoluteValue

@Preview
@Composable
fun Banner(
    pagerState: PagerState = rememberPagerState(pageCount = { 3 }),
) {
    Column {
        val fling = PagerDefaults.flingBehavior(
            state = pagerState,
            pagerSnapDistance = PagerSnapDistance.atMost(3)
        )
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(16.dp),
            pageSpacing = 16.dp,
            flingBehavior = fling
        ) { page ->
            // Our page content
            Card(
                Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        // We animate the alpha, between 50% and 100%
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                // Use async image to load image
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFFFEEBA6), Color.White)
                            )
                        )
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "GameHok",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Box(
                            modifier = Modifier
                                .clip(PremiumShape()) // Custom shape
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0xFFFDc346),
                                            Color(0xFFFfe293)
                                        ) // Gradient gold effect
                                    )
                                ).padding(horizontal = 16.dp, vertical = 2.dp)
                        ) {

                            Text(text = "Premium", fontSize = 12.sp)
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Orange)
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            Text(
                                text = "Get Now",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }
                    Column {
                        Text(
                            text = "Upgrade to premium membership and get ", fontSize = 14.sp,
                            modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("100 ", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            Image(painterResource(R.drawable.points), null, Modifier.size(20.dp))
                            Text(" and many other premium features.", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }

                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("View All Feature", color = Green50)
                        Icon(Icons.Default.KeyboardArrowRight, null, tint = Green50)
                    }
                }

            }
        }

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            horizontalArrangement =
                Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.onPrimary else Color.LightGray
                val size = if (pagerState.currentPage == iteration) 12.dp else 8.dp
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(size)
                )
            }
        }
    }
}
