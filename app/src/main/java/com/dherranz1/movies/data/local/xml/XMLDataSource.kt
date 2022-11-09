package com.dherranz1.movies.data.local.xml

import android.content.SharedPreferences
import com.dherranz1.app.IJsonSerializer
import com.dherranz1.movies.data.IDataSource
import com.dherranz1.movies.domain.MovieDomain

class XMLDataSource(private val sharedPreferences: SharedPreferences, private val serializer : IJsonSerializer) : IDataSource {

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

    override fun delete(id: String) =
        editor.remove(id).apply()

}