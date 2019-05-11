package com.example.inventario

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.inventario.databinding.InventarioFragmentBinding
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.inventario_fragment.*


class Inventario : Fragment() {

    companion object {
        fun newInstance() = Inventario()
    }

    private lateinit var viewModel: InventarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<InventarioFragmentBinding>(inflater, R.layout.inventario_fragment, container, false)
        productrecycler.layoutManager = LinearLayoutManager(activity)
        fabinv.setOnClickListener {
            val scan= IntentIntegrator(activity)
            scan.initiateScan()
        }

        //return inflater.inflate(R.layout.inventario_fragment, container, false)
        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)
        // TODO: Use the ViewModel
    }



}
