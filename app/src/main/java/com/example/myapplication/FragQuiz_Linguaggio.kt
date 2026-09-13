package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation


class FragQuiz_Linguaggio : Fragment(R.layout.fragquiz_linguaggio_layout) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.HomeDaLinguaggio)
        }
        val freccia_dietro=view.findViewById<ImageView>(R.id.freccia_indietro)
        freccia_dietro.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.QuizDaLinguaggio)
        }
        val card_linguaggio=view.findViewById<CardView>(R.id.indovina_lingua)
        card_linguaggio.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.DifficoltaDaLinguaggio)

        }
    }
 }

