package com.dherranz1.movies.domain

interface MoviesRepository {
    fun getAll() : List<MovieDomain>
    fun get(id : String) : MovieDomain?
}