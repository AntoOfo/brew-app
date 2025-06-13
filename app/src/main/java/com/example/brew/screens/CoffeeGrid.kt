package com.example.brew.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.DrawableStringsSetup
import com.example.brew.coffeeData
import com.example.brew.coffeeData
import com.example.brew.ui.theme.BrewTheme

// grid that holds the coffee elements
@Composable
fun CoffeeGrid(
    coffeeList: List<DrawableStringsSetup>,  // turning coffeedata to a list to be filtered
    modifier: Modifier = Modifier) {
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(coffeeList) { item ->     // populates grid with coffee data
                CoffeeElement(
                    item.drawable,
                    item.coffeeText,
                    item.biotext,
                    item.strengthText
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
            modifier = TODO()
        )
    }
}