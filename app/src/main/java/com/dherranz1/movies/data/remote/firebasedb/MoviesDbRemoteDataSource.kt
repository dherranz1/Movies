package com.dherranz1.movies.data.remote.firebasedb

import com.dherranz1.movies.data.remote.RemoteDataSource
import com.dherranz1.movies.domain.MovieDomain
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class MoviesDbRemoteDataSource : RemoteDataSource {

    override suspend fun getAll(): List<MovieDomain> {
        val movies = mutableListOf<MovieDomain>()
        val firebase = Firebase
            .database
            .reference
            .limitToFirst(20)

        val snapshot = firebase.get().await()

        return movies
    }

    override fun get(id: String): MovieDomain? {
        TODO("Not yet implemented")
    }
}