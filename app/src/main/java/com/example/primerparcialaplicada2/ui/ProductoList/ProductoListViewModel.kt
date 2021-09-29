package com.example.primerparcialaplicada2.ui.ProductoList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.primerparcialaplicada2.data.ProductoDb
import com.example.primerparcialaplicada2.repository.ProductoRepository
import com.example.primerparcialaplicada2.ui.ProductoEdit.ProductoEditViewModel
import kotlinx.coroutines.launch

class ProductoListViewModel(application: Application) : ViewModel() {

    private val productoRepository = ProductoRepository(ProductoDb.getInstance(application))
    val list = productoRepository.Lista()


    //Factory
    class Factory(val app: Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom((ProductoListViewModel::class.java))){
                @Suppress("UNCHECKED_CAST")
                return ProductoListViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewModel")
        }
    }
}