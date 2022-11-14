package com.dherranz1.movies.presentation.callbacks

import com.dherranz1.movies.domain.GetAllMoviesUseCase
import com.dherranz1.movies.domain.GetMovieUseCase

interface MoviesDetailCallback {
    fun onCall(movie : GetMovieUseCase.MovieDetailResponse?)
}