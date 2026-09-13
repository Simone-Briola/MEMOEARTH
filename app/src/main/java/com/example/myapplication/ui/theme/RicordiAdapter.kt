package com.example.myapplication.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.R
import com.example.myapplication.ui.Ricordo

class RicordiAdapter(
    private var listaRicordi:List<Ricordo> =emptyList(),
    private val onItemClick:(Ricordo)->Unit={} //callback made to handle clicks on the item
): RecyclerView.Adapter<RicordiAdapter.RicordoViewHolder>()
{ class RicordoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
val txttitolo: TextView=itemView.findViewById<TextView>(R.id.txt_titolo)
    val txtcitta: TextView=itemView.findViewById<TextView>(R.id.txt_citta)
val imgricordo: ImageView=itemView.findViewById<ImageView>(R.id.img_ricordo)
        val btnvisualizza:Button=itemView.findViewById<Button>(R.id.btnvisualizza)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RicordoViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_ricordo, parent, false)
return RicordoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RicordoViewHolder, position: Int) {
val ricordo=listaRicordi[position]
        holder.txttitolo.text=ricordo.titolo
        holder.txtcitta.text=ricordo.citta
        if(!ricordo.url.isNullOrEmpty()){
        holder.imgricordo.load(ricordo.url)
    }
        holder.btnvisualizza.setOnClickListener {
            onItemClick(ricordo)
        }
    }
   override fun getItemCount():Int{
        return listaRicordi.size
    }
    fun updateList(nuovaLista:List<Ricordo>){
        this.listaRicordi=nuovaLista
        notifyDataSetChanged() // notifies the change of list and binds the new one
    }
}