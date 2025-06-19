package com.example.brew.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.CoffeeDetails
import com.example.brew.coffeeDetails
import com.example.brew.ui.theme.BrewTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDetailsSheet(
    coffee: CoffeeDetails,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true  // forces full expand
    )
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // carousel
            HorizontalCarousel(coffeeDetails = coffee)

            Spacer(modifier = Modifier.height(16.dp))

            // coffee name
            Text(
                text = coffee.type,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            // origin
            Text(
                text = "Origin • ${coffee.origin}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    horizontal = 21.dp, vertical = 16.dp
                )
            )

            Divider(modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp))

            Text(
                text = "How to Make:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(horizontal = 21.dp)
                    .paddingFromBaseline(bottom = 14.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // instructions
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                coffee.instructions.forEach { step ->
                    Text(
                        text = step,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun CoffeeDetailsSheetPreview() {
    BrewTheme {
        val espresso = coffeeDetails.first { it.id == 1}
        CoffeeDetailsSheet(
            coffee = espresso,
            onDismiss = {}
        )
    }
}