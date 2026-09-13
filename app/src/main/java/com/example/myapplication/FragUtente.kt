package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import coil.load
import com.example.myapplication.ui.DataBaseUtenti
import kotlinx.coroutines.launch


class FragUtente : Fragment(R.layout.frag_utente_layout) {
    private var uriSelezionato: Uri?=null

    private val pickmedia=registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ //necessary for changing the user image
            uri -> if(uri!=null){
        val flag = Intent.FLAG_GRANT_READ_URI_PERMISSION
        requireContext().contentResolver.takePersistableUriPermission(uri, flag) //keeps access tu the uri
        uriSelezionato=uri
        val imgutente=view?.findViewById<ImageView>(R.id.img_utente)
        imgutente?.load(uri) //setting the preview for the image
    }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    var utente:Utente?=null
    var txt_punteggio=view.findViewById<TextView>(R.id.txt_punteggio)
        var txt_percentuale=view.findViewById<TextView>(R.id.txt_percentuale)
        var txt_quiz=view.findViewById<TextView>(R.id.txt_quiz)
        var txt_utente=view.findViewById<EditText>(R.id.txt_utente)
        var btninvio=view.findViewById<Button>(R.id.btninvia)
        val x_rossa=view.findViewById<ImageView>(R.id.x_rossa)
        var btnindietro=view.findViewById<Button>(R.id.btnindietro)
        var img_utente=view.findViewById<ImageView>(R.id.img_utente)
        lifecycleScope.launch {
            val db = DataBaseUtenti.getDb(requireContext())
            utente = db.userDao().getUtenti()
           txt_utente.setText(utente?.nome)
            if(!utente?.urlFoto.isNullOrEmpty()){
            img_utente?.load(Uri.parse(utente?.urlFoto))
            }else{
                img_utente?.setImageResource(R.drawable.icona_utente)
            }
            txt_punteggio.text = "Punteggio Totale:${utente?.punteggio ?: 0}"
            var percentuale_corretti: Float = 0f
            val quiz_corretti: Int = utente?.quiz_corretti ?: 0
            val quiz: Int = utente?.quiz_finiti ?: 0
            if (quiz != 0) {
                percentuale_corretti = (quiz_corretti.toFloat() * 100f).div(quiz.toFloat())
            } else {
                percentuale_corretti = 0f
            }
            txt_percentuale.text = String.format("Percentuale Corretti:%.1f%%", percentuale_corretti)
            txt_quiz.text = "Quiz_Totali: $quiz"
        }
            btnindietro.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        btninvio.setOnClickListener {
            val testo=txt_utente.text
            lifecycleScope.launch{
                if(!testo.isNullOrEmpty()){
                    utente?.nome=testo.toString()}else{
                        txt_utente.error="Campo Obbligatorio"
                    txt_utente.requestFocus()
                    }
                if(uriSelezionato!=null){
                    utente?.urlFoto=uriSelezionato.toString()
                }
                val db= DataBaseUtenti.getDb(requireContext())
                utente?.let { db.userDao().AggiornaUtente(it)}
                Toast.makeText(requireContext(),"Utente Aggiornato", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).popBackStack()
            }
        }
        img_utente.setOnClickListener {
            pickmedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
        x_rossa.setOnClickListener {
            lifecycleScope.launch {
                val db= DataBaseUtenti.getDb(requireContext())
                uriSelezionato=null
                utente?.urlFoto=null
                utente?.let { db.userDao().AggiornaUtente(it) }
                img_utente?.setImageResource(R.drawable.icona_utente)
            }
        }
    }
    }






