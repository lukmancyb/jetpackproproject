package com.dicoding.jetpackproproject.core.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun ProgressBar.showLoading(flag : Boolean){
    this.visibility = when(flag){
        true -> View.VISIBLE
        false -> View.GONE
    }
}

fun showToast(context: Context, msg : String){
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
}