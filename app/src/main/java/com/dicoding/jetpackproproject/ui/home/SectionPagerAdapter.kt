package com.dicoding.jetpackproproject.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.jetpackproproject.R
import com.dicoding.jetpackproproject.ui.popular.PopularMovieFragment
import com.dicoding.jetpackproproject.ui.upcoming.UpComingMovieFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.upcoming, R.string.popular)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> UpComingMovieFragment()
            1 -> PopularMovieFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

}