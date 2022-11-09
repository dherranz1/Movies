package com.dherranz1.movies.domain

class SaveMovieUseCase(private val repository: IMoviesRepository) {
    fun execute(movie : MovieDomain) =
        repository.save(movie)
}