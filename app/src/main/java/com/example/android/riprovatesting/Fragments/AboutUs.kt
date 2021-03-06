package com.example.android.riprovatesting.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.riprovatesting.R
import com.example.android.riprovatesting.databinding.FragmentAboutUsBinding

class AboutUs : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAboutUsBinding>(inflater, R.layout.fragment_about_us, container, false)
        return binding.root
    }

}