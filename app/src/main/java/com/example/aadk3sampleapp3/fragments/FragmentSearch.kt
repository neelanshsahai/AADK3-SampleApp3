package com.example.aadk3sampleapp3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aadk3sampleapp3.databinding.FragmentTwoBinding

class FragmentSearch: Fragment() {

    private lateinit var fragTwoBinding: FragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragTwoBinding = FragmentTwoBinding.inflate(inflater, container, false)
        return fragTwoBinding.root
    }
}
