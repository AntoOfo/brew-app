package com.example.brew.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liked_coffee")
data class LikedCoffee(
    @PrimaryKey val coffeeId: Int
)