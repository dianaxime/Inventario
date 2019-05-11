package com.example.inventario


import android.arch.lifecycle.ViewModel
import models.Fila
import models.InventariodeProductos
import models.Producto
import java.util.*
import kotlin.collections.ArrayList

class InventarioViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var filas= arrayListOf<Fila>(Fila(Producto("huevos", "14")),
        Fila(Producto("frijol","18")))
    var mylist= arrayListOf<InventariodeProductos>(
        InventariodeProductos("10/05/2019",filas ))
    var productos= arrayListOf<Producto>(
        Producto("papas", "12"),
        Producto("galletas","15")
    )
    var productosantes=arrayListOf<Producto>(
        Producto("papas", "12"),
        Producto("galletas","15")
    )
    fun addP(code:String, nombre:String){
        val producto=Producto(code, nombre)
        productos.add(producto)
    }
    fun addPantes(code:String, nombre:String){
        val producto=Producto(code, nombre)
        productosantes.add(producto)
    }
    fun addI(){
        var n=productos.size
        var lista=ArrayList<Fila>()
        var i = 0
        while (i < n)
        {
            val fila = Fila(productos[i])
            i++
            lista.add(fila)
        }
        val c=Calendar.getInstance()
        val fecha= c.time.toString()
        val inv=InventariodeProductos(fecha, lista)
        mylist.add(inv)
    }

    fun getmisinv():ArrayList<InventariodeProductos>{
        return  mylist
    }

    fun getproductos():ArrayList<Producto>{
        return productos
    }


}
