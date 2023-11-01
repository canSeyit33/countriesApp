package com.example.countriesapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.countriesapp.data.model.Countries
import com.example.countriesapp.service.CountryAPIService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FirstFragmentViewModel : ViewModel() {

    private val _countriesFlow = MutableStateFlow<List<Countries>>(emptyList())
    val countriesFlow = _countriesFlow.asStateFlow()


    private val countryAPIService = CountryAPIService()
    private val disposable = CompositeDisposable()

    init {
        getDataFromApi()
    }

    private fun getDataFromApi(){
        disposable.add(
            countryAPIService.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<Countries>>(){
                    override fun onSuccess(t: List<Countries>) {
                        CoroutineScope(Dispatchers.Main).launch {
                            _countriesFlow.value = t
                        }
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }
}