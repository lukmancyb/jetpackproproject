package com.dicoding.jetpackproproject.ui.upcoming

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.jetpackproproject.core.utils.Coroutines
import com.dicoding.jetpackproproject.core.utils.LiveDataTestUtil
import com.dicoding.jetpackproproject.data.source.remote.model.MovieEntity
import com.dicoding.jetpackproproject.data.source.repositories.MovieRepository
import com.nhaarman.mockitokotlin2.verify
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.IOException


@RunWith(MockitoJUnitRunner::class)
class UpcomingMovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var viewModel: UpcomingMovieViewModel

    private  val repo = mock(MovieRepository::class.java)


    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = UpcomingMovieViewModel(repo)
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
    }


    @Test
    @Throws(Exception::class)
    fun getUpcomingMovie() {

//        val data = repo.getUpcomingMovie().value

        val courseEntities =  viewModel.getUpcomingMovie().value
        verify(repo).getUpcomingMovie()
        assertNotNull(courseEntities)
        assertEquals(20, courseEntities?.size)

//        viewModel.getUpcomingMovie().observeForever(observer)
//        verify(observer).onChanged(data)



//            assertEquals(22, data.size)

    }


}