package com.dherranz1.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dherranz1.movies.domain.GetMovieUseCase
import com.dherranz1.movies.presentation.callbacks.MoviesDetailCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesDetailViewModel(private val getMovieUseCase: GetMovieUseCase) : ViewModel() {

    fun loadMovieDetailWithCallback(movieId : String, moviesDetailCallback : MoviesDetailCallback){
        viewModelScope.launch(Dispatchers.IO) {
            val movie = getMovieUseCase.execute(movieId)
            withContext(Dispatchers.Main){
                moviesDetailCallback.onCall(movie)
            }
        }
    }
}