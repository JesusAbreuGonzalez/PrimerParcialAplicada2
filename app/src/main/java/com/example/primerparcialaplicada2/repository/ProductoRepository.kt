package com.example.primerparcialaplicada2.repository

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.PrimaryKey
import androidx.room.Update
import com.example.primerparcialaplicada2.data.ProductoDb
import com.example.primerparcialaplicada2.models.Producto

class ProductoRepository(private val database: ProductoDb) {
    suspend fun Insert(producto: Producto){
        database.productoDao.Insert(producto)
    }

    suspend fun Delete(producto: Producto){
        database.productoDao.Delete(producto)
    }

    suspend fun Update(producto: Producto){
        database.productoDao.Update(producto)
    }

    suspend fun Find(ProductoId: Long){
        database.productoDao.Find(ProductoId)
    }

    fun Lista(): LiveData<List<Producto>>{
        return database.productoDao.Lista()
    }
}