package com.dicoding.jetpackproproject.ui.upcoming


import android.os.Bundle
import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.jetpackproproject.R
import com.dicoding.jetpackproproject.core.utils.showLoading
import com.dicoding.jetpackproproject.core.utils.showToast
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.ui.adapter.MovieAdapter
import com.dicoding.jetpackproproject.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv.*


class UpComingMovieFragment : Fragment() {

    companion object {
        const val TAG = "TV_FRAGMENT"
    }

    private lateinit var viewModel: UpcomingMovieViewModel
    private lateinit var mAdapter: MovieAdapter
    private lateinit var factory: ViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        factory = ViewModelFactory.getInstance(requireContext())

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(
                this,
                factory
            )[UpcomingMovieViewModel::class.java]

            progress_tv.showLoading(true)
            viewModel.getUpcomingMovie().observe(this, Observer { res ->
                progress_tv.showLoading(false)

                e("FRAGMENT", res.toString())

                if (!res.isNullOrEmpty()){
                    onMovieFetched(res)
                }else{
                    showToast(requireContext(), "Kesalahan jaringan" )
                }

            })
            mAdapter =
                MovieAdapter()

            rv_tv.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }

        }
    }

    private fun onMovieFetched(response: List<MovieEntity>) {

        if (!response.isNullOrEmpty()){
            mAdapter.addItems(response.toMutableList())
            mAdapter.notifyDataSetChanged()
        }


//        when (response) {
//            is ApiResponse.Success -> {
//                mAdapter.addItems(response.data.toMutableList())
//                mAdapter.notifyDataSetChanged()
//            }
//
//            is ApiResponse.Error -> {
//                e(TAG, response.e.message.toString())
//                showToast(requireContext(), response.e.message.toString())
//            }
//
//            is ApiResponse.Failure -> {
//                e(TAG, response.detail)
//                showToast(requireContext(), response.detail)
//            }
//        }

    }


}


