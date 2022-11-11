package com.dherranz1.movies.data

import com.dherranz1.movies.data.local.LocalDataSource
import com.dherranz1.movies.data.remote.RemoteDataSource
import com.dherranz1.movies.domain.MoviesRepository
import com.dherranz1.movies.domain.MovieDomain

class MoviesDataRepository(private val localDataSource : LocalDataSource, private val remoteDataSource: RemoteDataSource) : MoviesRepository {

    override fun getAll(): List<MovieDomain> {
        var listado = localDataSource.getAll()

        if(listado.isEmpty()) {
            listado = remoteDataSource.getAll()
            localDataSource.saveAll(listado)
        }

        return listado
    }


    override fun get(id: String): MovieDomain? {
        var movie = localDataSource.get(id)

        movie?: run {
            movie = remoteDataSource.get(id)
            movie?.let {
                localDataSource.save(it)
            }
        }

        return movie
    }

}