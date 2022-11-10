package com.dherranz1.movies.data

import android.util.Log
import com.dherranz1.movies.data.local.DataSource
import com.dherranz1.movies.data.remote.RemoteDataSource
import com.dherranz1.movies.domain.MoviesRepository
import com.dherranz1.movies.domain.MovieDomain

class MoviesDataRepository(private val dataSource : DataSource, private val remoteDataSource: RemoteDataSource) : MoviesRepository {

    override fun getAll(): List<MovieDomain> {
        var listado = dataSource.getAll()

        if(listado.isEmpty()) {
            Log.d("@dev","OBTENIENDO DE REMOTO")
            listado = remoteDataSource.getAll()
            Log.d("@dev","GUARDANDO EN LOCAL")
            dataSource.saveAll(listado)
        }

        return listado
    }


    override fun get(id: String): MovieDomain? {
        val movie = dataSource.get(id)?: remoteDataSource.get(id)

        movie?.apply {
            dataSource.save(movie)
        }

        return movie
    }

}