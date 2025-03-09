package rana.krishna.gamehokapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rana.krishna.gamehokapp.R
import rana.krishna.gamehokapp.ui.components.LogoTwoTexts
import rana.krishna.gamehokapp.ui.components.TagItem
import rana.krishna.gamehokapp.ui.components.TournamentCard
import rana.krishna.gamehokapp.ui.theme.Green70


val tabItems = listOf(
   "Overview",
    "Players",
    "Rules"
)
@Composable
fun TournamentDetails(navController: NavController, modifier: Modifier = Modifier) {
    Column(Modifier
        .background(Color.Black)
        .verticalScroll(rememberScrollState())){
        BattlegroundsCard({navController.navigateUp()})
        TitleBox()
        var selectedTabIndex by remember {
            mutableIntStateOf(0)
        }
        val pagerState = rememberPagerState {
            tabItems.size
        }
        LaunchedEffect(selectedTabIndex) {
            pagerState.animateScrollToPage(selectedTabIndex)
        }
        LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
            if(!pagerState.isScrollInProgress) {
                selectedTabIndex = pagerState.currentPage
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabItems.forEachIndexed { index, item ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = {
                            Text(text = item, color = Color.White)
                        }
                        , modifier = Modifier.background(Color.Black)
                    )
                }
            }

            OverViewDetails()
        }
    }



}

@Composable
fun OverViewDetails() {
    Column(Modifier.padding(16.dp)){
        Text("Details", style = MaterialTheme.typography.titleLarge, color = Color.White)
        Spacer(Modifier.height(16.dp))
        LogoTwoTexts(R.drawable.team_logo, "TEAM SIZE", "Solo")
        LogoTwoTexts(R.drawable.format_logo, "FORMAT", "Single Elimination")
        LogoTwoTexts(R.drawable.date_logo, "TOURNAMENT STARTS", "Tue 24th Jan 2024, 01:00 PM")
        LogoTwoTexts(R.drawable.check_in_logo, "CHECK-IN", "10 mins before the match starts")
        TournamentPrizeUI()

        Text("Rounds and Schedule", style = MaterialTheme.typography.titleLarge, color = Color.White)
        Spacer(Modifier.height(16.dp))
        RoundsAndScheduleItem()
        RoundsAndScheduleItem()
        RoundsAndScheduleItem()
        Spacer(Modifier.height(8.dp))
        Text("How to Join a Match", style = MaterialTheme.typography.titleLarge, color = Color.White)
        HowToJoinMatchSection()

        OrganisersDetails()
        Spacer(Modifier.height(16.dp))
        Text("More tournaments for you", style = MaterialTheme.typography.titleLarge, color = Color.White)
        MoreTournaments()

    }
}

@Composable
fun MoreTournaments() {

    val pagerState = rememberPagerState { 3 }
    val contentPadding = if(pagerState.currentPage==0) 16.dp else 40.dp
    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(start = contentPadding, end=40.dp, top = 16.dp, bottom = 16.dp),
        pageSpacing = 16.dp
    ){
        TournamentCard(true, true)
    }



}

@Composable
fun OrganisersDetails() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0XFF001208))
            .border(4.dp, Color(0XFF001208))
    ) {
        Box(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0XFF182920), Color(0XFF4D5A53))
                    ),
                )
            .padding(16.dp)

        ){
            Text(
                text = "Organiser’s Details and contact",
                color = Color.White,
                fontSize = 16.sp,
            )
        }
        Column(Modifier
            .padding(12.dp)
            .fillMaxWidth()) {

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.prize_green_coin),
                        contentDescription = "Currency Icon",
                        modifier = Modifier
                            .size(26.dp)
                    )
                    Text("Gamehok Esports", color = Color.White, fontSize = 16.sp, style = MaterialTheme.typography.titleMedium)
                }
                Box(modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = Green70)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                ){
                    Text("Follow", color = Color.White)
                }

            }
            Text("This is the in house organiser of this platform " +
                    "you can follow our page on this platform for " +
                    "regular updates", color = Color.White, minLines = 2)
            Spacer(Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Icon(Icons.Default.Phone, null, tint = Color.White)
                    Text(text = "989012335", color = Color.White, fontSize = 14.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.MailOutline, null,tint = Color.White)
                    Text(text = "support@gamehok.com", color = Color.White, fontSize = 14.sp)
                }
            }

        }
    }


}

