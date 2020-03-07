package com.dicoding.jetpackproproject.core.base

import java.io.IOException

data class BaseResponse<T>(val results: List<T>)

sealed class ApiResponse<out T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Failure(val statusCode: Int, val detail: String) : ApiResponse<Nothing>()
    data class Error(val e: IOException) : ApiResponse<Nothing>()
}