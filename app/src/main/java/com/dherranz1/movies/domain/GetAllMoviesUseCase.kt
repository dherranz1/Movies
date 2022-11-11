package com.dherranz1.movies.domain

class GetAllMoviesUseCase(private val repository: MoviesRepository) {
    fun execute() : List<MovieResponse> =
        repository.getAll().map {
            MovieResponse(
                id      = it.id,
                title   = it.title,
                rating  = it.rating,
                year    = it.year,
                poster  = it.poster
            )
        }


    data class MovieResponse(
        val id      : String,
        val title   : String,
        val rating  : Double,
        val year    : String,
        val poster  : String
    )

}