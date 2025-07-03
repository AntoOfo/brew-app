package com.example.brew

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// tells hilt stuff about db
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


}