package com.example.myapplication.ui.theme

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.myapplication.Immagine
import com.example.myapplication.R
import coil.load
import com.example.myapplication.ui.DataBaseUtenti
import kotlinx.coroutines.launch

class FragGiocoBandiera : Fragment(R.layout.fraggioco_bandiera_layout) {
    //THIS PART WAS MADE WITH AI
    val bandiereFacili = listOf(
        Immagine("https://flagcdn.com/w320/it.png", 3, listOf("Francia", "Spagna", "Italia", "Messico")),
        Immagine("https://flagcdn.com/w320/fr.png", 1, listOf("Francia", "Paesi Bassi", "Russia", "Belgio")),
        Immagine("https://flagcdn.com/w320/es.png", 2, listOf("Portogallo", "Spagna", "Italia", "Germania")),
        Immagine("https://flagcdn.com/w320/de.png", 4, listOf("Belgio", "Austria", "Paesi Bassi", "Germania")),
        Immagine("https://flagcdn.com/w320/gb.png", 2, listOf("Stati Uniti", "Regno Unito", "Australia", "Nuova Zelanda")),
        Immagine("https://flagcdn.com/w320/us.png", 1, listOf("Stati Uniti", "Canada", "Regno Unito", "Liberia")),
        Immagine("https://flagcdn.com/w320/jp.png", 3, listOf("Cina", "Corea del Sud", "Giappone", "Vietnam")),
        Immagine("https://flagcdn.com/w320/cn.png", 4, listOf("Vietnam", "Giappone", "Corea del Nord", "Cina")),
        Immagine("https://flagcdn.com/w320/br.png", 2, listOf("Argentina", "Brasile", "Colombia", "Portogallo")),
        Immagine("https://flagcdn.com/w320/ar.png", 1, listOf("Argentina", "Uruguay", "Cile", "Grecia")),
        Immagine("https://flagcdn.com/w320/ca.png", 3, listOf("Stati Uniti", "Svizzera", "Canada", "Austria")),
        Immagine("https://flagcdn.com/w320/ru.png", 4, listOf("Slovacchia", "Serbia", "Slovenia", "Russia")),
        Immagine("https://flagcdn.com/w320/gr.png", 2, listOf("Finlandia", "Grecia", "Cipro", "Uruguay")),
        Immagine("https://flagcdn.com/w320/pt.png", 1, listOf("Portogallo", "Spagna", "Brasile", "Messico")),
        Immagine("https://flagcdn.com/w320/ch.png", 3, listOf("Austria", "Danimarca", "Svizzera", "Turchia")),
        Immagine("https://flagcdn.com/w320/be.png", 2, listOf("Germania", "Belgio", "Paesi Bassi", "Romania")),
        Immagine("https://flagcdn.com/w320/nl.png", 4, listOf("Francia", "Lussemburgo", "Russia", "Paesi Bassi")),
        Immagine("https://flagcdn.com/w320/se.png", 1, listOf("Svezia", "Finlandia", "Ucraina", "Norvegia")),
        Immagine("https://flagcdn.com/w320/no.png", 3, listOf("Islanda", "Danimarca", "Norvegia", "Svezia")),
        Immagine("https://flagcdn.com/w320/fi.png", 2, listOf("Grecia", "Finlandia", "Svezia", "Estonia")),
        Immagine("https://flagcdn.com/w320/dk.png", 4, listOf("Svizzera", "Norvegia", "Islanda", "Danimarca")),
        Immagine("https://flagcdn.com/w320/at.png", 1, listOf("Austria", "Lettonia", "Polonia", "Monaco")),
        Immagine("https://flagcdn.com/w320/pl.png", 3, listOf("Indonesia", "Monaco", "Polonia", "Singapore")),
        Immagine("https://flagcdn.com/w320/ie.png", 2, listOf("Costa d'Avorio", "Irlanda", "Italia", "India")),
        Immagine("https://flagcdn.com/w320/eg.png", 4, listOf("Siria", "Yemen", "Iraq", "Egitto")),
        Immagine("https://flagcdn.com/w320/mx.png", 1, listOf("Messico", "Italia", "Ungheria", "Perù")),
        Immagine("https://flagcdn.com/w320/in.png", 3, listOf("Niger", "Irlanda", "India", "Pakistan")),
        Immagine("https://flagcdn.com/w320/kr.png", 2, listOf("Giappone", "Corea del Sud", "Cina", "Taiwan")),
        Immagine("https://flagcdn.com/w320/tr.png", 4, listOf("Tunisia", "Pakistan", "Algeria", "Turchia")),
        Immagine("https://flagcdn.com/w320/au.png", 1, listOf("Australia", "Nuova Zelanda", "Regno Unito", "Fiji")),
        Immagine("https://flagcdn.com/w320/za.png", 3, listOf("Giamaica", "Zimbabwe", "Sudafrica", "Kenya")),
        Immagine("https://flagcdn.com/w320/cu.png", 2, listOf("Porto Rico", "Cuba", "Cile", "Repubblica Dominicana")),
        Immagine("https://flagcdn.com/w320/ua.png", 4, listOf("Svezia", "Polonia", "Romania", "Ucraina")),
        Immagine("https://flagcdn.com/w320/jm.png", 1, listOf("Giamaica", "Sudafrica", "Nigeria", "Bahamas")),
        Immagine("https://flagcdn.com/w320/il.png", 3, listOf("Grecia", "Finlandia", "Israele", "Argentina")),
        Immagine("https://flagcdn.com/w320/cl.png", 2, listOf("Texas", "Cile", "Cuba", "Repubblica Ceca")),
        Immagine("https://flagcdn.com/w320/cz.png", 4, listOf("Slovacchia", "Filippine", "Polonia", "Repubblica Ceca")),
        Immagine("https://flagcdn.com/w320/is.png", 1, listOf("Islanda", "Norvegia", "Finlandia", "Regno Unito")),
        Immagine("https://flagcdn.com/w320/lu.png", 3, listOf("Paesi Bassi", "Francia", "Lussemburgo", "Paraguay")),
        Immagine("https://flagcdn.com/w320/pe.png", 2, listOf("Austria", "Perù", "Polonia", "Canada")),
        Immagine("https://flagcdn.com/w320/uy.png", 4, listOf("Argentina", "Grecia", "Stati Uniti", "Uruguay")),
        Immagine("https://flagcdn.com/w320/co.png", 1, listOf("Colombia", "Ecuador", "Venezuela", "Romania")),
        Immagine("https://flagcdn.com/w320/ro.png", 3, listOf("Ciad", "Andorra", "Romania", "Moldavia")),
        Immagine("https://flagcdn.com/w320/hu.png", 2, listOf("Italia", "Ungheria", "Bulgaria", "Iran")),
        Immagine("https://flagcdn.com/w320/ma.png", 4, listOf("Vietnam", "Turchia", "Tunisia", "Marocco"))
    )
    val bandiereMedie = listOf(
        Immagine("https://flagcdn.com/w320/nz.png", 3, listOf("Australia", "Regno Unito", "Nuova Zelanda", "Tuvalu")),
        Immagine("https://flagcdn.com/w320/ci.png", 1, listOf("Costa d'Avorio", "Irlanda", "India", "Niger")),
        Immagine("https://flagcdn.com/w320/ec.png", 2, listOf("Colombia", "Ecuador", "Venezuela", "Bolivia")),
        Immagine("https://flagcdn.com/w320/ve.png", 4, listOf("Colombia", "Ecuador", "Romania", "Venezuela")),
        Immagine("https://flagcdn.com/w320/id.png", 2, listOf("Polonia", "Indonesia", "Monaco", "Singapore")),
        Immagine("https://flagcdn.com/w320/mc.png", 1, listOf("Monaco", "Indonesia", "Polonia", "Singapore")),
        Immagine("https://flagcdn.com/w320/sg.png", 3, listOf("Indonesia", "Polonia", "Singapore", "Turchia")),
        Immagine("https://flagcdn.com/w320/th.png", 4, listOf("Costa Rica", "Corea del Nord", "Paesi Bassi", "Thailandia")),
        Immagine("https://flagcdn.com/w320/cr.png", 2, listOf("Thailandia", "Costa Rica", "Corea del Nord", "Paraguay")),
        Immagine("https://flagcdn.com/w320/vn.png", 1, listOf("Vietnam", "Cina", "Marocco", "Somalia")),
        Immagine("https://flagcdn.com/w320/ng.png", 3, listOf("Pakistan", "Irlanda", "Nigeria", "Niger")),
        Immagine("https://flagcdn.com/w320/ne.png", 4, listOf("India", "Irlanda", "Nigeria", "Niger")),
        Immagine("https://flagcdn.com/w320/sk.png", 2, listOf("Slovenia", "Slovacchia", "Russia", "Repubblica Ceca")),
        Immagine("https://flagcdn.com/w320/si.png", 1, listOf("Slovenia", "Slovacchia", "Russia", "Croazia")),
        Immagine("https://flagcdn.com/w320/hr.png", 3, listOf("Serbia", "Slovacchia", "Croazia", "Paraguay")),
        Immagine("https://flagcdn.com/w320/rs.png", 4, listOf("Croazia", "Slovenia", "Slovacchia", "Serbia")),
        Immagine("https://flagcdn.com/w320/bg.png", 2, listOf("Ungheria", "Bulgaria", "Italia", "Iran")),
        Immagine("https://flagcdn.com/w320/ke.png", 1, listOf("Kenya", "SudSudan", "Malawi", "Zambia")),
        Immagine("https://flagcdn.com/w320/ph.png", 3, listOf("Cile", "Repubblica Ceca", "Filippine", "Sint Maarten")),
        Immagine("https://flagcdn.com/w320/my.png", 4, listOf("Stati Uniti", "Liberia", "Uruguay", "Malesia")),
        Immagine("https://flagcdn.com/w320/dz.png", 2, listOf("Tunisia", "Algeria", "Pakistan", "Turchia")),
        Immagine("https://flagcdn.com/w320/tn.png", 1, listOf("Tunisia", "Turchia", "Algeria", "Marocco")),
        Immagine("https://flagcdn.com/w320/ee.png", 3, listOf("Finlandia", "Lettonia", "Estonia", "Lituania")),
        Immagine("https://flagcdn.com/w320/lv.png", 4, listOf("Austria", "Polonia", "Qatar", "Lettonia")),
        Immagine("https://flagcdn.com/w320/lt.png", 2, listOf("Estonia", "Lituania", "Birmania", "Bolivia")),
        Immagine("https://flagcdn.com/w320/py.png", 1, listOf("Paraguay", "Paesi Bassi", "Francia", "Croazia")),
        Immagine("https://flagcdn.com/w320/bo.png", 3, listOf("Ghana", "Lituania", "Bolivia", "Etiopia")),
        Immagine("https://flagcdn.com/w320/gh.png", 4, listOf("Bolivia", "Mali", "Camerun", "Ghana")),
        Immagine("https://flagcdn.com/w320/cm.png", 2, listOf("Mali", "Camerun", "Senegal", "Ghana")),
        Immagine("https://flagcdn.com/w320/sn.png", 1, listOf("Senegal", "Camerun", "Mali", "Guinea")),
        Immagine("https://flagcdn.com/w320/ml.png", 3, listOf("Guinea", "Senegal", "Mali", "Camerun")),
        Immagine("https://flagcdn.com/w320/gn.png", 4, listOf("Mali", "Ghana", "Romania", "Guinea")),
        Immagine("https://flagcdn.com/w320/pk.png", 2, listOf("Turchia", "Pakistan", "Algeria", "Azerbaigian")),
        Immagine("https://flagcdn.com/w320/bd.png", 1, listOf("Bangladesh", "Giappone", "Palau", "Maldive")),
        Immagine("https://flagcdn.com/w320/lk.png", 3, listOf("India", "Nepal", "Sri Lanka", "Bhutan")),
        Immagine("https://flagcdn.com/w320/np.png", 4, listOf("Tibet", "Bhutan", "Sri Lanka", "Nepal")),
        Immagine("https://flagcdn.com/w320/qa.png", 2, listOf("Bahrein", "Qatar", "Lettonia", "Oman")),
        Immagine("https://flagcdn.com/w320/bh.png", 1, listOf("Bahrein", "Qatar", "Malta", "Singapore")),
        Immagine("https://flagcdn.com/w320/jo.png", 3, listOf("Palestina", "Emirati Arabi", "Giordania", "Sudan")),
        Immagine("https://flagcdn.com/w320/ae.png", 4, listOf("Giordania", "Kuwait", "Palestina", "Emirati Arabi Uniti")),
        Immagine("https://flagcdn.com/w320/kw.png", 2, listOf("Giordania", "Kuwait", "Sudan", "Emirati Arabi")),
        Immagine("https://flagcdn.com/w320/pa.png", 1, listOf("Panama", "Repubblica Dominicana", "Porto Rico", "Cuba")),
        Immagine("https://flagcdn.com/w320/gt.png", 3, listOf("Honduras", "Nicaragua", "Guatemala", "El Salvador")),
        Immagine("https://flagcdn.com/w320/hn.png", 2, listOf("El Salvador", "Honduras", "Nicaragua", "Guatemala")),
        Immagine("https://flagcdn.com/w320/sv.png", 4, listOf("Nicaragua", "Guatemala", "Honduras", "El Salvador"))
    )
    val bandiereDifficili = listOf(
        Immagine("https://flagcdn.com/w320/td.png", 3, listOf("Romania", "Andorra", "Ciad", "Moldavia")),
        Immagine("https://flagcdn.com/w320/ad.png", 1, listOf("Andorra", "Moldavia", "Ciad", "Romania")),
        Immagine("https://flagcdn.com/w320/md.png", 2, listOf("Andorra", "Moldavia", "Romania", "Ciad")),
        Immagine("https://flagcdn.com/w320/li.png", 4, listOf("Haiti", "San Marino", "Sint Maarten", "Liechtenstein")),
        Immagine("https://flagcdn.com/w320/ht.png", 2, listOf("Liechtenstein", "Haiti", "Costa d'Avorio", "Fiji")),
        Immagine("https://flagcdn.com/w320/sm.png", 1, listOf("San Marino", "Malta", "Liechtenstein", "Gibilterra")),
        Immagine("https://flagcdn.com/w320/st.png", 3, listOf("Capo Verde", "Guinea-Bissau", "São Tomé e Príncipe", "Equatore")),
        Immagine("https://flagcdn.com/w320/gw.png", 4, listOf("Ghana", "Benin", "Capo Verde", "Guinea-Bissau")),
        Immagine("https://flagcdn.com/w320/cv.png", 2, listOf("Unione Europea", "Capo Verde", "Samoa", "Tuvalu")),
        Immagine("https://flagcdn.com/w320/km.png", 1, listOf("Comore", "Gibuti", "Eritrea", "Seychelles")),
        Immagine("https://flagcdn.com/w320/dj.png", 3, listOf("Somalia", "Eritrea", "Gibuti", "Sudan")),
        Immagine("https://flagcdn.com/w320/er.png", 4, listOf("Etiopia", "Gibuti", "Sudan", "Eritrea")),
        Immagine("https://flagcdn.com/w320/sz.png", 2, listOf("Lesotho", "Eswatini (Swaziland)", "Botswana", "Rwanda")),
        Immagine("https://flagcdn.com/w320/ls.png", 1, listOf("Lesotho", "Eswatini", "Gambia", "Sierra Leone")),
        Immagine("https://flagcdn.com/w320/bw.png", 3, listOf("Somalia", "Estonia", "Botswana", "Ruanda")),
        Immagine("https://flagcdn.com/w320/rw.png", 4, listOf("Gabon", "Tanzania", "Burundi", "Ruanda")),
        Immagine("https://flagcdn.com/w320/bi.png", 2, listOf("Tanzania", "Burundi", "Ruanda", "Uganda")),
        Immagine("https://flagcdn.com/w320/tv.png", 1, listOf("Tuvalu", "Fiji", "Kiribati", "Nauru")),
        Immagine("https://flagcdn.com/w320/fj.png", 3, listOf("Tuvalu", "Nuova Zelanda", "Fiji", "Samoa")),
        Immagine("https://flagcdn.com/w320/ki.png", 4, listOf("Tuvalu", "Palau", "Nauru", "Kiribati")),
        Immagine("https://flagcdn.com/w320/nr.png", 2, listOf("Palau", "Nauru", "Micronesia", "Marshall")),
        Immagine("https://flagcdn.com/w320/pw.png", 1, listOf("Palau", "Bangladesh", "Giappone", "Micronesia")),
        Immagine("https://flagcdn.com/w320/fm.png", 3, listOf("Somalia", "Marshall", "Micronesia", "Palau")),
        Immagine("https://flagcdn.com/w320/mh.png", 4, listOf("Micronesia", "Nauru", "Aruba", "Isole Marshall")),
        Immagine("https://flagcdn.com/w320/vu.png", 2, listOf("Isole Salomone", "Vanuatu", "Papua Nuova Guinea", "Fiji")),
        Immagine("https://flagcdn.com/w320/sb.png", 1, listOf("Isole Salomone", "Vanuatu", "Tonga", "Samoa")),
        Immagine("https://flagcdn.com/w320/to.png", 3, listOf("Samoa", "Svizzera", "Tonga", "Georgia")),
        Immagine("https://flagcdn.com/w320/ws.png", 4, listOf("Tonga", "Taiwan", "Bermuda", "Samoa")),
        Immagine("https://flagcdn.com/w320/kg.png", 2, listOf("Macedonia del Nord", "Kirghizistan", "Kazakistan", "Tagikistan")),
        Immagine("https://flagcdn.com/w320/tj.png", 1, listOf("Tagikistan", "Iran", "Ungheria", "Uzbekistan")),
        Immagine("https://flagcdn.com/w320/tm.png", 3, listOf("Uzbekistan", "Azerbaigian", "Turkmenistan", "Pakistan")),
        Immagine("https://flagcdn.com/w320/uz.png", 4, listOf("Turkmenistan", "Azerbaigian", "Kazakistan", "Uzbekistan")),
        Immagine("https://flagcdn.com/w320/bt.png", 2, listOf("Sikkim", "Bhutan", "Tibet", "Nepal")),
        Immagine("https://flagcdn.com/w320/la.png", 1, listOf("Laos", "Cambogia", "Thailandia", "Belize")),
        Immagine("https://flagcdn.com/w320/kh.png", 3, listOf("Laos", "Vietnam", "Cambogia", "Thailandia")),
        Immagine("https://flagcdn.com/w320/bn.png", 4, listOf("Malesia", "Indonesia", "Singapore", "Brunei")),
        Immagine("https://flagcdn.com/w320/tl.png", 2, listOf("Vanuatu", "Timor Est", "Mozambico", "Angola")),
        Immagine("https://flagcdn.com/w320/ag.png", 1, listOf("Antigua e Barbuda", "Bahamas", "Barbados", "Saint Lucia")),
        Immagine("https://flagcdn.com/w320/bs.png", 3, listOf("Barbados", "Giamaica", "Bahamas", "Belize")),
        Immagine("https://flagcdn.com/w320/bb.png", 4, listOf("Bahamas", "Trinidad e Tobago", "Fiji", "Barbados")),
        Immagine("https://flagcdn.com/w320/lc.png", 2, listOf("Dominica", "Saint Lucia", "Saint Vincent", "Grenada")),
        Immagine("https://flagcdn.com/w320/vc.png", 1, listOf("Saint Vincent e Grenadine", "Saint Lucia", "Grenada", "Dominica")),
        Immagine("https://flagcdn.com/w320/gd.png", 3, listOf("Dominica", "Suriname", "Grenada", "Guyana")),
        Immagine("https://flagcdn.com/w320/dm.png", 4, listOf("Grenada", "Saint Lucia", "Belize", "Dominica")),
        Immagine("https://flagcdn.com/w320/kn.png", 2, listOf("Guyana", "Saint Kitts e Nevis", "Suriname", "Grenada"))
    )
 private var i=0
 private var indici = (0..44).toList()
 private var conta_giuste=0
   private var conta_sbagliate=0
   private var setbandiere=bandiereFacili
 private var punti=0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
 super.onViewCreated(view, savedInstanceState)
val view_bandiera=view.findViewById<ImageView>(R.id.bandiera)
      var testo_punteggio=view.findViewById<TextView>(R.id.punteggio)
        val progressBar=view.findViewById<ProgressBar>(R.id.progress_bar)
        var testo_offset_punteggio=view.findViewById<TextView>(R.id.offset_punteggio)
        var home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.QuizDaGioco)
        }
        var livello_difficolta=arguments?.getChar("livello_difficolta")
        var offset_punteggio=when(livello_difficolta){
            'm'->{
                setbandiere=bandiereMedie
            15}
            'd'->{
            setbandiere=bandiereDifficili
            20}
            else -> {
            setbandiere=bandiereFacili
            10}
        }
        if(savedInstanceState!=null){ //getting the data back if the screen was rotated or the fragment was destroyed and recreated (app in backrground)
         i=savedInstanceState.getInt("indice")
            punti=savedInstanceState.getInt("punti")
            conta_giuste=savedInstanceState.getInt("giuste")
            conta_sbagliate=savedInstanceState.getInt("sbagliate")
            indici=savedInstanceState.getIntegerArrayList("indici")?.toList()?:indici.shuffled()
        }else {
            indici = indici.shuffled()
        punti=0
            conta_giuste=0
            i=0
            conta_sbagliate=0
        }
        progressBar.progress=i
        testo_punteggio.text="Punteggio: $punti"
        testo_punteggio.alpha=1f
        testo_offset_punteggio.alpha=0f
        view_bandiera.load(setbandiere[indici[i]].url)
        var bandiera=setbandiere[indici[i]]
        var bottoni=listOf<Button>(
            view.findViewById<Button>(R.id.btn1),
            view.findViewById<Button>(R.id.btn2),
            view.findViewById<Button>(R.id.btn3),
            view.findViewById<Button>(R.id.btn4),
        )
        var btnnext=view.findViewById<Button>(R.id.btnnext)
        btnnext.isEnabled=false
        for(j in 0..3){
            bottoni[j].text=bandiera.elenco_risposte[j]
        }
