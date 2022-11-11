package com.dherranz1.movies.domain

class GetMovieUseCase(private val repository: MoviesRepository) {
    fun execute(id : String) : MovieDetailResponse? =
        repository.get(id)?.let {
            MovieDetailResponse(
                id      = it.id,
                title   = it.title,
                plot    = it.plot,
                genre   = it.genre,
                rating  = it.rating,
                year    = it.year,
                poster  = it.poster
            )
        }


    data class MovieDetailResponse(
        val id : String,
        val title : String,
        val plot : String,
        val genre : String,
        val rating : Double,
        val year : String,
        val poster : String
    )

}