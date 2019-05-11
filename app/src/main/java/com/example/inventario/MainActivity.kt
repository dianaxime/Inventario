package com.example.inventario


import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.zxing.integration.android.IntentIntegrator
import models.Adapt
import models.Adaptproduct
import models.Producto

class MainActivity : AppCompatActivity() {
    lateinit var  adapt : Adapt
    lateinit var  adaptp : Adaptproduct
    private lateinit var viewModel: InventarioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)










        val home=Inventario()

        val fragmentManager=supportFragmentManager

        val fragmentTransaction=fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.milayou,home)


        /*val navController = this.findNavController(R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)*/


    }
    override fun onActivityResult(p0: Int,p1: Int,p2: Intent?) {
        if(p1==Activity.RESULT_OK   )  {
            val res = IntentIntegrator.parseActivityResult(p0,p1,p2)
            if(     res!=null){


                if(res.contents==null){
                    Toast.makeText(this,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                }

                else{

                    viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)
                    var adding    = false
                    for(filaI: Producto in viewModel.productosantes){
                        val code = filaI.codigo
                        if(code==res.contents){
                            adding=true
                            viewModel.addP(filaI.codigo, filaI.producto)
                            adaptp.add(filaI)
                        }
                    }
                    if(adding){
                        Toast.makeText(this,"Se ha escaneado correctamente", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this,"Ingrese el codigo antes de escanear", Toast.LENGTH_SHORT).show()
                    }
                }
            } else{
                super.onActivityResult(p0,p1,p2)
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragment)
        return navController.navigateUp()
    }
}
