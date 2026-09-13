package com.example.myapplication.ui.theme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.myapplication.R


class FragFineQuiz : Fragment(R.layout.fine_quiz) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rigioca=view.findViewById<Button>(R.id.btnrigioca)
        val indietro=view.findViewById<Button>(R.id.btnindietro)
        val risultato=view.findViewById<TextView>(R.id.risultato)
        val punteggio=view.findViewById<TextView>(R.id.punteggio)
        val giuste=arguments?.getInt("Giuste")
        val gioco=arguments?.getString("Gioco")
        val punti=arguments?.getInt("Punteggio")
        val sbagliate=arguments?.getInt("Sbagliate")
        punteggio.text="Punteggio: $punti"
        risultato.text="Corrette: $giuste, Sbagliate: $sbagliate"
        rigioca.setOnClickListener {
            if (gioco == "Domande") {
                Navigation.findNavController(view).navigate(R.id.RicominciaQuiz)
            }else{
                if(gioco=="Linguaggio"){
                    Navigation.findNavController(view).navigate(R.id.RicominciaQuizLinguaggio)

                }
            }
        }
indietro.setOnClickListener {
    if (gioco == "Domande") {
        Navigation.findNavController(view).navigate(R.id.DomandeDaFineQuiz)
    }else{
        if(gioco=="Linguaggio"){
            Navigation.findNavController(view).navigate(R.id.LinguaggioDaFineQuiz)
        }

    }
}
    }

}