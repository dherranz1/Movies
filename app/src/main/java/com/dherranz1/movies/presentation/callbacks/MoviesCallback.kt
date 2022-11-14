package com.dherranz1.movies.presentation.callbacks

import com.dherranz1.movies.domain.GetAllMoviesUseCase

interface MoviesCallback {
    fun onCall(moviesList : List<GetAllMoviesUseCase.MovieResponse>)
}