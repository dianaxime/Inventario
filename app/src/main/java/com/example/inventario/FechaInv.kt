package com.example.inventario


import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inventario.databinding.FragmentFechaInvBinding
import kotlinx.android.synthetic.main.fragment_fecha_inv.*
import models.Adapt


class FechaInv : Fragment() {
    lateinit var  adapt : Adapt
    private lateinit var viewModel: InventarioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)
        val binding = DataBindingUtil.inflate<FragmentFechaInvBinding>(inflater, R.layout.inventario_fragment, container, false)
        adapt = Adapt(viewModel.getmisinv())
        binding.recyclerView.adapter=adapt
        binding.recyclerView.layoutManager= LinearLayoutManager(activity)

        fabfecha.setOnClickListener{
            viewModel.addI()
            var array=viewModel.getmisinv()
            adapt.add(array[array.size-1])
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_fecha_inv, container, false)
    }


}
