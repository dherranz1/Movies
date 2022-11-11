package com.dherranz1.movies.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntitie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDAO
}