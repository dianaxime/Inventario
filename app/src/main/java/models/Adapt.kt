package models

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.inventario.R

class Adapt (private val items: ArrayList<InventariodeProductos>): RecyclerView.Adapter<Adapt.AdaptViewHolder>() {
    var numfila:Int=0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptViewHolder {
        val contentView = LayoutInflater.from(parent.context).inflate(R.layout.cardfecha, null)
        return AdaptViewHolder(contentView)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(p0: AdaptViewHolder, p1: Int) {
        numfila=p1
        var filaI =InventariodeProductos.getfecha(items[p1])
        p0.fecha.text=filaI
        p0.boton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fechaInv_to_inventario)
        }
    }


    fun eliminar (viewHolder: RecyclerView.ViewHolder) {
        items.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
        notifyDataSetChanged()
    }
    fun add (fila:InventariodeProductos) {
        items.add(fila)
        notifyDataSetChanged()
    }

    fun eliminartodos () {
        items.clear()
        notifyDataSetChanged()
    }
    fun getfila():Int{
        return numfila
    }


    class AdaptViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var boton: ImageButton =itemView.findViewById(R.id.imageButton)
        var fecha: TextView=itemView.findViewById(R.id.textView3)
        override fun onClick(v: View?) {}
    }
}