package com.example.brew.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.brew.Cafe

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
}