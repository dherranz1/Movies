package com.dherranz1.movies.data.local.xml

import android.content.SharedPreferences
import com.dherranz1.app.JsonSerializer
import com.dherranz1.movies.data.DataSource
import com.dherranz1.movies.domain.MovieDomain

class MoviesXMLDataSource(private val sharedPreferences: SharedPreferences, private val serializer : JsonSerializer) : DataSource {

    private val editor = sharedPreferences.edit()

    override fun getAll(): List<MovieDomain> =
        sharedPreferences.all.map { movie ->
            serializer.fromJson(movie.value.toString(),MovieDomain::class.java)
        }

    override fun get(id: String): MovieDomain? =
        sharedPreferences.getString(id,null)?.let { json ->
            serializer.fromJson(json,MovieDomain::class.java)
        }

    override fun save(movie: MovieDomain) =
        editor.putString(movie.id,serializer.toJson(movie,MovieDomain::class.java)).apply()

    override fun saveAll(movieList: List<MovieDomain>) =
        movieList.forEach { movie ->
            save(movie)
        }

}