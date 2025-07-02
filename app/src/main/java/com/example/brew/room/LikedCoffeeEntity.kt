package com.example.brew.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "liked_coffees")
data class LikedCoffeeEntry(
    @PrimaryKey
    val coffeeId: Int
)