package com.dherranz1.movies.domain

class DeleteMovieUseCase(private val repository: IMoviesRepository) {
    fun execute(id : String) =
        repository.delete(id)
}