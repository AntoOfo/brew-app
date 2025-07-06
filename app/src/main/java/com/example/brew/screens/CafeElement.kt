package com.example.brew.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.ui.theme.BrewTheme

@Composable
fun CafeElement(
    name: String,
    street: String,
    distance: Float,
    lat: Double,
    lon: Double,
    modifier: Modifier = Modifier) {

    val context = LocalContext.current

    val formattedDistance = if (distance >= 1000) {
        String.format("%.1f km", distance / 1000)
    } else {
        String.format("%.0f m", distance)
    }

    // curved background for cafe element
    Surface(
        shape = MaterialTheme.shapes.extraLarge,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(0.5.dp, color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)),
        modifier = modifier
            .width(170.dp)
            .height(48.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .clickable {

                // opens maps app with marker for cafe based on lat/lon
                val uri = Uri.parse("geo:$lat,$lon?q=$lat,$lon($name)")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
    ) {
        // attributes for the element
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$street • $formattedDistance",   // placeholder
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.alpha(0.6f)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun CafeElementPreview() {
    BrewTheme {
        CafeElement(
            name = TODO(),
            modifier = TODO(),
            street = TODO(),
            lat = TODO(),
            lon = TODO(),
            distance = TODO()
        )
    }
}