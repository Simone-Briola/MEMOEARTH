package com.example.myapplication

import android.os.Bundle
import androidx.compose.ui.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation


class FragQuiz_domande : Fragment(R.layout.domande_layout) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
val freccia_avanti=view.findViewById<ImageView>(R.id.freccia_avanti)
        freccia_avanti.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.BandiereDaDomande)
        }
        var home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.HomeDaDomande)
        }
        val card_domande=view.findViewById<CardView>(R.id.domande)
        card_domande.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.DifficoltaDaDomande)
        }
        val view_testo_domande=view.findViewById<TextView>(R.id.testo)
val testo_domande=view_testo_domande.text
        val span= SpannableString(testo_domande) //in order to modify the colour of single characters of the string we make it spannable
span.setSpan(
    ForegroundColorSpan(android.graphics.Color.parseColor("#2E7D32")), //color
    3,// the spannable string is treated like an array where che letter A has the index 3
    7, // end
    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
)
view_testo_domande.text=span


    }
    }
