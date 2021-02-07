package io.arpit.ourmedium.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import io.arpit.ourmedium.ui.feed.GlobalFeedFragment
import io.arpit.ourmedium.ui.feed.PersonalFeedFragment

class FeedAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private lateinit var currFragment: Fragment

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        when (position) {
            0 -> currFragment = GlobalFeedFragment()

            1 -> currFragment = PersonalFeedFragment()
        }

        return currFragment
    }
}