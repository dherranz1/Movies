package com.dherranz1.movies.data

import com.dherranz1.movies.domain.MoviesRepository
import com.dherranz1.movies.domain.MovieDomain

class MoviesDataRepository(private val dataSource : DataSource) : MoviesRepository {
    override fun getAll(): List<MovieDomain> =
        dataSource.getAll()

    override fun get(id: String): MovieDomain? =
        dataSource.get(id)

}