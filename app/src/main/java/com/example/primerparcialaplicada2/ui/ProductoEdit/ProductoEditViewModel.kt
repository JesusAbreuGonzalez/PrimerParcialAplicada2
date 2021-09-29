package com.example.primerparcialaplicada2.ui.ProductoEdit

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import androidx.room.Update
import com.example.primerparcialaplicada2.data.ProductoDb
import com.example.primerparcialaplicada2.databinding.ProductoEditFragmentBinding
import com.example.primerparcialaplicada2.models.Producto
import com.example.primerparcialaplicada2.repository.ProductoRepository
import com.example.primerparcialaplicada2.utils.getFloat
import kotlinx.coroutines.launch

class ProductoEditViewModel (application: Application) : ViewModel() {

    private lateinit var binding: ProductoEditFragmentBinding
    private val productoRepository = ProductoRepository(ProductoDb.getInstance(application))

    fun Insert(producto: Producto) = viewModelScope.launch {
        productoRepository.Insert(producto)
    }

    fun Delete(producto: Producto) = viewModelScope.launch {
        productoRepository.Delete(producto)
    }

    fun Update(producto: Producto) = viewModelScope.launch {
        productoRepository.Update(producto)
    }

    fun Find(producto: Producto) = viewModelScope.launch {
        productoRepository.Find(producto.ProductoId)
    }



    //Factory
    class Factory(val app: Application) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom((ProductoEditViewModel::class.java))){
                @Suppress("UNCHECKED_CAST")
                return ProductoEditViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewModel")
        }
    }
}