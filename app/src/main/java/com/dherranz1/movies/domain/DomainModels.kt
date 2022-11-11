package com.dherranz1.movies.domain

data class MovieDomain(val id : String,
                       val title : String,
                       val plot : String,
                       val genre : String,
                       val rating : Double,
                       val year : String,
                       val poster : String
)