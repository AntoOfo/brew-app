package com.example.brew.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brew.Cafe
import com.example.brew.network.RetrofitInstance
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    // current value of the search query
    var searchQuery by mutableStateOf("")
    private set

    // updates the search query
    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }

    // empty liked set of coffee ids
    var likedCoffee by mutableStateOf(setOf<Int>())
        private set

    // handles if a coffee is liked
    fun toggleFavourite(coffeeId: Int){
        // if coffee id is already in the set of liked coffees
        likedCoffee = if (likedCoffee.contains(coffeeId)) {
            likedCoffee - coffeeId  // remove it
        } else {
            likedCoffee + coffeeId
        }
    }

    // for showing only the liked elements
    var showOnlyLiked by mutableStateOf(false)
        private set

    fun toggleShowOnlyLiked() {
        showOnlyLiked = !showOnlyLiked
    }

    // will hold list of cafes
    var cafes by mutableStateOf<List<Cafe>>(emptyList())
    private set

    var isLoadingCafes by mutableStateOf(false)
    private set

    // error msg
    var cafesErrorMsg by mutableStateOf<String?>(null)
    private set

    fun loadNearbyCafes(lat: Double, lon: Double) {
        viewModelScope.launch {
            try {
                isLoadingCafes = true
                cafesErrorMsg = null

                // calls retro to get json
                val response = RetrofitInstance.cafeService.getNearbyCafes(lat, lon)

                // mapping json details
                cafes = response.features.mapNotNull { feature ->
                    val name = feature.properties.name
                    val street = feature.properties.street ?: ""
                    val coords = feature.geometry.coordinates
                    if (name != null && coords.size >= 2) {
                        Cafe(
                            name = name,
                            street = street,
                            lat = coords[1],   // order on api url
                            lon = coords[0]
                        )
                } else {
                    null
                }
            }

                isLoadingCafes = false
            } catch (e: Exception) {
                isLoadingCafes = false
                cafesErrorMsg = e.message ?: "Error loading cafés"
            }
        }
    }
}