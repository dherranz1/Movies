package com.dherranz1.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dherranz1.movies.domain.GetAllMoviesUseCase
import com.dherranz1.movies.domain.GetMovieUseCase
import com.dherranz1.movies.presentation.MoviesDetailViewModel
import com.dherranz1.movies.presentation.callbacks.MoviesCallback
import com.dherranz1.movies.presentation.MoviesViewModel
import com.dherranz1.movies.presentation.callbacks.MoviesDetailCallback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getmovies = GetAllMoviesUseCase()
        val viewmodel = MoviesViewModel(getmovies)

        viewmodel.loadAllMoviesWithCallback(object : MoviesCallback {
            override fun onCall(moviesList: List<GetAllMoviesUseCase.MovieResponse>) {
                showMovies(moviesList)
            }
        })

        val getmoviedetail = GetMovieUseCase()
        val viewmodeldetail = MoviesDetailViewModel(getmoviedetail)

        viewmodeldetail.loadMovieDetailWithCallback("superman",object : MoviesDetailCallback {
            override fun onCall(movie: GetMovieUseCase.MovieDetailResponse?) {
                movie?.let { showMovieDetail(movie) }
            }

        })
    }

    fun showMovies(movies : List<GetAllMoviesUseCase.MovieResponse>){
        movies.forEach {
            Log.d("@dev","$it")
        }
    }
    fun showMovieDetail(movie : GetMovieUseCase.MovieDetailResponse){
        Log.d("@dev","$movie")
    }
}