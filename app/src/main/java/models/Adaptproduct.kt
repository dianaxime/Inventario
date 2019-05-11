package models

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.inventario.R

class Adaptproduct (private val items: ArrayList<Producto>): RecyclerView.Adapter<Adaptproduct.AdaptproductViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptproductViewHolder {
        val contentView = LayoutInflater.from(parent.context).inflate(R.layout.cardfecha, null)
        return AdaptproductViewHolder(contentView)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(p0: AdaptproductViewHolder, p1: Int) {
        p0.prod.text=items[p1].producto
    }


    fun eliminar (viewHolder: RecyclerView.ViewHolder) {
        items.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
        notifyDataSetChanged()
    }
    fun add (fila:Producto) {
        items.add(fila)
        notifyDataSetChanged()
    }

    fun eliminartodos () {
        items.clear()
        notifyDataSetChanged()
    }


    class AdaptproductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var prod: TextView =itemView.findViewById(R.id.textView3)
        override fun onClick(v: View?) {}
    }
}