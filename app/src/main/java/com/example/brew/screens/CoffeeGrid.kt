package com.example.brew.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.brew.DrawableStringsSetup
import com.example.brew.coffeeData
import com.example.brew.coffeeData
import com.example.brew.ui.theme.BrewTheme
import kotlinx.coroutines.delay

// grid that holds the coffee elements
@Composable
fun CoffeeGrid(
    coffeeList: List<DrawableStringsSetup>,  // turning coffeedata to a list to be filtered
    likedCoffees: List<Int>, // current liked coffee ids
    onFavouriteToggle: (Int) -> Unit,
    onItemClick: (Int) -> Unit,    // clickable item param
    modifier: Modifier = Modifier) {

    val haptic = LocalHapticFeedback.current

    val configuration = LocalConfiguration.current  // allows app to see used device specs
    val screenHeightDp = configuration.screenHeightDp.dp

    val gridHeight = (screenHeightDp * 0.55f).coerceIn(300.dp, 490.dp)   // allows grid height to be dynamic based on screen height

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
            .height(gridHeight)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),   // two elements per row
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(coffeeList) { index, item ->     // populates grid with coffee data
                // general grid animation

                // tracks if item should visible
                var visible by remember { mutableStateOf(false) }
                // fade in animation
                val alpha by animateFloatAsState(
                    targetValue = if (visible) 1f else 0f,
                    animationSpec = tween(durationMillis = 250, delayMillis = index*50),
                    label = "fadeInAnimation"
                )
                // slide in animation
                val offsetY by animateIntAsState(
                    targetValue = if (visible) 0 else 30,
                    animationSpec = tween(durationMillis = 250, delayMillis = index*50),
                    label = "slideInAnimation"

                )

                LaunchedEffect(Unit) {  // stagger delay if needed
                    visible = true
                }

                // element animation

                var isClicked by remember { mutableStateOf(false) }

                // scale animation
                val scale by animateFloatAsState(
                    targetValue = if (isClicked) 0.95f else 1f,
                    animationSpec = tween(durationMillis = 120),
                    label = "scaleAnimation"
                )

                LaunchedEffect(isClicked) {
                    if (isClicked) {
                        delay(100)
                        isClicked = false
                    }
                }

                CoffeeElement(
                    item.drawable,
                    item.coffeeText,
                    item.biotext,
                    item.strengthText,
                    likedCoffees.contains(item.id),  // id pass
                    { onFavouriteToggle(item.id) },  // id pass for favouritng
                    onClick = {
                        isClicked = true
                        onItemClick(item.id)
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    },
                    modifier = Modifier
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                        }
                        .alpha(alpha)
                        .offset { IntOffset(0, offsetY) }
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun CoffeeGridPreview() {
    BrewTheme {
        CoffeeGrid(
            coffeeList = TODO(),
            modifier = TODO(),
            likedCoffees = TODO(),
            onFavouriteToggle = TODO(),
            onItemClick = TODO()
        )
    }
}