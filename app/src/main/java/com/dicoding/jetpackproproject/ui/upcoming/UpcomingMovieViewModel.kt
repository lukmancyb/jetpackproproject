package com.dicoding.jetpackproproject.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dicoding.jetpackproproject.core.utils.Coroutines
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.data.source.repositories.MovieRepository

class UpcomingMovieViewModel(private val repository: MovieRepository) : ViewModel() {

    companion object {
        const val TAG = "TV_VIEW_MODEL"
    }

//    fun getUpcomingMovie(): LiveData<List<MovieEntity>> {
//
//        val data = MutableLiveData<List<MovieEntity>>()
//        Coroutines.io {
//            try {
//                val movies = repository.getUpcomingMovie()
//                data.postValue(movies)
//            } catch (i: NoInternetException) {
////                emit(ApiResponse.Failure(i.hashCode(), i.message.toString()))
//                data.postValue(null)
//                e(PopularMovieViewModel.TAG, i.message.toString())
//            } catch (e: ApiException) {
//                data.postValue(null)
//
////                emit(ApiResponse.Failure(e.hashCode(), e.message.toString()))
//                e(PopularMovieViewModel.TAG, e.message.toString())
//
//            } catch (e: IOException) {
////                emit(ApiResponse.Error(e))
//                data.postValue(null)
//
//                e(PopularMovieViewModel.TAG, e.message.toString())
//
//            }
//        }
//        return data
//
//    }

    fun getUpcomingMovie() = repository.getUpcomingMovie()
    fun getDataDummy(): LiveData<List<String>> {

        val data = MutableLiveData<List<String>>()

        data.postValue(listOf("aku", "kamu"))

        return data

    }


}