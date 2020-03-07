package com.dicoding.jetpackproproject.ui.upcoming

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.dicoding.jetpackproproject.core.utils.Coroutines
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.data.source.repositories.MovieRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException


@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UpcomingMovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("      UI thread")

    @Mock
    private lateinit var viewModel: UpcomingMovieViewModel

    @Mock
    private lateinit var repo: MovieRepository


    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        MockitoAnnotations.initMocks(this)
        viewModel = UpcomingMovieViewModel(repo)
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
    }


    @Test
    @Throws(Exception::class)
    fun getUpcomingMovie() {
        val data = viewModel.getUpcomingMovie().value
        assertNotNull(data?.size)



//            assertEquals(22, data.size)

    }


}