package models

import android.app.Application

class ListadeInventarios:Application() {
    companion object {
        val misinv = ArrayList<InventariodeProductos>()

        fun addInv(new: InventariodeProductos) {
            misinv.add(new)
        }

        fun deleteInv(ex: InventariodeProductos) {
            misinv.remove(ex)
        }
        fun deleteall(){
            misinv.clear()
        }

        fun getInv(): ArrayList<InventariodeProductos> {
            return misinv
        }

    }
}