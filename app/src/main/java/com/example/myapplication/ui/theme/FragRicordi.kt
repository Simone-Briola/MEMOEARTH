package com.example.myapplication.ui.theme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.DataBaseRicordi
import com.example.myapplication.ui.Ricordo
import kotlinx.coroutines.launch

class FragRicordi : Fragment(R.layout.fragricordi_layout) {
   private lateinit var recyclerView: RecyclerView
    private lateinit var card_view_vuota: CardView
    private fun carica(){
        lifecycleScope.launch {
            val db= DataBaseRicordi.getDb(requireContext())
            val listaRicordi=db.ricordiDao().getRicordi()
            adapter.updateList(listaRicordi)
            if(listaRicordi.isEmpty()){
                card_view_vuota.visibility=View.VISIBLE
                card_view_vuota.isEnabled=true
                recyclerView.visibility=View.GONE
            }else{
                card_view_vuota.visibility=View.GONE
                card_view_vuota.isEnabled=false
                recyclerView.visibility=View.VISIBLE
            }
        }
    }
    private lateinit var adapter: RicordiAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         recyclerView=view.findViewById<RecyclerView>(R.id.recycler_view)
        card_view_vuota=view.findViewById<CardView>(R.id.card_view_vuota)
        val home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.homeDaRicordi)
        }
        card_view_vuota.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.wbDaRicordi)
        }
        adapter= RicordiAdapter(onItemClick = {ricordoSelezionato->
            val bundle= Bundle().apply{
                putParcelable("ricordo",ricordoSelezionato)
            }
            Navigation.findNavController(view).navigate(R.id.RimuoviRicordo,bundle)
        })
        recyclerView.layoutManager= LinearLayoutManager(requireContext())
        recyclerView.adapter=adapter
        carica()
    }


    override fun onResume() {
        super.onResume()
      carica() //called in on resume for when an item is modified or removed
    }
}