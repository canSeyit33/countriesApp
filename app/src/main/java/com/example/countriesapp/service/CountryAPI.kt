package com.example.countriesapp.service

import com.example.countriesapp.data.model.Countries
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CountryAPI {

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries() : Single<List<Countries>>
}