package com.example.inventario


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_add_product.*


class AddProduct : Fragment() {
    private lateinit var viewModel: InventarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_add_product, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            R.id.save -> {
                viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)
                viewModel.addPantes(nombre.text.toString(), codigo.text.toString())
                val home=ProductList()

                val fragmentManager=fragmentManager

                val fragmentTransaction=fragmentManager!!.beginTransaction()
                fragmentTransaction.remove(this)
                fragmentTransaction.replace(R.id.fragment3,home).commit()
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }


}
