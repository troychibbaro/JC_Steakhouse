package com.example.jcsteakhouse.viewmodels.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jcsteakhouse.data.Product

class HomeViewModel: ViewModel() {
    private var _popularProducts = MutableLiveData<ArrayList<Product>>()
    val popularProducts: LiveData<ArrayList<Product>>
        get() = _popularProducts





    fun setInitialPopularProducts(data: ArrayList<Product>){
        _popularProducts.value = data
    }
}