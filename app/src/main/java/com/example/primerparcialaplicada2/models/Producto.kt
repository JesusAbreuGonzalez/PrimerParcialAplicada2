package com.example.primerparcialaplicada2.models

import androidx.room.*

@Entity
data class Producto(
    @PrimaryKey(autoGenerate = true)
    var ProductoId: Long,
    var Descripcion: String,
    var Existencia: Float,
    var Costo: Float,
    var ValorInventario: Float
)