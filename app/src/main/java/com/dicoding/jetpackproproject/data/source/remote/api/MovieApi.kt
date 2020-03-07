package com.dicoding.jetpackproproject.data.source.remote.api

import com.dicoding.jetpackproproject.core.base.BaseResponse
import com.dicoding.jetpackproproject.core.utils.Constant
import com.dicoding.jetpackproproject.core.utils.Constant.BASE_URL
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.data.source.remote.network.NetworkConnectionInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface MovieApi {

    @GET("/3/movie/popular")
    suspend fun fetchPopularMovies(@Query("api_key") apiKey: String = Constant.API_KEY): Response<BaseResponse<MovieEntity>>

    @GET("/3/movie/upcoming")
    suspend fun fetchUpcomingMovies(@Query("api_key") apiKey: String = Constant.API_KEY): Response<BaseResponse<MovieEntity>>

    @GET("/3/movie/{id}")
    suspend fun fetchDetailMovie(@Path("id") id: String, @Query("api_key") apiKey: String = Constant.API_KEY): Response<MovieEntity>


    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): MovieApi {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }


            val okHttpClient = OkHttpClient.Builder()
//
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(logger)
                .build()


            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(MovieApi::class.java)
        }
    }
}