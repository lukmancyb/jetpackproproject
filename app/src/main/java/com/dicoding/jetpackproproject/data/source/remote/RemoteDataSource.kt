package com.dicoding.jetpackproproject.data.source.remote

import com.dicoding.jetpackproproject.core.base.BaseResponse
import com.dicoding.jetpackproproject.data.source.remote.api.MovieApi
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.data.source.remote.network.SafeApiRequest

open class RemoteDataSource(private val api: MovieApi) : SafeApiRequest() {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(api: MovieApi): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(api)
            }
    }

     suspend fun getPopularMovies(callback: LoadMoviesCallback) {
        callback.onMoviesReceived(
            apiRequest { api.fetchPopularMovies() }
        )
    }

    suspend fun getUpcomingMovies(callback: LoadMoviesCallback) {
        callback.onMoviesReceived(apiRequest { api.fetchUpcomingMovies() })

    }


    suspend fun getDetailMovie(id : String, callback: LoadDetailMovieCallback) {
        callback.onMovieReceived(apiRequest { api.fetchDetailMovie(id)})

    }
    interface LoadMoviesCallback {
        fun onMoviesReceived(data: BaseResponse<MovieEntity>)
    }

    interface LoadDetailMovieCallback {
        fun onMovieReceived(data: MovieEntity?)
    }
}








