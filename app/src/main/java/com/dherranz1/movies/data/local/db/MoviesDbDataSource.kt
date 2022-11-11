package com.dherranz1.movies.data.local.db

import android.content.Context
import com.dherranz1.app.db.MoviesDataBase
import com.dherranz1.movies.data.local.LocalDataSource
import com.dherranz1.movies.domain.MovieDomain

class MoviesDbDataSource(private val appContext: Context) : LocalDataSource{

    private val dao = MoviesDataBase.getInstance(appContext).moviesDao()

    override fun getAll(): List<MovieDomain> =
        dao.getAll().map { movie ->
            movie.toDomain()
        }

    override fun get(id: String): MovieDomain? =
        dao.get(id)?.toDomain()


    override fun save(movie: MovieDomain) =
        dao.insert(movie.toEntitie())


    override fun saveAll(movieList: List<MovieDomain>) =
        movieList.forEach { movie ->
            dao.insert(movie.toEntitie())
        }

}