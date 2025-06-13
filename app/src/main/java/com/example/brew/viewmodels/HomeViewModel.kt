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
}