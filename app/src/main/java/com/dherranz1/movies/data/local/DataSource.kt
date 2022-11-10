package com.dherranz1.movies.data.local

import com.dherranz1.movies.domain.MovieDomain

interface DataSource {
    fun getAll(): List<MovieDomain>
    fun get(id: String): MovieDomain?
    fun save(movie: MovieDomain)
    fun saveAll(movieList: List<MovieDomain>)
}