package com.example.brew.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LikedCoffeeDao {
    @Query("SELECT * FROM liked_coffee")
    suspend fun getAllLiked(): List<LikedCoffee>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(likedCoffee: LikedCoffee)

    @Delete
    suspend fun delete(likedCoffee: LikedCoffee)
}