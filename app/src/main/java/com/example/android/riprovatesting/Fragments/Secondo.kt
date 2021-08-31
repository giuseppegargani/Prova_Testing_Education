package com.example.android.riprovatesting.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.riprovatesting.R
import com.example.android.riprovatesting.databinding.FragmentSecondoBinding

class Secondo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentSecondoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_secondo, container, false)
        return binding.root
    }

}