package com.dherranz1.movies.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie : MovieEntitie)

    @Query("SELECT * FROM $TABLE_NAME_MOVIES WHERE id = :id")
    fun get(id : String) : MovieEntitie?

    @Query("SELECT * FROM $TABLE_NAME_MOVIES")
    fun getAll(): List<MovieEntitie>
}