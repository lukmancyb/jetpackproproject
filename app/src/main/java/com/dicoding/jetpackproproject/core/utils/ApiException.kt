package com.dicoding.jetpackproproject.core.utils

import java.io.IOException

class ApiException(messge : String) : IOException(messge)
class NoInternetException(message : String?) : IOException(message)

