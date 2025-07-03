package com.example.brew.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LikedCoffee::class], version = 1)
abstract class BrewDatabase : RoomDatabase() {
    abstract fun likedCoffeeDao(): LikedCoffeeDao
}