package com.example.brew

import com.example.brew.room.LikedCoffee
import com.example.brew.room.LikedCoffeeDao
import com.example.brew.viewmodels.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import kotlinx.coroutines.test.runTest

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FakeLikedCoffeeDao : LikedCoffeeDao {

    private val likedList = mutableListOf<LikedCoffee>()

    override suspend fun getAllLiked(): List<LikedCoffee> {
        return likedList
    }

    override suspend fun insert(likedCoffee: LikedCoffee) {
        likedList.add(likedCoffee)
    }

    override suspend fun delete(likedCoffee: LikedCoffee) {
        likedList.remove(likedCoffee)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel
    private lateinit var fakeDao: FakeLikedCoffeeDao

    // sets up fresh viewmodel
    @Before
    fun setup() {
        fakeDao = FakeLikedCoffeeDao()
        viewModel = HomeViewModel(fakeDao)
    }

    @Test
    fun loadNearbyCafes_test() = runTest {

        // calling function w random london coords
        viewModel.loadNearbyCafes(51.51, 0.13)

        // check if list updated
        assertNotNull(viewModel.cafes)
        assertTrue(viewModel.cafes.isNotEmpty())
    }
}