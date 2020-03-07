package com.dicoding.jetpackproproject.data.source.remote.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.dicoding.jetpackproproject.core.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val applicationContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {

//        Log.e("INTERCEPT", isInternetAvailable().toString())
        if (!isInternetAvailable())
            throw NoInternetException("Make sure you have an active internet data connection")
        return chain.proceed(chain.request())
    }

    private fun isInternetAvailable() : Boolean{
        var result = false
        val connectionManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        connectionManager?.let {
                it.getNetworkCapabilities(connectionManager.activeNetwork)?.apply {
                    result = when{
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        else -> false
                    }
                }

        }

        return result
    }
}