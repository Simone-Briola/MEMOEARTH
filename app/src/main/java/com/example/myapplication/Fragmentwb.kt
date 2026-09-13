package com.example.myapplication
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
class Fragmentwb: Fragment(R.layout.fragwb_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        val btnricordo=view.findViewById<ImageView>(R.id.icona_ricordo)
        val card=view.findViewById<CardView>(R.id.card)
        var tendina_aperta=false
        val home=view.findViewById<ImageView>(R.id.icona_home)
        val btntendina=view.findViewById<Button>(R.id.btntendina)
        btntendina.bringToFront() // brings the button in front of the webview

        card.post{
            card.translationY=-card.height.toFloat()
        }
        home.isEnabled=false
        var nome:String?=null
        btnricordo.isEnabled=false
        var wb=view.findViewById<WebView>(R.id.Wbmondo)
        var stato_selezionato:String?=null
        wb.settings.javaScriptEnabled = true //enables js modifications
        wb.settings.domStorageEnabled = true
        //makes it so that android can be recalled by javascript
        wb.addJavascriptInterface(JS{nomeStato:String?->stato_selezionato=nomeStato //recalling the js interface and the selected state element
                    activity?.runOnUiThread {
                        nome=nomeStato
                        if (tendina_aperta){
                            btnricordo.alpha=1f
                            btnricordo.isEnabled=true
                        }
                    }//thread that makes the button visible and clickable
                                    }, "Android")
        wb.webViewClient = WebViewClient()
        // Allows zooming in the web view
        wb.settings.setSupportZoom(true)
        wb.settings.builtInZoomControls = true
        wb.settings.displayZoomControls = false
        wb.settings.useWideViewPort = true
        wb.settings.loadWithOverviewMode = true
        wb.loadUrl("file:///android_asset/mondo.html")
        btntendina.setOnClickListener {
               if(!tendina_aperta){
                   val offset=(24*resources.displayMetrics.density) // calculating the offset to make the button not detached to the card because of the margintop
card.animate().translationY(0f).setDuration(300).start()
                   btntendina.animate().translationY(card.height.toFloat()-offset).setDuration(300).start()
                   btnricordo.isEnabled=stato_selezionato!=null //is enabled only when a state is clicked
                   btnricordo.alpha=if(stato_selezionato!=null)1f else 0.3f
              home.isEnabled=true
              tendina_aperta=true
        }else{
                   card.animate().translationY(-card.height.toFloat()).setDuration(300).start()
                   btntendina.animate().translationY(0f).setDuration(300).start()
              home.isEnabled=false
                   btnricordo.isEnabled=false
              tendina_aperta=false
          }
        }
btnricordo.setOnClickListener {
    val stato=stato_selezionato?:nome
if(stato!=null){
    val bundle=Bundle().apply{
        putString("Nome_Stato", stato)
    }
    Navigation.findNavController(view).navigate(R.id.Aggiunta_ricordo,bundle)
}
}
    home.setOnClickListener {
        Navigation.findNavController(view).navigate(R.id.HomeDaWb)
    }

    }
}


