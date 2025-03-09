package rana.krishna.gamehokapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rana.krishna.gamehokapp.R

@Composable
@Preview
fun LogoTwoTexts(@DrawableRes id: Int = R.drawable.check_in_logo, label: String= "heelo", title:String= "Title") {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painterResource(id), null, Modifier.padding(8.dp))
        Column {
            Text(label, style = MaterialTheme.typography.labelMedium, color = Color.White.copy(0.6f))
            Text(title, style = MaterialTheme.typography.titleMedium, color = Color.White)
        }
    }
    Spacer(Modifier.height(16.dp))

}