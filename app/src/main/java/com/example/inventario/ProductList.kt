package com.example.inventario


import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.inventario.databinding.FragmentProductListBinding
import kotlinx.android.synthetic.main.fragment_product_list.*
import models.Adapt
import models.Adaptproduct


class ProductList : Fragment() {
    lateinit var  adaptp : Adaptproduct
    private lateinit var viewModel: InventarioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentProductListBinding>(inflater, R.layout.fragment_product_list, container, false)
        viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)

        adaptp = Adaptproduct(viewModel.getproductos())
        recyclerproduct.adapter=adaptp

        recyclerproduct.layoutManager= LinearLayoutManager(activity)

        fabprod.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_productList_to_addProduct)
        }


        //return inflater.inflate(R.layout.fragment_product_list, container, false)
        return binding.root
    }


}
