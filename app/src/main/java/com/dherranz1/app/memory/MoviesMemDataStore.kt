package com.dherranz1.app.memory

import com.dherranz1.movies.domain.MovieDomain

class MoviesMemDataStore {
    companion object {

        private val memoryStore : MemoryDataStore<MovieDomain> = MemoryDataStore<MovieDomain>()

        fun getInstance(): MemoryDataStore<MovieDomain> =
            memoryStore
    }
}