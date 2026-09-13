package com.example.myapplication.ui.theme

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.core.animation.doOnEnd
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import coil.load
import com.example.myapplication.R
import com.example.myapplication.Utente
import com.example.myapplication.ui.DataBaseRicordi
import com.example.myapplication.ui.DataBaseUtenti
import kotlinx.coroutines.launch


class homeFragment : Fragment() {
    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
val immagine_mappa=view.findViewById<CardView>(R.id.immagine_mappa)
        val logouni=view.findViewById<ImageView>(R.id.logo_universita)
        var nome_utente=view.findViewById<TextView>(R.id.nome_utente)
        val icona_utente=view.findViewById<ImageView>(R.id.img_utente)
        val icona_impostazioni=view.findViewById<CardView>(R.id.logo_impostazioni)
        val quiz=view.findViewById<CardView>(R.id.immagine_quiz)
        val ricordi=view.findViewById<CardView>(R.id.logo_ricordi)
        val view_testo_memoearth=view.findViewById<TextView>(R.id.testo_memoearth)
        val testo_memoearth=view_testo_memoearth.text
        val span= SpannableString(testo_memoearth) //in order to modify the color of single characters of the string we make it spannable
span.setSpan(
    ForegroundColorSpan(android.graphics.Color.parseColor("#2E7D32")), //color
4,
    9,
    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
)
        view_testo_memoearth.text=span
        var utente:Utente?=null
lifecycleScope.launch {
    val db= DataBaseUtenti.getDb(requireContext())
    val user= Utente(nome="User", punteggio = 0, quiz_finiti = 0, quiz_corretti = 0, urlFoto = null)
    var utentidb=db.userDao().getUtenti()
if(utentidb==null) {
db.userDao().CreaUtente(user)
    utente=user
}else{
   utente=utentidb
}
    val urlfoto=utente?.urlFoto
    if(!urlfoto.isNullOrEmpty()){
        val uri=Uri.parse(urlfoto)
        icona_utente?.load(uri)
        }
    nome_utente.text=utente.nome
    }

        icona_impostazioni.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.impostazioni_utente)
        }
        quiz.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.QuizDaHome)
            }
        immagine_mappa.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.WbDaHome)
        }


        ricordi.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.RicordiDaHome)
            }

    logouni.setOnClickListener {
        Navigation.findNavController(view).navigate(R.id.RiconoscimentiDaHome)
    }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home, container, false)
    }
    }
