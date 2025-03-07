package rana.krishna.gamehokapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rana.krishna.gamehokapp.R
import rana.krishna.gamehokapp.ui.theme.Green70

@Composable
@Preview
fun FollowItem(@DrawableRes id: Int = R.drawable.img, name:String="Gamer boy" ) {
    Row(
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
        ){
        Image(painter = painterResource(id), null, Modifier.size(40.dp).clip(CircleShape), contentScale = ContentScale.Crop)
        Text(name, color = Color.White)
        Box(modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Green70)
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ){
            Text("Follow", color = Color.White)
        }
    }

}