for(j in 0..3) {
    bottoni[j].setOnClickListener {
        progressBar.setProgress(progressBar.progress+1, true)
        btnnext.animate().alpha(1f).setDuration(500).start()
        btnnext.isEnabled=true
        if (bandiera.immagine_giusta == j+1) {
            punti += offset_punteggio
            conta_giuste++
            testo_offset_punteggio.setTextColor(Color.GREEN)
            testo_offset_punteggio.text = "+$offset_punteggio"
            bottoni[j].backgroundTintList =
                ColorStateList.valueOf(Color.parseColor("#2E7D32")) //green (right answer)
        } else {
            if (punti >= offset_punteggio) {
                punti -= offset_punteggio
            }
            conta_sbagliate++
            testo_offset_punteggio.setTextColor(Color.RED)
            testo_offset_punteggio.text = "-$offset_punteggio"
            bottoni[bandiera.immagine_giusta - 1].backgroundTintList = ColorStateList.valueOf(Color.parseColor("#2E7D32"))
            bottoni[j].backgroundTintList = ColorStateList.valueOf(Color.parseColor("#C62828")) //red (wrong answer)
        }
        testo_offset_punteggio.animate().alpha(1f).setDuration(100).start()
        testo_punteggio.text = "Punteggio: $punti"
        bottoni.forEach {
            if (it != bottoni[bandiera.immagine_giusta - 1]&& it!=bottoni[j]) {
                it.animate().alpha(0f).setDuration(500).start() // making them invisible
            }
        }
        bottoni.forEach { it.isEnabled=false }// and unclickable
    }
}
        btnnext.setOnClickListener {
            progressBar.setProgress(progressBar.progress+1, true)
            testo_offset_punteggio.alpha=0f
            btnnext.animate().alpha(0f).setDuration(500).start()
          bottoni.forEach {
              it.animate().alpha(1f).setDuration(500).start()
          }
            i++
            if(i<10) {
                bandiera=setbandiere[indici[i]]
                btnnext.isEnabled=false
                for(j in 0..3){
                bottoni[j].text=bandiera.elenco_risposte[j]
                }
                view_bandiera.load(setbandiere[indici[i]].url)
                bottoni.forEach {
                    it.isEnabled=true
                    it.backgroundTintList= ColorStateList.valueOf(Color.parseColor("#0D69E5"))
                    it.animate().alpha(1f).setDuration(500).start()
                }
            }else {
                lifecycleScope.launch {
                    val db = DataBaseUtenti.getDb(requireContext())
                    var user = db.userDao().getUtenti()
                    user?.punteggio+=punti
                    user?.quiz_finiti+=1
                    if(conta_giuste>=6){
                        user?.quiz_corretti+=1
                    }
                    user?.let { db.userDao().AggiornaUtente(it)}
                val bundle=Bundle().apply{
                    putInt("Giuste",conta_giuste)
                    putInt("Sbagliate",conta_sbagliate)
                    putInt("Punteggio", punti)
                    putString("Gioco", "Linguaggio")
                }
                var fragfine= FragFineQuiz()
                fragfine.arguments=bundle
                Navigation.findNavController(view).navigate(R.id.FineQuizBandiere,bundle)
    }}
}
    }

    override fun onSaveInstanceState(outState: Bundle) { //saving the data
        super.onSaveInstanceState(outState)
        outState.putInt("indice", i)
        outState.putInt("punti", punti)
        outState.putInt("giuste", conta_giuste)
        outState.putInt("sbagliate", conta_sbagliate)
        outState.putIntegerArrayList("indici", ArrayList(indici))
    }
}