package rana.krishna.gamehokapp.ui.components

import android.R
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rana.krishna.gamehokapp.ui.theme.Green40

@Composable
@Preview
fun HeaderAction(heading: String="Play Tournament" , option: String="View All", action: () -> Unit= {}) {

    Row (
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = heading,
            style= MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = option,
            modifier = Modifier.clickable {
                action()
            },
            style= MaterialTheme.typography.titleMedium,
            color = Green40

        )
    }

}