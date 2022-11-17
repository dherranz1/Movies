package com.dherranz1.movies.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLE_NAME_MOVIES = "movies"

@Entity(tableName = TABLE_NAME_MOVIES)
data class MovieEntitie(
    @PrimaryKey @ColumnInfo(name = "id")        val id: String,
    @ColumnInfo(name = "title")     val title: String,
    @ColumnInfo(name = "plot")      val plot: String,
    @ColumnInfo(name = "genre")     val genre: String,
    @ColumnInfo(name = "rating")    val rating: Double,
    @ColumnInfo(name = "year")      val year: String,
    @ColumnInfo(name = "poster")    val poster: String
)