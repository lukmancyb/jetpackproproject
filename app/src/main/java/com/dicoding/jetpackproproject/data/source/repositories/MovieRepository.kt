package com.dicoding.jetpackproproject.data.source.repositories

import com.dicoding.jetpackproproject.core.base.BaseResponse
import com.dicoding.jetpackproproject.data.source.MovieDataSource
import com.dicoding.jetpackproproject.data.source.remote.RemoteDataSource
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity

class MovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData)
            }
    }


    override suspend fun getPopularMovie(): List<MovieEntity> {
        val moviesResult : MutableList<MovieEntity> = mutableListOf()

        remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onMoviesReceived(data: BaseResponse<MovieEntity>) {
                    moviesResult.addAll(data.results)
                }
            })


        return moviesResult
    }

    override suspend fun getUpcomingMovie(): List<MovieEntity> {
        val moviesResult : MutableList<MovieEntity> = mutableListOf()

            remoteDataSource.getUpcomingMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onMoviesReceived(data: BaseResponse<MovieEntity>) {
                    moviesResult.addAll(data.results)
                }
            })

        return moviesResult
    }


    override suspend fun getDetailMovie(id: String): MovieEntity {
        var movieEntity: MovieEntity? = null

            remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovieCallback {
                override fun onMovieReceived(data: MovieEntity?) {
                    data?.let {
                        movieEntity = it
                    }
                }

            })

        return movieEntity!!
    }
}