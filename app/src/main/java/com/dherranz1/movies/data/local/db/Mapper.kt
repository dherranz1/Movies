package com.dherranz1.movies.data.local.db

import com.dherranz1.movies.domain.MovieDomain

fun MovieEntitie.toDomain() =
    MovieDomain(
        id      = this.id,
        title   = this.title,
        plot    = this.plot,
        genre   = this.genre,
        rating  = this.rating,
        year    = this.year,
        poster  = this.poster
    )

fun MovieDomain.toEntitie() =
    MovieEntitie(
        id      = this.id,
        title   = this.title,
        plot    = this.plot,
        genre   = this.genre,
        rating  = this.rating,
        year    = this.year,
        poster  = this.poster
    )