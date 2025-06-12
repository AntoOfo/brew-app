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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.coffeeData
import com.example.brew.coffeeData
import com.example.brew.ui.theme.BrewTheme

@Composable
fun CoffeeGrid(modifier: Modifier = Modifier) {

    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
            .height(440.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            items(coffeeData) { item ->
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
        CoffeeGrid()
    }
}