package com.example.brew.network

import com.example.brew.FeatureCollection
import retrofit2.http.GET
import retrofit2.http.Query

interface CafeService {

    @GET("places/nearby")
    suspend fun getNearbyCafes(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("limit") limit: Int = 10
    ): FeatureCollection
}