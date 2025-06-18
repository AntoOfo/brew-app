package com.example.brew.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.brew.CoffeeDetails

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
        // carousel
        HorizontalCarousel(coffeeDetails = coffee)
    }
}