package com.dherranz1.movies.data

import com.dherranz1.movies.domain.MoviesRepository
import com.dherranz1.movies.domain.MovieDomain

class MoviesDataRepository(private val localDataSource : LocalDataSource) : MoviesRepository {
    override fun getAll(): List<MovieDomain> =
        localDataSource.getAll()

    override fun get(id: String): MovieDomain? =
        localDataSource.get(id)

}