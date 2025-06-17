package com.example.brew.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.CoffeeDetails
import com.example.brew.coffeeDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalCarousel(coffeeDetails: CoffeeDetails) {
    val images = coffeeDetails.imageCarousel

    // horizontal image carousel
    HorizontalMultiBrowseCarousel(
        state = rememberCarouselState { images.size },
        modifier = Modifier
            .fillMaxWidth()
            .height(221.dp),
        preferredItemWidth = 186.dp,    // width of each item
        itemSpacing = 8.dp, // space between each item
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) { index ->
        //for each image..
        Image(
            painter = painterResource(id = images[index]),
            contentDescription = "Coffee Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(205.dp)
                .maskClip(MaterialTheme.shapes.extraLarge)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun HorizontalCarouselLattePreview() {
    // Get the latte coffeeDetails object (id = 3)
    val latte = coffeeDetails.first { it.id == 1 }

    // Show the carousel using latte images
    HorizontalCarousel(coffeeDetails = latte)
}