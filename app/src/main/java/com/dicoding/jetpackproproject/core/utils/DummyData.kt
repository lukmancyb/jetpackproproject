package com.dicoding.jetpackproproject.core.utils

import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity

object DataDummy {


    fun generateRemoteDummyUpcoming(): List<MovieEntity> {
        val upcoming = ArrayList<MovieEntity>()
        upcoming.add(
            MovieEntity(
                id = 1,
                name = "Sonic the hedgehog",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        upcoming.add(
            MovieEntity(
                id = 2,
                name = "The Invisible Man",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        upcoming.add(
            MovieEntity(
                id = 3,
                name = "Bird of Prey",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        upcoming.add(
            MovieEntity(
                id = 4,
                name = "Charlies Angel",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        upcoming.add(
            MovieEntity(
                id = 4,
                name = "Guns Akibo",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        return upcoming
    }
    fun generateRemoteDummyPopular(): List<MovieEntity> {
        val popular = ArrayList<MovieEntity>()
        popular.add(
            MovieEntity(
                id = 10,
                name = "Sonic the hedgehog",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        popular.add(
            MovieEntity(
                id = 11,
                name = "The Invisible Man",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        popular.add(
            MovieEntity(
                id = 12,
                name = "Bird of Prey",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        popular.add(
            MovieEntity(
                id = 13,
                name = "Charlies Angel",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        popular.add(
            MovieEntity(
                id = 14,
                name = "Guns Akibo",
                backdropPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                overview = "Two young people arrive in New York to spend a weekend, but once they arrive they're met with bad weather and a series of adventures.",
                popularity = 1002.275,
                posterPath = "/6fkqwqLEcDZOEAnBBfKAniwNxtx.jpg",
                releaseDate = "2019-07-26",
                voteAverage = 6.7,
                voteCount = 1
            )
        )

        return popular
    }


}