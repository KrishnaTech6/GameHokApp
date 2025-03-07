package rana.krishna.gamehokapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import rana.krishna.gamehokapp.R
import rana.krishna.gamehokapp.ui.theme.Green50
import rana.krishna.gamehokapp.ui.theme.Green60
import rana.krishna.gamehokapp.ui.theme.Green70
import rana.krishna.gamehokapp.ui.theme.Green80


@Composable
@Preview
fun TournamentCard() {
    Box(modifier = Modifier.fillMaxWidth()
        .background(
        brush = Brush.verticalGradient(
            colors = listOf(Green50, Green80)
        ),
        shape = RoundedCornerShape(12.dp)
    )) {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent) // Dark Green Background
        ) {
            Column {
                // Background Image
                Box(modifier = Modifier.height(180.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = "Tournament Background",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    // Registration Status
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
                        TagItem("BGMI")
                        TagItem("Solo")
                        TagItem("Entry - 10", true)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Start Time
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painterResource(R.drawable.time),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Starts 3rd Aug at 10:00 pm",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Prize Pool
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painterResource(R.drawable.img_3),
                            contentDescription = null,
                            tint = Color.Yellow,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Prize Pool - 1000",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Image(
                            painterResource(R.drawable.coin),
                            null,
                            Modifier
                                .size(20.dp)
                                .padding(horizontal = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TagItem(text: String, isCoin: Boolean= false) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(Color.Black, RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = text, fontSize = 12.sp, color = Color.White)
            if(isCoin) Image(painterResource(R.drawable.coin), null, Modifier
                .size(16.dp)
                .padding(horizontal = 2.dp))

        }

    }
}