@Composable
fun HowToJoinMatchSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp)
    ) {

        val instructions = listOf(
            "Have your game open already and on the latest version",
            "Once the match is configured you will receive an invite in-game to join the lobby.",
            "Join the match and wait for the game to start.",
            "When eliminated return to the match room page to be ready to join the next map in the round."
        )

        instructions.forEach { instruction ->
            Row(
                modifier = Modifier.padding(vertical = 4.dp),
                verticalAlignment = Alignment.Top
            ) {
                Text(text = "•", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(end = 8.dp))
                Text(text = instruction, color = Color.White, fontSize = 16.sp)
            }
        }
    }
}
@Composable
@Preview
fun RoundsAndScheduleItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(
                    text = "Qualifiers",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    text = " (Round 1)",
                    color = Color.White.copy(alpha = 0.6f),
                    fontSize = 18.sp
                )
            }
            Box(
                modifier = Modifier
                    .background(
                        Brush.horizontalGradient(
                            listOf(Color(0xff311A61), Color(0xff1C192E))
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(text = "Single Elimination", color = Color.White, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Top 4 to next round",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 16.sp
            )
            Text(
                text = "3rd Aug, 10:00 pm",
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Divider(color = Color.White.copy(alpha = 0.3f))
    }
}
@Composable
@Preview
fun TournamentPrizeUI() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0XFF001208))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0XFF182920), Color(0XFF4D5A53))
                    ),
                )
                .padding(12.dp)
        ){
            Text(
                text = "Total Tournament Prize",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "2000",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.prize_green_coin),
                    contentDescription = "Currency Icon",
                    modifier = Modifier
                        .size(26.dp)
                )
            }
        }
        Column(Modifier.padding(12.dp)) {
            PrizeItem("1st Prize", "1000", R.drawable.prize_green_coin)
            PrizeItem("2nd Prize", "500", R.drawable.prize_green_coin)
            PrizeItem("3rd Prize", "200", R.drawable.prize_green_coin)
            PrizeItem("4th Prize", "100", R.drawable.prize_green_coin)
            PrizeItem("5th Prize", "100", R.drawable.prize_green_coin)
        }
    }
}

@Composable
fun PrizeItem(position: String, amount: String, iconRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.img_3),
            contentDescription = "Trophy",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = position,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )
        Text(
            text = amount,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.width(4.dp))
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "Currency Icon",
            modifier = Modifier
                .size(24.dp)
        )
    }
    HorizontalDivider(color = Color.Black)
}


@Composable
@Preview
fun TitleBox() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "PUBG tournament",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(text = "By Red Bull", fontSize = 14.sp, color = Color.LightGray)

        Spacer(modifier = Modifier.height(8.dp))

        // Tags Row
        Row {
            TagItem("BGMI", isGreen = true)
            TagItem("Solo", isGreen = true)
            TagItem("Entry - 10", true,isGreen = true)
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
    }

@Composable
fun BattlegroundsCard(backPressed: ()->Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1), // Replace with actual image
            contentDescription = "Battlegrounds",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        // Back and Share Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { backPressed() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .background(Color(0x66000000), shape = CircleShape)
                        .padding(4.dp)
                )
            }

            IconButton(onClick = { /* Handle share */ }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = Color.White,
                    modifier = Modifier
                        .background(Color.Black.copy(0.6f), shape = RoundedCornerShape(8.dp))
                        .padding(4.dp)
                )
            }
        }


        // Bottom Info Bar
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Registration Open",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = Color.Black.copy(alpha = 0.5f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = Color.Black.copy(alpha = 0.5f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        painterResource(R.drawable.people),
                        contentDescription = null,
                        Modifier.size(20.dp),
                        tint = Color.White
                    )
                    Text(text = "670/800", fontSize = 12.sp, color = Color.White)
                }
            }
        }
    }
}
