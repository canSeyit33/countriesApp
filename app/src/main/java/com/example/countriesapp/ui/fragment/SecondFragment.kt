package com.example.countriesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.countriesapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding:FragmentSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentSecondBinding.inflate(inflater, container,false)

        val bundle : SecondFragmentArgs by navArgs()
        var incomingCountry = bundle.country

        binding.tvName.text = incomingCountry.countryName
        binding.tvCapital.text = incomingCountry.countryCapital
        binding.tvCurrency.text = incomingCountry.countryCurrency
        binding.tvRegion.text = incomingCountry.countryRegion
        binding.tvLanguage.text = incomingCountry.countryLanguage

        Glide.with(this)
            .load(incomingCountry.flag)
            .into(binding.imgFlag)


        return binding.root
    }

}