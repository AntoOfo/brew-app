package com.example.brew.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://brew-app-wzfl.onrender.com/")  // 10.0.2.2 is emulators ip
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cafeService: CafeService = retrofit.create(CafeService::class.java)
}