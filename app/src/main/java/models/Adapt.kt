package models

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.inventario.R

class Adapt (private val items: ArrayList<InventariodeProductos>): RecyclerView.Adapter<Adapt.AdaptViewHolder>() {
    lateinit var  adapter : AdaptadorInv
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptViewHolder {
        val contentView = LayoutInflater.from(parent.context).inflate(R.layout.cardfecha, null)
        return AdaptViewHolder(contentView)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(p0: AdaptViewHolder, p1: Int) {
        var filaI =items[p1].myProductos
        p0.boton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fechaInv_to_inventario)

            adapter = AdaptadorInv(filaI)
            p0.recycler.adapter=adapter
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


    class AdaptViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var boton: Button =itemView.findViewById(R.id.imageButton)
        var recycler: RecyclerView =itemView.findViewById(R.id.productrecycler)
        override fun onClick(v: View?) {}
    }
}