package com.dherranz1.movies.data.remote.retrofit

data class MovieApiModel(
    val id : String,
    val title : String,
    val plot : String,
    val genre : String,
    val rating : Double,
    val year : String,
    val poster : String
)