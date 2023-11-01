package com.example.countriesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countriesapp.data.model.Countries
import com.example.countriesapp.databinding.FragmentFirstBinding
import com.example.countriesapp.ui.adapter.CountryAdapter
import com.example.countriesapp.ui.viewModel.FirstFragmentViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding
    private var list : List<Countries> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentFirstBinding.inflate(inflater, container,false)
        binding.rv.layoutManager = LinearLayoutManager(requireContext())


        val viewModel = ViewModelProvider(this).get(FirstFragmentViewModel::class.java)

        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.countriesFlow.collect{
                list = it
                val countryAdapter = CountryAdapter(requireContext(),list)
                binding.rv.adapter = countryAdapter
            }
        }
        return binding.root
    }


}