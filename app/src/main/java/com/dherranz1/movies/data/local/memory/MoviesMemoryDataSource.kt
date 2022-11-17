package com.dherranz1.movies.data.local.memory

import com.dherranz1.app.memory.MemoryDataStore
import com.dherranz1.movies.data.local.LocalDataSource
import com.dherranz1.movies.domain.MovieDomain

class MoviesMemoryDataSource(private val memoryDataStore: MemoryDataStore<MovieDomain>) :
    LocalDataSource {

    override fun getAll(): List<MovieDomain> =
        memoryDataStore.getAll()

    override fun get(id: String): MovieDomain? =
        memoryDataStore.get(id)

    override fun save(movie: MovieDomain){
        memoryDataStore.put(movie.id, movie)
    }

    override fun saveAll(movieList: List<MovieDomain>) =
        movieList.forEach { movie ->
            memoryDataStore.put(movie.id,movie)
        }

}