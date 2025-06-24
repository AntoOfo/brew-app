package com.example.brew.network

import retrofit2.http.GET

interface CafeService {
    @GET("places/nearby")
}