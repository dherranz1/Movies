package com.dherranz1.movies.data.remote

import com.dherranz1.movies.domain.MovieDomain

interface RemoteDataSource {
    fun getAll(): List<MovieDomain>
    fun get(id: String): MovieDomain?
}