package com.example.brew.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.ui.theme.BrewTheme
import com.example.brew.viewmodels.HomeViewModel

// bottom navigation bar
@Composable
fun BottomNavigation(
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier) {
    
    val showOnlyLiked = viewModel.showOnlyLiked
    
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {        // left icon
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            },
            selected = !showOnlyLiked,
            onClick = {
                if (showOnlyLiked) {
                    viewModel.toggleShowOnlyLiked()
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary
        )
        )
        NavigationBarItem(
            icon = {        // right icon
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Liked"
                )
            },
            label = {
                Text("Liked")
            },
            selected = showOnlyLiked,
            onClick = {
                if (!showOnlyLiked) {
                    viewModel.toggleShowOnlyLiked()
                }
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.secondary,
                selectedTextColor = MaterialTheme.colorScheme.secondary
            )
        )
    }
}

// navigation rail for landscape view
@Composable
fun NavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(
            start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                    Text("Home")
                },
                selected = true,
                onClick = {},
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )

            Spacer(modifier = Modifier.height(14.dp))

            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null
                    )
                },
                label = {
                    Text("Liked")
                },
                selected = false,
                onClick = {},
                colors = NavigationRailItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = MaterialTheme.colorScheme.secondary
                )
            )
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun BottomNavigationPreview() {
    BrewTheme {
        BottomNavigation(
            viewModel = TODO(),
            modifier = TODO()
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun NavigationRailPreview() {
    BrewTheme {
        NavigationRail()
    }
}