package rana.krishna.gamehokapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.ImagePainter
import rana.krishna.gamehokapp.viewmodel.GameViewModel
import kotlin.math.absoluteValue
import rana.krishna.gamehokapp.R
import rana.krishna.gamehokapp.ui.components.Banner
import rana.krishna.gamehokapp.ui.components.FollowItem
import rana.krishna.gamehokapp.ui.components.HeaderAction
import rana.krishna.gamehokapp.ui.components.TournamentCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = hiltViewModel<GameViewModel>()
) {

    val games by viewModel.games.collectAsState()

    val pagerState = rememberPagerState(pageCount = { games.size })
    Column(modifier.verticalScroll(rememberScrollState())) {
        Banner(pagerState)
        Spacer(Modifier.height(16.dp))
        HeaderAction("Play Tournament by Games", "View All")
        Spacer(Modifier.height(16.dp))
        Tournamets()
        Spacer(Modifier.height(16.dp))
        HeaderAction("Compete in Battles", "View All")
        Spacer(Modifier.height(16.dp))
        Compete()
        HorizontalDivider(Modifier.padding(16.dp), thickness = 1.dp)
        HeaderAction("People to Follow", "View More")
        FollowPeople()
    }
}


@Composable
fun FollowPeople() {
    FollowItem()
    FollowItem()
    FollowItem()
}

@Composable
@Preview
fun Compete() {
    val pagerState = rememberPagerState { 3 }
    val contentPadding = if(pagerState.currentPage==0) 16.dp else 40.dp
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(start = contentPadding, end=40.dp, top = 16.dp, bottom = 16.dp),
        pageSpacing = 16.dp
    ){
        TournamentCard()
    }

}

@Composable
fun ImageText(@DrawableRes id: Int, game: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp))
            ,
            contentScale = ContentScale.Crop,)
        Text(game, color = Color.White)
    }

}

@Composable
@Preview
fun Tournamets() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly){
        ImageText(R.drawable.img_1, "Hello")
        ImageText(R.drawable.img_2 , "Hello")
        ImageText(R.drawable.img_2 , "Hello")
    }
}

class PremiumShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(size.width * 0.15f, 0f) // Start from top-left with an offset
            lineTo(size.width, 0f)  // Top-right
            lineTo(size.width * 0.85f, size.height) // Bottom-right with offset
            lineTo(0f, size.height) // Bottom-left
            close()
        }
        return Outline.Generic(path)
    }
}

