package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import io.github.sceneview.SceneView
import io.github.sceneview.node.ModelNode
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation

class FragQuiz : Fragment(R.layout.fragquiz_layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val freccia_indietro=view.findViewById<ImageView>(R.id.freccia_indietro)
        freccia_indietro.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.DomandeDaBandiere)
        }

        val freccia_avanti=view.findViewById<ImageView>(R.id.freccia_avanti)
        freccia_avanti.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.LinguaggioDaBandiere)
        }
        var home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.HomeDaQuiz)
        }
        val view_testo_bandiere=view.findViewById<TextView>(R.id.testo)
        val testo_bandiere=view_testo_bandiere.text
        val span= SpannableString(testo_bandiere) //in order to modify the colour of single characters of the string we make it spannable
        span.setSpan(
            ForegroundColorSpan(Color.parseColor("#2E7D32")), //color
            0,// the spannable string is treated like an array where che letter A has the index 0
            8, // end
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        view_testo_bandiere.text=span
         val card_bandiere=view.findViewById<CardView>(R.id.indovina_bandiera)
        card_bandiere.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.DifficoltaDaBandiere)

        }
    }
}



