package com.example.primerparcialaplicada2.ui.ProductoList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.primerparcialaplicada2.R
import com.example.primerparcialaplicada2.adapters.ProductoAdapter
import com.example.primerparcialaplicada2.databinding.ProductoListFragmentBinding

class ProductoListFragment : Fragment() {

    companion object {
        fun newInstance() = ProductoListFragment()
    }

    private var _binding: ProductoListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ProductoListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ProductoListFragmentBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, ProductoListViewModel.Factory(requireActivity().application))
                .get(ProductoListViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listaRecyclerView.adapter = ProductoAdapter()
        val adapter = binding.listaRecyclerView.adapter as ProductoAdapter

        viewModel.list.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
