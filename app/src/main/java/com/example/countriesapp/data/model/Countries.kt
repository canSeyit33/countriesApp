package com.example.countriesapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Countries (
    @SerializedName("name")
    val countryName:String,
    @SerializedName("region")
    val countryRegion:String,
    @SerializedName("capital")
    val countryCapital:String,
    @SerializedName("currency")
    val countryCurrency:String,
    @SerializedName("language")
    val countryLanguage:String,
    @SerializedName("flag")
    val flag:String

) : Parcelable{

}