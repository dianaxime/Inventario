package models

import android.app.Application


class InventariodeProductos(val fecha:String,
                            val myProductos: ArrayList<Fila>):Application(){

    companion object {
        fun getProducts(inventariodeProductos: InventariodeProductos):ArrayList<Fila>{
            return inventariodeProductos.myProductos
        }

        fun getfecha(inventariodeProductos: InventariodeProductos): String {
            return inventariodeProductos.fecha
        }
    }
}