package com.example.aadk3sampleapp3.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aadk3sampleapp3.databinding.FragmentOneBinding

class FragmentHome : Fragment() {

    private lateinit var fragOneBinding: FragmentOneBinding
    private val imageUrl = "https://wallpapers.com/images/hd/3d-green-android-icon-hglf3wgojase3hm6.jpg"
    private val imageUrl1 = "https://w0.peakpx.com/wallpaper/335/158/HD-wallpaper-flower-amoled-android-apple-black-dark-galaxy-ios-iphone-note-samsung.jpg"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragOneBinding = FragmentOneBinding.inflate(inflater, container, false)
        return fragOneBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(imageUrl1).into(fragOneBinding.iv)
    }

    /*
    companion object {

        // IMPORTANT -- Singleton Pattern -> Asked in a lot of sys Design Rounds

        // Why we need singleton patterns -> In case of a DB, we dont want multiple instances
        // of the same data base. So we create a single instance and use it across the app
        private var instance: Fragment? = null

        fun newInstance(): Fragment {
            if (instance == null) {
                instance = FragmentOne()
            }
            return instance!!
        }
    }
*/
}

// FragmentOne.newInstance()
// FragmentOne.newInstance() -> some other activity
