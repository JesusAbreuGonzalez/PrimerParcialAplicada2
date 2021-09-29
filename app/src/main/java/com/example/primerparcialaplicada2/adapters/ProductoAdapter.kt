package com.example.primerparcialaplicada2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.primerparcialaplicada2.databinding.ProductoRowBinding
import com.example.primerparcialaplicada2.models.Producto

class ProductoAdapter() : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {
        private var ProductosList = emptyList<Producto>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
            val binding = ProductoRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

            return ProductoViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
            holder.bind(ProductosList[position])
        }

        override fun getItemCount(): Int {
            return ProductosList.size
        }

        fun submitList(list: List<Producto>)
        {
            ProductosList = list
            notifyDataSetChanged()
        }

        inner class ProductoViewHolder(private val binding: ProductoRowBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(item: Producto) {
                binding.productoIdTextView.text = item.ProductoId.toString()
                binding.descripcionTextView.text = item.Descripcion
                binding.existenciaTextView.text = item.Existencia.toString()
                binding.costoTextView.text = item.Costo.toString()
                binding.valorInventarioTextView.text = item.ValorInventario.toString()
            }
        }

}