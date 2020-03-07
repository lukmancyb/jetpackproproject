package com.dicoding.jetpackproproject.ui.popular


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpackproproject.R
import com.dicoding.jetpackproproject.core.base.ApiResponse
import com.dicoding.jetpackproproject.core.utils.Coroutines
import com.dicoding.jetpackproproject.core.utils.showLoading
import com.dicoding.jetpackproproject.core.utils.showToast
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.ui.adapter.MovieAdapter
import com.dicoding.jetpackproproject.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class PopularMovieFragment : Fragment() {

    private lateinit var viewModelPopular: PopularMovieViewModel
    private lateinit var mAdapter: MovieAdapter
    private lateinit var factory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        factory = ViewModelFactory.getInstance(requireContext())

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModelPopular = ViewModelProvider(
                this,
                factory
            )[PopularMovieViewModel::class.java]
            progress_movie.showLoading(true)

            Coroutines.main{

            viewModelPopular.getUpcomingMovie().observe(this, Observer { res ->
                progress_movie.showLoading(false)
                if (!res.isNullOrEmpty()){
                    onMovieFetched(res)
                }else{
                    showToast(requireContext(), "Kesalahan jaringan" )
                }
            })
            mAdapter = MovieAdapter()

            rv_movie.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
        }

    }

    private fun onMovieFetched(response: List<MovieEntity>) {
      if (!response.isNullOrEmpty()){
          mAdapter.addItems(response.toMutableList())
      }


    }

}
