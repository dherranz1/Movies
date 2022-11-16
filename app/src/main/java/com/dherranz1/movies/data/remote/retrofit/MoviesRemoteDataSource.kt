package com.dherranz1.movies.data.remote.retrofit


import com.dherranz1.movies.data.remote.RemoteDataSource
import com.dherranz1.movies.domain.MovieDomain
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRemoteDataSource : RemoteDataSource {

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://movies-and-shows-api.cyclic.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var service: MoviesService = retrofit.create(MoviesService::class.java)


    override fun getAll(): List<MovieDomain> =
        service.getAll().execute().body()?.map { movie ->
            movie.toDomain()
        } ?: run {
            emptyList<MovieDomain>()
        }

    override fun get(id: String): MovieDomain? =
        service.get(id).execute().body()?.toDomain()

}