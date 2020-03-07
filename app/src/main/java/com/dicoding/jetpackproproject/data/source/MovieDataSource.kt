package com.dicoding.jetpackproproject.data.source

import androidx.lifecycle.LiveData
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity

interface MovieDataSource {

    fun getPopularMovie(): LiveData<List<MovieEntity>>
    fun getUpcomingMovie(): LiveData<List<MovieEntity>>
    fun getDetailMovie(id: String): MovieEntity
}