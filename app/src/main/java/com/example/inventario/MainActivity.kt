package com.example.inventario


import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_menude_opciones.*
import kotlinx.android.synthetic.main.app_bar_menude_opciones.*
import models.Adapt
import models.Adaptproduct
import models.Producto

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (p0.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
                val home=FechaInv()

                val fragmentManager=supportFragmentManager
                //fragmentManager.fragments.clear()
                val fragmentTransaction=fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment3,home).commit()
                //fragmentTransaction.add(R.id.drawer_layout,home)
            }
            R.id.nav_gallery -> {
                val home=ProductList()

                val fragmentManager=supportFragmentManager
                //fragmentManager.fragments.clear()
                val fragmentTransaction=fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment3,home).commit()
                //fragmentTransaction.show(home).commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    lateinit var  adapt : Adapt
    lateinit var  adaptp : Adaptproduct
    private lateinit var viewModel: InventarioViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(InventarioViewModel::class.java)

        setContentView(R.layout.activity_menude_opciones)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)








        /*val home=Inventario()

        val fragmentManager=supportFragmentManager

        val fragmentTransaction=fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.milayou,home)*/


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

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menude_opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
