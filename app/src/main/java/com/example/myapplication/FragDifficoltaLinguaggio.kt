package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation


class FragDifficoltaLinguaggio : Fragment(R.layout.fragdifficolta_layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnfacile=view.findViewById<Button>(R.id.btnfacile)
        btnfacile.setOnClickListener {
            val bundle= Bundle().apply {
                putChar("livello_difficolta", 'f')
            }
            Navigation.findNavController(view).navigate(R.id.AvviaQuizLinguaggio,bundle)
        }
        val btnmedio=view.findViewById<Button>(R.id.btnmedio)
        btnmedio.setOnClickListener {
            val bundle= Bundle().apply {
                putChar("livello_difficolta", 'm')
            }
            Navigation.findNavController(view).navigate(R.id.AvviaQuizLinguaggio,bundle)
        }
        val btndifficile=view.findViewById<Button>(R.id.btndifficile)
        btndifficile.setOnClickListener {
            val bundle= Bundle().apply {
                putChar("livello_difficolta", 'd')
            }
            Navigation.findNavController(view).navigate(R.id.AvviaQuizLinguaggio,bundle)
        }
        var home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

}