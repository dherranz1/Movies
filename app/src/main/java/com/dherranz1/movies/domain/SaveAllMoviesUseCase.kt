package com.dherranz1.movies.domain

class SaveAllMoviesUseCase(private val repository: IMoviesRepository) {
    fun execute(movies : List<MovieDomain>) =
        repository.saveAll(movies)
}