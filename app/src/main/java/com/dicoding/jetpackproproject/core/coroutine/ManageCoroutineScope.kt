package com.dicoding.jetpackproproject.core.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

interface ManagedCoroutineScope : CoroutineScope {
    abstract fun launch(block: suspend CoroutineScope.() -> Unit) : Job
}