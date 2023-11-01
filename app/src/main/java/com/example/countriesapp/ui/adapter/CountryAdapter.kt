package com.example.countriesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.countriesapp.data.model.Countries
import com.example.countriesapp.databinding.CardViewBinding
import com.example.countriesapp.ui.fragment.FirstFragmentDirections

class CountryAdapter(var mContext : Context, var countryList:List<Countries>) : RecyclerView.Adapter<CountryAdapter.CountrCard>() {

    inner class CountrCard(var view: CardViewBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountrCard {
        val binding = CardViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CountrCard(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountrCard, position: Int) {
        val binding = holder.view
        val country = countryList.get(position)

        binding.tvCard.text = country.countryName
        Glide.with(mContext)
            .load(country.flag) // flag String URL'si
            .into(binding.imageCard)

        binding.cardViewId.setOnClickListener {
            val transition = FirstFragmentDirections.actionFirstFragmentToSecondFragment(country)
            Navigation.findNavController(it).navigate(transition)
        }

    }



}