package com.example.brew.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.annotation.StringRes
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.R
import com.example.brew.ui.theme.BrewTheme

@Composable
fun CoffeeElement(
    // refers to the data class for the static strings
    @DrawableRes drawable: Int,
    @StringRes coffeeName: Int,
    @StringRes coffeeBio: Int,
    @StringRes coffeeStrength: Int,
    isFavourite: Boolean,
    onFavouriteToggle: () -> Unit,
    modifier: Modifier = Modifier) {
    

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .fillMaxWidth()
            .height(145.dp)) {

        // for the image, title and desc setup
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                alpha = 0.7F,   // 70% opacity
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(coffeeName),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp)
                    .paddingFromBaseline(bottom = 8.dp)

            )
            Text(
                text = stringResource(coffeeBio),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            // for the bottom strength text and heart icon
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 9.dp, end = 6.dp, top = 6.dp)) {
                Text(
                    text = stringResource(coffeeStrength),
                    color = Color(0xFFB0B0B0),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                )
                IconButton(
                    onClick = onFavouriteToggle,  // toggles onFavourite
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        // if not clicked, show outline icon... otherwise filled icon
                        imageVector = if (isFavourite) Icons.Filled.Favorite else Icons.Outlined.Favorite,
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
        CoffeeElement(
            R.drawable.espresso,
            R.string.espresso,
            R.string.espresso_bio,
            R.string.strong,
            isFavourite = TODO(),
            onFavouriteToggle = TODO(),
            modifier = TODO()
        )
    }
}