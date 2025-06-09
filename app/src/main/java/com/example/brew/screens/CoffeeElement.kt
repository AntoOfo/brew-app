package com.example.brew.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.R
import com.example.brew.ui.theme.BrewTheme

@Composable
fun CoffeeElement(modifier: Modifier = Modifier) {
    var isFavourite by rememberSaveable { mutableStateOf(false) }

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .width(140.dp)
            .height(140.dp)) {

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(R.drawable.espresso),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
            )
            Text(
                text = "Espresso",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
                    .paddingFromBaseline(bottom = 6.dp)

            )
            Text(
                text = "Rich, bold shot of pure coffee with a smooth, intense flavor.",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()) {
                IconButton(
                    onClick = { isFavourite = !isFavourite },
                    modifier = Modifier
                ) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = "Favourite",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .size(18.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun CoffeeElementPreview() {
    BrewTheme {
        CoffeeElement()
    }
}