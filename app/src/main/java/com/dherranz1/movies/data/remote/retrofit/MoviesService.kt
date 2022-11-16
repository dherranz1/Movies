package com.dherranz1.movies.data.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("movies")
    fun getAll(): Call<List<MovieApiModel>>

    @GET("movies/{id}")
    fun get(@Path("id") id: String): Call<MovieApiModel>
}