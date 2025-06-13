package com.example.brew.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.brew.R
import com.example.brew.coffeeData
import com.example.brew.ui.theme.BrewTheme
import com.example.brew.viewmodels.HomeViewModel

// for each grid/row
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .paddingFromBaseline(bottom = 16.dp, top = 40.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}

// for search bar and both home sections
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val searchQuery = viewModel.searchQuery  // referring to viewmodel

    // filters coffee title data from the strings setup
    val filteredCoffeeList = coffeeData.filter {
        stringResource(it.coffeeText).contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = modifier
        .verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))

        SearchBar(
            // passing viewmodel state/event to searchbar
            value = searchQuery,
            onValueChange = viewModel::onSearchQueryChange,
            Modifier.padding(horizontal = 16.dp))

        HomeSection(title = R.string.coffee_title) {
            // list of elements shown will be whats searched
            CoffeeGrid(coffeeList = filteredCoffeeList)
        }

        HomeSection(title = R.string.cafe_title) {
            CafeElementRow()
        }

    }
}

// apps portrait layout
@Composable
fun MyAppPortrait() {
    BrewTheme {
        Scaffold(bottomBar = { BottomNavigation() })
        { paddingValues ->
            HomeScreen(modifier =Modifier.padding(paddingValues))
        }
    }
}

// apps landscape layout
@Composable
fun MyAppLandscape() {
    BrewTheme {
        Surface(        // manually set the background because the color disappears for some reason
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                NavigationRail()
                HomeScreen()
            }
        }
    }
}

// finalised app layout portrait/landscape to be called
@Composable
fun MyApp(windowSize: WindowSizeClass) {

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MyAppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            MyAppLandscape()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E, heightDp = 700)
@Composable
fun PortraitAppPreview() {
    MyAppPortrait()
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E, widthDp = 860)
@Composable
fun LandscapeAppPreview() {
    MyAppLandscape()
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E)
@Composable
fun HomeScreenPreview() {
    BrewTheme {
        HomeScreen()
    }
}
