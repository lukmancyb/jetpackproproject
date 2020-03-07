package com.dicoding.jetpackproproject.ui.popular

import android.util.Log.e
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dicoding.jetpackproproject.core.utils.ApiException
import com.dicoding.jetpackproproject.core.utils.Coroutines
import com.dicoding.jetpackproproject.core.utils.NoInternetException
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.data.source.repositories.MovieRepository
import java.io.IOException

class PopularMovieViewModel(private val repository: MovieRepository) : ViewModel() {

    companion object {
        const val TAG = "MOVIE_VIEW_MODEL"
    }


    //    fun getData(): LiveData<List<MovieEntity>> {
//
//        val data = MutableLiveData<List<MovieEntity>>()
//        Coroutines.io {
//            try {
//                val movies = repository.getPopularMovie()
//                data.postValue(movies)
//            } catch (i: NoInternetException) {
////                emit(ApiResponse.Failure(i.hashCode(), i.message.toString()))
//                data.postValue(null)
//                e(TAG, i.message.toString())
//            } catch (e: ApiException) {
//                data.postValue(null)
//
////                emit(ApiResponse.Failure(e.hashCode(), e.message.toString()))
//                e(TAG, e.message.toString())
//
//            } catch (e: IOException) {
////                emit(ApiResponse.Error(e))
//                data.postValue(null)
//
//                e(TAG, e.message.toString())
//
//            }
//        }
//        return data
//
//    }
     fun getPopularMovie() = repository.getPopularMovie()



}