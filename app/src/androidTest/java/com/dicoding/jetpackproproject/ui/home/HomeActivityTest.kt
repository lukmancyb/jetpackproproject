package com.dicoding.jetpackproproject.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.dicoding.jetpackproproject.R
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyTv = DummyMovie.generateDummyTv()
    private val dummyMovie = DummyMovie.generateDummyMovies()


    @get:Rule
    var activityRule =ActivityTestRule(HomeActivity::class.java)

    @Test
    fun runTest(){
        loadTvShow()
        loadDetailTv()
        loadMovieShow()
        loadDetailMovie()
    }

    fun loadTvShow(){
        onView(withId(R.id.rv_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size -1))
        Thread.sleep(1500)
    }

    fun loadDetailTv(){
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(1500)
        onView(withId(R.id.titleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.titleDetail)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.overviewDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.overviewDetail)).check(matches(withText(dummyTv[0].deskripsi)))

    }

    fun loadMovieShow(){
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withText("MOVIE SHOW")).check(matches(isDisplayed()))
        onView(withText("MOVIE SHOW")).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size -1))
        Thread.sleep(1500)
    }

    fun loadDetailMovie(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(1500)
        onView(withId(R.id.titleDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.titleDetail)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.overviewDetail)).check(matches(isDisplayed()))
        onView(withId(R.id.overviewDetail)).check(matches(withText(dummyMovie[0].deskripsi)))

    }


}