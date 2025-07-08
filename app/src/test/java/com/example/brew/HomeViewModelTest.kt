package com.example.brew

import com.example.brew.viewmodels.HomeViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    // sets up fresh viewmodel
    @Before
    fun setup() {
        viewModel = HomeViewModel()
    }
}