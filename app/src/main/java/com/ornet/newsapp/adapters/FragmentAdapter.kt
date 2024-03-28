package com.ornet.newsapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ornet.newsapp.fragmentClasses.BusinessFragment
import com.ornet.newsapp.fragmentClasses.EntertainmentFragment
import com.ornet.newsapp.fragmentClasses.GeneralFragment
import com.ornet.newsapp.fragmentClasses.HealthFragment
import com.ornet.newsapp.fragmentClasses.ScienceFragment
import com.ornet.newsapp.fragmentClasses.SportsFragment
import com.ornet.newsapp.fragmentClasses.TechFragment
import com.ornet.newsapp.utils.Constants.TOTAL_NEWS_TAB

class FragmentAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle){

    override fun getItemCount(): Int = TOTAL_NEWS_TAB

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> {
                return GeneralFragment()
            }
            1 -> {
                return BusinessFragment()
            }
            2 -> {
                return EntertainmentFragment()
            }
            3 -> {
                return ScienceFragment()
            }
            4 -> {
                return SportsFragment()
            }
            5 -> {
                return TechFragment()
            }
            6 -> {
                return HealthFragment()
            }

            else -> return BusinessFragment()

        }
    }
}