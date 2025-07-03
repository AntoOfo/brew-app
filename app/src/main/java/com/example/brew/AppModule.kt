package com.example.brew

import android.content.Context
import androidx.room.Room
import com.example.brew.room.BrewDatabase
import com.example.brew.room.LikedCoffeeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// tells hilt stuff about db
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // provides the dao for getting liked coffees
    @Provides
    fun provideLikedCoffeeDao(db: BrewDatabase): LikedCoffeeDao {
        return db.likedCoffeeDao()
    }

    // provides room db instance
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): BrewDatabase {
        return Room.databaseBuilder(
            appContext,
            BrewDatabase::class.java,
            "brew_db"
        ).build()
    }

}