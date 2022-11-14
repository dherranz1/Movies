package com.dherranz1.movies.data.remote.firebasedb

import com.dherranz1.movies.domain.MovieDomain

fun MovieDbRemoteModel.toDomain() =
    MovieDomain(
        id      = this.id,
        title   = this.title,
        plot    = this.plot,
        genre   = this.genre,
        rating  = this.rating,
        year    = this.year,
        poster  = this.poster
    )