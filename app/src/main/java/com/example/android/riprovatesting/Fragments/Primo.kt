package com.example.android.riprovatesting.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.riprovatesting.R
import com.example.android.riprovatesting.databinding.FragmentPrimoBinding

class Primo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPrimoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_primo, container, false)
        var numeroClick: Int = 0

        binding.pulsanteAumenta.setOnClickListener {
            numeroClick= aumenta(numeroClick)
            if (numeroClick>10){it.findNavController().navigate(R.id.action_primo_to_secondo)}
            binding.numeroVisualizzazioni.text=numeroClick.toString()
        }
        binding.pulsanteDiminuisci.setOnClickListener {
            numeroClick= diminuisci(numeroClick)
            binding.numeroVisualizzazioni.text=numeroClick.toString()
        }

        binding.PulsanteTermina.setOnClickListener {
            it.findNavController().navigate(R.id.action_primo_to_terzo)
        }

        return binding.root
    }

    fun aumenta(numero: Int ): Int{
        return numero+1
    }

    //da scrivere in forma migliore
    fun diminuisci(numero: Int ): Int{
        if(numero-1<0)return 0
        else return numero-1
    }

}