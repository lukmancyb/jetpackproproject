package com.dicoding.jetpackproproject.ui.detail

import android.util.Log.e
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dicoding.jetpackproproject.data.source.repositories.MovieRepository

class DetailMovieViewModel(private val repository: MovieRepository) : ViewModel(){


    fun getDetailMovie(id : String) = liveData {
       emit(repository.getDetailMovie(id))
        val data = repository.getDetailMovie(id)
        e("DETAIL", data.toString())
    }

}