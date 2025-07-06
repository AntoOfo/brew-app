package com.example.brew.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val scrollState = rememberScrollState()

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)) {
            Spacer(modifier = Modifier.height(16.dp))
            // carousel
            HorizontalCarousel(coffeeDetails = coffee)

            Spacer(modifier = Modifier.height(20.dp))

            // coffee name
            Text(
                text = coffee.type,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            // origin
            Text(
                text = coffee.origin,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(
                    horizontal = 21.dp, vertical = 16.dp
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Divider(modifier = Modifier.weight(1f))
                Text(
                    text = "Instructions",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Divider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // instructions
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                coffee.instructions.forEach { step ->
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = ParagraphStyle(
                                    textIndent = TextIndent(
                                        firstLine = 0.sp, restLine = 16.sp)
                                )
                            ) {
                                append(step)
                            }
                        },
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 14.dp)
                    )
                }
            }

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