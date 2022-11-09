package com.dherranz1.movies.domain

interface IMoviesRepository {
    fun getAll() : List<MovieDomain>
    fun get(id : String) : MovieDomain?
    fun save(movie : MovieDomain)
    fun saveAll(movieList : List<MovieDomain>)
    fun delete(id : String)
}