package com.dicoding.jetpackproproject.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.jetpackproproject.di.Injection
import com.dicoding.jetpackproproject.data.source.repositories.MovieRepository
import com.dicoding.jetpackproproject.ui.detail.DetailMovieViewModel
import com.dicoding.jetpackproproject.ui.popular.PopularMovieViewModel
import com.dicoding.jetpackproproject.ui.upcoming.UpcomingMovieViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory private constructor(private val movieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRespository(context))
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return when {
            modelClass.isAssignableFrom(UpcomingMovieViewModel::class.java) -> {
                UpcomingMovieViewModel(movieRepository) as T
            }

            modelClass.isAssignableFrom(PopularMovieViewModel::class.java) -> {
                PopularMovieViewModel(movieRepository) as T
            }

            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}