package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.myapplication.ui.DataBaseRicordi
import com.example.myapplication.ui.Ricordo
import kotlinx.coroutines.launch


class fragRimuoviRicordo : Fragment(R.layout.fragrimuovi_ricordo_layout) {
    private var uriSelezionato: Uri?=null

    private val pickmedia=registerForActivityResult(ActivityResultContracts.PickVisualMedia()){
            uri -> if(uri!=null){
        val flag = Intent.FLAG_GRANT_READ_URI_PERMISSION
        requireContext().contentResolver.takePersistableUriPermission(uri, flag) //keeps access tu the uri
        uriSelezionato=uri
        val imgricordo=view?.findViewById<ImageView>(R.id.img_ricordo)
        imgricordo?.load(uri) //setting the preview for the image
    }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ricordo = arguments?.getParcelable<Ricordo>("ricordo")
        var txttitolo = view.findViewById<EditText>(R.id.txt_titolo)
        var txtcitta = view.findViewById<EditText>(R.id.txt_citta)
        var imgricordo=view.findViewById<ImageView>(R.id.img_ricordo)
        ricordo?.let { r ->//using this function because txttitolo.text=... would cause an error because of type mismatch
            txttitolo?.setText(r.titolo ?: "") //?:"" means tha if null it will show a blank space instead of an error
    txtcitta?.setText(r.citta?:"")
            if(!r.url.isNullOrEmpty()){ //if it isn't null or empty
                uriSelezionato=Uri.parse(r.url) // parse takes a string and converts it into an uri type variable
                imgricordo?.load(uriSelezionato)
            }
        }
    imgricordo.setOnClickListener {
        pickmedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }
    var btninvio=view.findViewById<Button>(R.id.btninvia)
    btninvio.setOnClickListener {
        if (txttitolo.text.trim().isEmpty()){
            txttitolo.error="Campo Obbligatorio"
            txttitolo.requestFocus()
        }
        if (txtcitta.text.trim().isEmpty()){
            txtcitta.error="Campo Obbligatorio"
            txtcitta.requestFocus()
        }
        if(ricordo!=null){
        val nuovourl=uriSelezionato?.toString()?:ricordo.url
            val nuovoricordo=ricordo.copy(
                titolo = txttitolo?.text.toString(),
                citta = txtcitta?.text.toString(),
                url = nuovourl
            )
            lifecycleScope.launch {
                val db = DataBaseRicordi.getDb(requireContext())
                db.ricordiDao().aggiornaRicordo(nuovoricordo)
                Toast.makeText(requireContext(),"Ricordo Aggiornato", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack() //goes back to the list
            }
    }}
        var btnelimina=view.findViewById<Button>(R.id.btnelimina)
btnelimina.setOnClickListener {
    lifecycleScope.launch {
        if(ricordo!=null) {
            val db = DataBaseRicordi.getDb(requireContext())
            db.ricordiDao().rimuoviRicordo(ricordo)
            Toast.makeText(requireContext(),"Ricordo Eliminato", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }
}
    }
}