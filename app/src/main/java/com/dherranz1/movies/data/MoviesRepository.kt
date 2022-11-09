package com.dherranz1.movies.data

import com.dherranz1.movies.domain.IMoviesRepository
import com.dherranz1.movies.domain.MovieDomain

class MoviesRepository(private val dataSource : IDataSource) : IMoviesRepository {
    override fun getAll(): List<MovieDomain> =
        dataSource.getAll()

    override fun get(id: String): MovieDomain? =
        dataSource.get(id)

    override fun save(movie: MovieDomain) =
        dataSource.save(movie)

    override fun saveAll(movieList: List<MovieDomain>) =
        dataSource.saveAll(movieList)

    override fun delete(id: String) =
        dataSource.delete(id)
}