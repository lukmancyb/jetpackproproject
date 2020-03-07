package com.dicoding.jetpackproproject.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.jetpackproproject.R
import com.dicoding.jetpackproproject.core.base.BaseRecyclerViewAdapter
import com.dicoding.jetpackproproject.core.base.BaseViewHolder
import com.dicoding.jetpackproproject.core.utils.Constant
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.ui.detail.MovieDetailActivity
import com.dicoding.jetpackproproject.ui.detail.MovieDetailActivity.Companion.EXTRA_MOVIE
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter : BaseRecyclerViewAdapter<MovieEntity?>() {


    override var layoutResourceId: Int = R.layout.movie_item

    @SuppressLint("SetTextI18n")
    override fun onBindItem(holder: BaseViewHolder, data: MovieEntity?, position: Int) {
        holder.itemView.also {
            it.titleMovie.text = data?.name ?: ""
            it.dateMovie.text = data?.releaseDate ?: ""
            it.popularityMovie.text = "${data?.popularity} Views"
            it.rattingMovie.text = data?.voteAverage.toString()
            it.overviewMovie.text = data?.overview

            it.setOnClickListener { view ->
                Intent(view.context, MovieDetailActivity::class.java).apply {
                    data?.id?.let {
                        putExtra(EXTRA_MOVIE, data.id)

                    }
                    view.context.startActivity(this)
                }
            }

            Glide.with(it.context)
                .load(Constant.IMG_URL + data?.posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(it.imgMovie)

        }

    }
}

//class ItemViewHolder(view: View) : BaseViewHolder(view)