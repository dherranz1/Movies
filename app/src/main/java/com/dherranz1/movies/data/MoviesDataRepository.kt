package com.dherranz1.movies.data

import android.util.Log
import com.dherranz1.movies.data.local.LocalDataSource
import com.dherranz1.movies.data.remote.RemoteDataSource
import com.dherranz1.movies.domain.MoviesRepository
import com.dherranz1.movies.domain.MovieDomain

class MoviesDataRepository(private val dataSource : LocalDataSource, private val remoteDataSource: RemoteDataSource) : MoviesRepository {

    override fun getAll(): List<MovieDomain> {
        var listado = dataSource.getAll()

        if(listado.isEmpty()) {
            listado = remoteDataSource.getAll()
            dataSource.saveAll(listado)
        }

        return listado
    }


    override fun get(id: String): MovieDomain? {
        var movie = dataSource.get(id)

        movie?: run {
            movie = remoteDataSource.get(id)
            movie?.let {
                dataSource.save(it)
            }
        }

        return movie
    }

}