package com.example.inventario

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inventario.databinding.InventarioFragmentBinding
import com.google.zxing.integration.android.IntentIntegrator
import models.Adapt
import models.AdaptadorInv


class Inventario : Fragment() {

    companion object {
        fun newInstance() = Inventario()
    }

    private lateinit var viewModel: InventarioViewModel
    lateinit var  adapter : AdaptadorInv
    lateinit var  adapt : Adapt
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)
        val binding = DataBindingUtil.inflate<InventarioFragmentBinding>(inflater, R.layout.inventario_fragment, container, false)
        adapt= Adapt(viewModel.getmisinv())
        binding.fabinv.setOnClickListener {
            val scan= IntentIntegrator(activity)
            scan.initiateScan()
        }
        adapter = AdaptadorInv(viewModel.mylist[adapt.numfila].myProductos)
        binding.productrecycler.adapter=adapter
        binding.productrecycler.layoutManager = LinearLayoutManager(activity)
        //return inflater.inflate(R.layout.inventario_fragment, container, false)
        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)
        // TODO: Use the ViewModel
    }



}
