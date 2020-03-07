package com.dicoding.jetpackproproject.di

import android.content.Context
import com.dicoding.jetpackproproject.data.source.remote.RemoteDataSource
import com.dicoding.jetpackproproject.data.source.remote.api.MovieApi
import com.dicoding.jetpackproproject.data.source.remote.network.NetworkConnectionInterceptor
import com.dicoding.jetpackproproject.data.source.repositories.MovieRepository


object Injection {

    fun provideRespository(context: Context) : MovieRepository{

        val mContext = context.applicationContext
        val remoteDataSource = RemoteDataSource.getInstance(MovieApi.invoke( NetworkConnectionInterceptor(mContext)))

        return MovieRepository.getInstance(remoteDataSource)

    }
}