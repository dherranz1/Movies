package com.dherranz1.app.db

import android.content.Context
import androidx.room.Room
import com.dherranz1.movies.data.local.db.AppDatabase

class MoviesDataBase{

    companion object {
        private lateinit var appContext: Context
        private val database : AppDatabase by lazy() {
            Room.databaseBuilder(
                appContext,
                AppDatabase::class.java, "movies"
            ).build()
        }

        fun getInstance(appContext: Context): AppDatabase {
            this.appContext = appContext
            return database
        }
    }
}