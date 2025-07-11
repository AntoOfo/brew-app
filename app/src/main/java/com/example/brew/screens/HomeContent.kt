package com.example.brew.screens

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.brew.CoffeeDetails
import com.example.brew.LocationPermissionState
import com.example.brew.R
import com.example.brew.coffeeData
import com.example.brew.coffeeDetails
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
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    refreshLocation: (() -> Unit)? = null,
    locationPermissionState: LocationPermissionState = LocationPermissionState.UNDECIDED
) {

    val configuration = LocalConfiguration.current  // allows app to see used device specs
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    val screenHeightDp = configuration.screenHeightDp.dp
    val gridHeight = (screenHeightDp * 0.55f).coerceIn(300.dp, 490.dp)

    val searchQuery = viewModel.searchQuery  // referring to viewmodel for searches
    val likedCoffees = viewModel.likedCoffee // viewmodel for liked coffees
    val likedCoffeesList = likedCoffees.toList()

    val showOnlyLiked = viewModel.showOnlyLiked

    // filters coffee title data from the strings setup
    val filteredCoffeeList = coffeeData.filter {
        stringResource(it.coffeeText).contains(searchQuery, ignoreCase = true)
    }

    // furthers filters with the liked elements
    val displayCoffeeList = if (showOnlyLiked) {
        filteredCoffeeList.filter { likedCoffees.contains(it.id) }
    } else {
        filteredCoffeeList
    }

    val cafes = viewModel.cafes
    val isLoadingCafes = viewModel.isLoadingCafes
    val cafesErrorMsg = viewModel.cafesErrorMsg

    var selectedCoffee by remember { mutableStateOf<CoffeeDetails?>(null) }
    val sheetVisible = selectedCoffee != null

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .then(  // if landscape, be scrollable
                if (isLandscape) Modifier.verticalScroll(scrollState) else Modifier
            )) {
        Spacer(Modifier.height(16.dp))

        SearchBar(
            // passing viewmodel state/event to searchbar
            value = searchQuery,
            onValueChange = viewModel::onSearchQueryChange,
            Modifier.padding(horizontal = 16.dp)
        )

        HomeSection(title = R.string.coffee_title) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(gridHeight)
            ) {
                // when theres no liked elements but btn is clicked
                if (displayCoffeeList.isEmpty() && showOnlyLiked) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No liked coffees yet!",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(24.dp)
                        )
                    }
                } else {
                    // list of elements shown will be whats searched
                    CoffeeGrid(
                        coffeeList = displayCoffeeList,
                        likedCoffees = likedCoffeesList,
                        onFavouriteToggle = { coffeeId -> viewModel.toggleFavourite(coffeeId) },
                        onItemClick = { clickedId ->
                            val match = coffeeDetails.find { it.id == clickedId }
                            if (match != null) selectedCoffee = match
                        },
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }

        if (sheetVisible) {
            selectedCoffee?.let { coffee ->
                CoffeeDetailsSheet(
                    coffee = coffee,
                    onDismiss = { selectedCoffee = null }
                )
            }
        }

        HomeSection(title = R.string.cafe_title) {
            when {
                locationPermissionState == LocationPermissionState.DENIED -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Location perms is needed to show cafes")
                    }
                }
                        isLoadingCafes -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.padding(16.dp),
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }

                        cafesErrorMsg != null -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                                    .height(70.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Button(
                                    onClick = {
                                        refreshLocation?.invoke()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.surface,
                                        contentColor = MaterialTheme.colorScheme.secondary
                                    ),
                                    border = BorderStroke(
                                        0.5.dp,
                                        color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
                                    )
                                ) {
                                    Icon(
                                        Icons.Filled.Refresh,
                                        contentDescription = "Refresh button",
                                        modifier = Modifier.padding(end = 6.dp)
                                    )
                                    Text("Try again?")
                                }
                            }
                        }

                        cafes.isNotEmpty() -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(70.dp)
                            ) {
                                CafeElementRow(
                                    cafes = cafes,
                                    modifier = Modifier
                                )
                            }
                        }

                locationPermissionState == LocationPermissionState.GRANTED -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp)
                                    .height(70.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Button(
                                    onClick = { refreshLocation?.invoke() },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.surface,
                                        contentColor = MaterialTheme.colorScheme.secondary
                                    ),
                                    border = BorderStroke(
                                        0.5.dp,
                                        color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
                                    )
                                ) {
                                    Icon(
                                        Icons.Filled.Refresh,
                                        contentDescription = "Refresh button",
                                        modifier = Modifier.padding(end = 6.dp)
                                    )
                                    Text("Try again?")
                                }
                            }
                        }
                    }

                }
            }
        }

// apps portrait layout
@Composable
fun MyAppPortrait(
    refreshLocation: (() -> Unit)? = null,
    locationPermissionState: LocationPermissionState = LocationPermissionState.UNDECIDED) {
    val viewModel: HomeViewModel = hiltViewModel()
    BrewTheme {
        Scaffold(bottomBar = { BottomNavigation(viewModel = viewModel) })
        { paddingValues ->
            HomeScreen(
                viewModel = viewModel,
                modifier =Modifier.padding(paddingValues),
                refreshLocation = refreshLocation,
                locationPermissionState = locationPermissionState)
        }
    }
}

// apps landscape layout
@Composable
fun MyAppLandscape(
    refreshLocation: (() -> Unit)? = null,
    locationPermissionState: LocationPermissionState = LocationPermissionState.UNDECIDED) {
    val viewModel: HomeViewModel = hiltViewModel()
    BrewTheme {
        Surface(        // manually set the background because the color disappears for some reason
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Row {
                NavigationRail(viewModel = viewModel)
                HomeScreen(
                    viewModel = viewModel,
                    refreshLocation = refreshLocation,
                    locationPermissionState = locationPermissionState)
            }
        }
    }
}

// finalised app layout portrait/landscape to be called
@Composable
fun MyApp(
    refreshLocation: (() -> Unit)? = null,
    locationPermissionState: LocationPermissionState = LocationPermissionState.UNDECIDED) {

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        MyAppLandscape(refreshLocation = refreshLocation, locationPermissionState)
    } else {
        MyAppPortrait(refreshLocation = refreshLocation, locationPermissionState)
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
