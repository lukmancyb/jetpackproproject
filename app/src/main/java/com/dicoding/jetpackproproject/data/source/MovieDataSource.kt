package com.dicoding.jetpackproproject.data.source

import androidx.lifecycle.LiveData
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity

interface MovieDataSource {

      suspend fun getPopularMovie(): List<MovieEntity>
      suspend fun getUpcomingMovie() : List<MovieEntity>
     suspend fun getDetailMovie(id: String): MovieEntity
}