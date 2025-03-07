package rana.krishna.gamehokapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import rana.krishna.gamehokapp.model.GameItem
import rana.krishna.gamehokapp.viewmodel.GameViewModel
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: GameViewModel = hiltViewModel<GameViewModel>()) {

    val games by viewModel.games.collectAsState()

    val pagerState= rememberPagerState(pageCount = {games.size})

    Carousel(pagerState)
    Tournamets()
    Compete()
    FollowPeople()

}

@Preview
@Composable
fun Carousel(
    pagerState: PagerState= rememberPagerState(pageCount = { 3 }),
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
                        .height(200.dp)
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
                        if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else Color.LightGray
                    val size = if(pagerState.currentPage == iteration) 12.dp else 8.dp
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
@Composable
fun FollowPeople() {
    TODO("Not yet implemented")
}

@Composable
fun Compete() {
    TODO("Not yet implemented")
}

@Composable
fun Tournamets() {
    TODO("Not yet implemented")
}

