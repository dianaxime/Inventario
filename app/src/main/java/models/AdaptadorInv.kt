package models

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.inventario.R


class AdaptadorInv (private val items: ArrayList<Fila>): RecyclerView.Adapter<AdaptadorInv.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val contentView =LayoutInflater.from(parent.context).inflate(R.layout.card, null)
        return ViewHolder(contentView)
    }


    override fun getItemCount(): Int {
        return items.size
    }




    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val filaI =items[p1]
        p0.modproduct.text=filaI.producto.producto
        p0.modcant.text=filaI.getCantidad().toString()
        p0.agregar.setOnClickListener{
            var num=filaI.getCantidad() + 1
            filaI.setCantidad(num)
            p0.modcant.text=filaI.getCantidad().toString()
        }
        p0.quitar.setOnClickListener{
            var num =filaI.getCantidad() - 1
            if (num>=0) filaI.setCantidad(num)
            else {
                num=0
                filaI.setCantidad(num)
            }
            p0.modcant.text=filaI.getCantidad().toString()
        }
//        notifyDataSetChanged()
    }


    fun eliminar (viewHolder: RecyclerView.ViewHolder) {
        items.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
        notifyDataSetChanged()
    }
    fun add (fila:Fila) {
        items.add(fila)
        notifyDataSetChanged()
    }

    fun eliminartodos () {
        items.clear()
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var modproduct: TextView =itemView.findViewById(R.id.productview)
        var modcant: TextView =itemView.findViewById(R.id.cantview)
        var agregar: Button =itemView.findViewById(R.id.sumar)
        var quitar: Button =itemView.findViewById(R.id.restar)




        override fun onClick(v: View?) {}
    }
}