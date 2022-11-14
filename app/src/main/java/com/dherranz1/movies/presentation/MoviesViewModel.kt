package com.dherranz1.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dherranz1.movies.domain.GetAllMoviesUseCase
import com.dherranz1.movies.presentation.callbacks.MoviesCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel(private val getAllMoviesUseCase: GetAllMoviesUseCase) : ViewModel() {

    fun loadAllMoviesWithCallback(moviesCallback : MoviesCallback){
        viewModelScope.launch(Dispatchers.IO) {
            val movies = getAllMoviesUseCase.execute()
            withContext(Dispatchers.Main){
                moviesCallback.onCall(movies)
            }
        }
    }
}