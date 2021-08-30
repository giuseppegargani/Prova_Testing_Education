package com.example.android.riprovatesting.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.riprovatesting.R
import com.example.android.riprovatesting.databinding.FragmentExampleBinding


class example : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentExampleBinding>(inflater, R.layout.fragment_example, container, false)
        return binding.root
    }

}