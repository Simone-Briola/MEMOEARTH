package com.example.myapplication.ui.theme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.ui.DataBaseRicordi
import com.example.myapplication.ui.Ricordo
import kotlinx.coroutines.launch

class FragAggiuntaRicordo : Fragment(R.layout.aggiunta_ricordo_layout) {
   private var UriSelezionato: Uri?=null

   private val pickmedia=registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
            uri -> if(uri!=null){
       val flag = Intent.FLAG_GRANT_READ_URI_PERMISSION
       requireContext().contentResolver.takePersistableUriPermission(uri, flag) //keeps access tu the uri
        UriSelezionato=uri
       val aggiungi_foto=view?.findViewById<ImageView>(R.id.aggiungi_foto)
       aggiungi_foto?.setImageURI(uri) //setting the preview for the image
    }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val aggiungi_foto=view.findViewById<ImageView>(R.id.aggiungi_foto)
        aggiungi_foto.setOnClickListener {
            pickmedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
var NomeStato=arguments?.getString("Nome_Stato")?:"Stato Non Selezionato"
        val view_titolo=view.findViewById<EditText>(R.id.testo_titolo)
        val ricordoIn=view.findViewById<TextView>(R.id.ricordo_in)
        val home=view.findViewById<ImageView>(R.id.icona_home)
        val testo_citta= view.findViewById<EditText>(R.id.testo_citta)
        ricordoIn.text="Ricordo in: $NomeStato"
         val btninvio=view.findViewById<Button>(R.id.btninvia)

        home.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        btninvio.setOnClickListener {
            val testo_titolo= view_titolo.text.toString().trim() //trim=method that removes spaces
            val Citta=testo_citta.text.toString()
            val Citta_senza_spazi=testo_citta.text.toString().trim()
            if(Citta_senza_spazi.isEmpty()){
                testo_citta.error="Campo Obbligatorio"
                testo_citta.requestFocus()
            }else{
                val view_titolo_senza_spazi=view_titolo.text.trim()
if(view_titolo_senza_spazi.isEmpty()){
    view_titolo.error="Campo Obbligatorio"
    view_titolo.requestFocus()
}else{
    val UriFoto=UriSelezionato?.toString()
    val nuovoRicordo = Ricordo(nomeStato = NomeStato, citta= Citta, titolo = testo_titolo, url = UriFoto)
    lifecycleScope.launch {
        val db = DataBaseRicordi.getDb(requireContext())
        db.ricordiDao().inserisciRicordo(nuovoRicordo)
        Toast.makeText(requireContext(),"Ricordo Aggiunto", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(view).popBackStack()
    }
}
            }
        }
    }
}