package com.dicoding.jetpackproproject.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpackproproject.R
import com.dicoding.jetpackproproject.core.utils.Constant
import com.dicoding.jetpackproproject.core.utils.showLoading
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extramovie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]
        progresDetail.showLoading(true)
        intent.extras?.let {
            val id = intent.getIntExtra(EXTRA_MOVIE, 0)
            id.let {
                viewModel.getDetailMovie(it.toString()).observe(this, Observer { data ->
                    progresDetail.showLoading(false)
                    data?.let { detail ->
                        populateMovie(detail)
                    }
                })
            }

        }
    }

    private fun populateMovie(movie: MovieEntity?) {
        movie?.let {
            Glide.with(this)
                .load(Constant.IMG_URL + it.posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imageDetail)
            titleDetail.text = it.name
            dateDetail.text = it.releaseDate
            voteAverageDetail.text = it.voteAverage.toString()
            popularityDetail.text = it.popularity.toString()
            overviewDetail.text = it.overview

        }
    }
}
