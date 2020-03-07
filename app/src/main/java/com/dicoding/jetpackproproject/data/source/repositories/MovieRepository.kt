package com.dicoding.jetpackproproject.data.source.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.jetpackproproject.core.base.BaseResponse
import com.dicoding.jetpackproproject.core.utils.Coroutines
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


    override  fun getPopularMovie(): LiveData<List<MovieEntity>> {
        val moviesResult = MutableLiveData<List<MovieEntity>>()

        Coroutines.main {


        remoteDataSource.getPopularMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onMoviesReceived(data: BaseResponse<MovieEntity>) {
                    moviesResult.postValue(data.results)
                }
            })
        }



        return moviesResult
    }

    override  fun getUpcomingMovie(): LiveData<List<MovieEntity>> {
        val moviesResult =  MutableLiveData<List<MovieEntity>>()

        Coroutines.main {
            remoteDataSource.getUpcomingMovies(object : RemoteDataSource.LoadMoviesCallback {
                override fun onMoviesReceived(data: BaseResponse<MovieEntity>) {
                    moviesResult.postValue(data.results)
                }
            })
        }

        return moviesResult
    }


    override  fun getDetailMovie(id: String): MovieEntity {
        var movieEntity: MovieEntity? = null

        Coroutines.main {
            remoteDataSource.getDetailMovie(id, object : RemoteDataSource.LoadDetailMovieCallback {
                override fun onMovieReceived(data: MovieEntity?) {
                    data?.let {
                        movieEntity = it
                    }
                }

            })
        }


        return movieEntity!!
    }
}