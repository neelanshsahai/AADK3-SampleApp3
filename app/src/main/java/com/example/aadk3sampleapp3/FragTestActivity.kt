package com.example.aadk3sampleapp3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.aadk3sampleapp3.databinding.ActivityFragTestBinding
import com.example.aadk3sampleapp3.databinding.ViewpagerTestBinding
import com.example.aadk3sampleapp3.fragments.FragmentHome
import com.example.aadk3sampleapp3.fragments.FragmentPost
import com.example.aadk3sampleapp3.fragments.FragmentProfile
import com.example.aadk3sampleapp3.fragments.FragmentSearch
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.Tab

// TODO: Add Themes -> Dark and Light (Select Colors for the themes as well)
class FragTestActivity : AppCompatActivity() {

//    private val fragBinding by lazy {
//        ActivityFragTestBinding.inflate(layoutInflater)
//    }
    private val viewpagerBinding by lazy {
        ViewpagerTestBinding.inflate(layoutInflater)
    }

    private lateinit var onPageChangedCallback: OnPageChangeCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewpagerBinding.root)

        viewpagerBinding.viewpager.adapter = ViewpagerAdapter(supportFragmentManager, lifecycle)
        viewpagerBinding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: Tab?) {
                if (tab != null) {
                    viewpagerBinding.viewpager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: Tab?) {}

            override fun onTabReselected(tab: Tab?) {}
        })

        onPageChangedCallback = object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewpagerBinding.tabLayout.selectTab(viewpagerBinding.tabLayout.getTabAt(position))
            }
        }
        viewpagerBinding.viewpager.registerOnPageChangeCallback(onPageChangedCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewpagerBinding.viewpager.unregisterOnPageChangeCallback(onPageChangedCallback)
    }

//        fragBinding.bottomNav.setOnItemSelectedListener {
//            when (it.itemId) {
//
//                R.id.botNavHome -> setFragmentToContainer(FragmentHome())
//
//                R.id.botNavSearch -> setFragmentToContainer(FragmentSearch())
//
//                R.id.botNavPost -> setFragmentToContainer(FragmentSearch())
//
//                R.id.botNavProfile -> setFragmentToContainer(FragmentProfile())
//
//                else -> setFragmentToContainer(FragmentHome())
//            }
//            true
//        }
//    }

//    private fun setFragmentToContainer(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(fragBinding.container.id, fragment)
//            //.setCustomAnimations(enter, exit, popEnter, popExit)
//            .commit()
//    }
}

class ViewpagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentHome()
            1 -> FragmentSearch()
            2 -> FragmentPost()
            else -> FragmentHome()
        }
    }
}


/*
1- Authentication Flow -> AuthActivity -> LoginFrag, SignUpFrag
2- Dashboard Flow -> DashAct -> RecommendationFrag, SearchFrag
3- Playlist Flow -> PlaylistAct -> CurrentPlayingPlaylistFrag, OtherPlaylistsFrag
4- MediaPlayer Flow -> PlayerActivity -> NowPlayingFragment, UpNextFrag
5- Options Flow -> ProfileFrag, SettingsFrag, AboutUsFrag
*/
