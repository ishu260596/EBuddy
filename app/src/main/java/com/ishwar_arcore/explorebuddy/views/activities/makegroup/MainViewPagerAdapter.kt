package com.ishwar_arcore.explorebuddy.views.activities.makegroup

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MainViewPagerAdapter(activity: MakeGroupActivity, list: List<Fragment>) :
    FragmentStateAdapter(activity) {

    val fragList = list

    override fun getItemCount(): Int {
        return fragList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragList[position]
    }
}