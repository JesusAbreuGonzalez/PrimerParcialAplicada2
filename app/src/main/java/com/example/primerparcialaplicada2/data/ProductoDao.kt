package com.example.primerparcialaplicada2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.primerparcialaplicada2.models.Producto

@Dao
interface ProductoDao {

    @Insert
    suspend fun Insert(producto: Producto)

    @Update
    suspend fun Update(producto: Producto)

    @Delete
    suspend fun Delete(producto:Producto)

    @Query("select * from Producto where ProductoId = :key")
    suspend fun Find(key:Long) : Producto?

    @Query("select * from Producto order by ProductoId asc")
    fun Lista() : LiveData<List<Producto>>
}