package com.example.brew.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

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
    fun toggleFavourite(coffeeResId: Int){
        // if coffee id is already in the set of liked coffees
        likedCoffee = if (likedCoffee.contains(coffeeResId)) {
            likedCoffee - coffeeResId  // remove it
        } else {
            likedCoffee + coffeeResId
        }
    }
}