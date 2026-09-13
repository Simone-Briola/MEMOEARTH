package com.example.myapplication

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.graphics.Color
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.example.myapplication.ui.DataBaseUtenti
import com.example.myapplication.ui.theme.FragFineQuiz
import kotlinx.coroutines.launch

class FragGiocoDomande : Fragment(R.layout.fraggioco_domande_layout) {
 //easy questions, THESE QUESTIONS WERE WRITTEN WITH AI
 val domandeFacili = listOf(
     Domande("Qual è la capitale dell'Italia?", null, 3, listOf("Milano", "Napoli", "Roma", "Firenze")),
     Domande("In quale continente si trova la Cina?", null, 1, listOf("Asia", "Africa", "Europa", "America")),
     Domande("Quale oceano bagna le coste della California?", null,2, listOf("Oceano Atlantico", "Oceano Pacifico", "Oceano Indiano", "Mar Glaciale Artico")),
     Domande("Qual è il fiume che attraversa Roma?", null,4, listOf("Po", "Arno", "Adige", "Tevere")),
     Domande("Qual è lo stato più grande del mondo per superficie?", null,1, listOf("Russia", "Canada", "Stati Uniti", "Cina")),
     Domande("Quale catena montuosa separa l'Italia dalla Francia?",null, 3, listOf("Appennini", "Pirenei", "Alpi", "Ande")),
     Domande("Qual è la capitale del Regno Unito?", null,2, listOf("Dublino", "Londra", "Edimburgo", "Cardiff")),
     Domande("Quale isola italiana è la più grande del Mar Mediterraneo?", null,1, listOf("Sicilia", "Sardegna", "Elba", "Capri")),
     Domande("In quale nazione si trovano le piramidi di Giza?", null,4, listOf("Messico", "Grecia", "India", "Egitto")),
     Domande("Qual è la capitale della Spagna?", null,2, listOf("Barcellona", "Madrid", "Siviglia", "Valencia")),
     Domande("Quale colore non è presente nella bandiera italiana?", null,3, listOf("Verde", "Bianco", "Blu", "Rosso")),
     Domande("Qual è il mare che si trova a est dell'Italia?", null,1, listOf("Mar Adriatico", "Mar Tirreno", "Mar Ionio", "Mar Ligure")),
     Domande("Quale di questi è un vulcano attivo situato in Sicilia?", null,4, listOf("Vesuvio", "Fuji", "Stromboli", "Etna")),
     Domande("Qual è la capitale degli Stati Uniti d'America?", null,2, listOf("New York", "Washington D.C.", "Los Angeles", "Chicago")),
     Domande("In quale continente si trova il Brasile?", null,3, listOf("Africa", "Nord America", "Sud America", "Europa")),
     Domande("Qual è la capitale della Francia?", null,1, listOf("Parigi", "Lione", "Marsiglia", "Bordeaux")),
     Domande("Quale fiume attraversa la città di Londra?", null,3, listOf("Senna", "Tevere", "Tamigi", "Danubio")),
     Domande("In quale nazione si trova la Tour Eiffel?", null,2, listOf("Germania", "Francia", "Belgio", "Regno Unito")),
     Domande("Qual è la capitale della Germania?", null,4, listOf("Monaco", "Francoforte", "Amburgo", "Berlino")),
     Domande("Quanti sono i continenti sulla Terra (modello standard)?",null, 2, listOf("5", "7", "9", "4")),
     Domande("Quale stato ha la forma di uno stivale?",null, 1, listOf("Italia", "Grecia", "Portogallo", "Croazia")),
     Domande("Qual è la capitale del Portogallo?", null, 3, listOf("Madrid", "Barcellona", "Lisbona", "Porto")),
     Domande("Quale oceano bagna le coste dell'Europa occidentale?", null,2, listOf("Oceano Indiano", "Oceano Atlantico", "Oceano Pacifico", "Mar Glaciale Artico")),
     Domande("Qual è la capitale della Grecia?", null,4, listOf("Sparta", "Salonicco", "Patrasso", "Atene")),
     Domande("Quale grande deserto si trova nel nord dell'Africa?", null,1, listOf("Deserto del Sahara", "Deserto del Gobi", "Deserto del Kalahari", "Deserto di Atacama")),
     Domande("In quale città si trova il Colosseo?", null,3, listOf("Napoli", "Milano", "Roma", "Venezia")),
     Domande("Qual è la capitale del Belgio?", null,2, listOf("Amsterdam", "Bruxelles", "Lussemburgo", "Ginevra")),
     Domande("Quale fiume attraversa la città di Parigi?", null, 1, listOf("Senna", "Reno", "Rodano", "Loire")),
     Domande("Quale isola è famosa per la sua forma a triangolo al sud dell'Italia?",null, 4, listOf("Sardegna", "Corsica", "Isola d'Elba", "Sicilia")),
     Domande("Qual è la capitale dei Paesi Bassi?",null, 3, listOf("Rotterdam", "L'Aia", "Amsterdam", "Utrecht")),
     Domande("In quale stato si trova la Statua della Libertà?", null,2, listOf("Regno Unito", "Stati Uniti", "Francia", "Canada")),
     Domande("Qual è la capitale dell'Austria?", null,1, listOf("Vienna", "Salisburgo", "Innsbruck", "Graz")),
     Domande("Qual è il monte più alto d'Italia e d'Europa centrale?",null, 4, listOf("Cervino", "Monte Rosa", "Gran Sasso", "Monte Bianco")),
     Domande("Quale paese confina a nord con gli Stati Uniti?", null,3, listOf("Messico", "Cuba", "Canada", "Groenlandia")),
     Domande("Qual è la capitale della Svizzera?", null,2, listOf("Zurigo", "Berna", "Ginevra", "Basilea")),
     Domande("Quale isola della Campania è famosa per la Grotta Azzurra?",null, 1, listOf("Capri", "Ischia", "Procida", "Ponza")),
     Domande("Qual è la lingua ufficiale del Brasile?",null, 3, listOf("Spagnolo", "Inglese", "Portoghese", "Francese")),
     Domande("Qual è la capitale della Svezia?", null,4, listOf("Oslo", "Helsinki", "Copenaghen", "Stoccolma")),
     Domande("Quale canale artificiale collega il Mar Mediterraneo al Mar Rosso?", null,2, listOf("Canale di Panama", "Canale di Suez", "Canale di Corinto", "Canale di Kiel")),
     Domande("In quale continente si trova l'Egitto?", null,1, listOf("Africa", "Asia", "Europa", "Sud America")),
     Domande("Qual è la capitale dell'Irlanda?", null,3, listOf("Belfast", "Cork", "Dublino", "Galway")),
     Domande("Quale fiume italiano è il più lungo?", null,2, listOf("Tevere", "Po", "Adige", "Arno")),
     Domande("Qual è la capitale della Norvegia?", null,4, listOf("Stoccolma", "Helsinki", "Copenaghen", "Oslo")),
     Domande("In quale stato europeo si trova la regione della Baviera?", null,1, listOf("Germania", "Austria", "Svizzera", "Belgio")),
     Domande("Qual è la capitale della Danimarca?", null,3, listOf("Reykjavik", "Stoccolma", "Copenaghen", "Oslo"))
 )
 // medium difficulty questions
 val domandeMedie = listOf(
     Domande("Qual è la capitale dell'Australia?", null,3, listOf("Sydney", "Melbourne", "Canberra", "Brisbane")),
     Domande("Quale fiume europeo attraversa il maior numero di capitali?", null, 1, listOf("Danubio", "Reno", "Volga", "Sena")),
     Domande("In quale stato si trova la città di Marrakech?", null,2, listOf("Egitto", "Marocco", "Tunisia", "Turchia")),
     Domande("Qual è il lago più profondo del mondo?", null,4, listOf("Lago Superiore", "Lago Tanganica", "Lago Vittoria", "Lago Bajkal")),
     Domande("Quale stretto separa l'Europa dall'Africa?", null,2, listOf("Stretto di Bering", "Stretto di Gibilterra", "Stretto di Magellano", "Canale di Suez")),
     Domande("Qual è la capitale del Canada?", null,1, listOf("Ottawa", "Toronto", "Montreal", "Vancouver")),
     Domande("Quale catena montuosa ospita la vetta del K2?", null,3, listOf("Ande", "Alpi", "Karakorum", "Himalaya")),
     Domande("Qual è la capitale dell'Islanda?", null,4, listOf("Oslo", "Helsinki", "Copenaghen", "Reykjavík")),
     Domande("Quale fiume dell'America del Nord attraversa il Grand Canyon?", null,2, listOf("Mississippi", "Colorado", "Missouri", "Hudson")),
     Domande("Con quale di questi stati non confina la Svizzera?", null,1, listOf("Belgio", "Francia", "Austria", "Germania")),
     Domande("Qual è la capitale del Portogallo?", null, 3, listOf("Porto", "Sintra", "Lisbona", "Faro")),
     Domande("In quale oceano si trovano le isole Mauritius?", null,4, listOf("Oceano Atlantico", "Oceano Pacifico", "Mare Artico", "Oceano Indiano")),
     Domande("Qual è la capitale della Turchia?", null,2, listOf("Istanbul", "Ankara", "Smirne", "Antalya")),
     Domande("Quale stato africano è storicamente noto come Abissinia?",null, 1, listOf("Etiopia", "Egitto", "Sudafrica", "Libia")),
     Domande("Qual è l'isola più grande del mondo (non considerata un continente)?", null,3, listOf("Madagascar", "Borneo", "Groenlandia", "Nuova Guinea")),
     Domande("Qual è la capitale della Polonia?", null,2, listOf("Cracovia", "Varsavia", "Danzica", "Poznan")),
     Domande("Quale fiume attraversa la città di Lisbona?", null,4, listOf("Duero", "Ebro", "Guadalquivir", "Tago")),
     Domande("In quale oceano si trova la fossa oceanica più profonda del pianeta?", null,1, listOf("Oceano Pacifico", "Oceano Atlantico", "Oceano Indiano", "Mar Glaciale Artico")),
     Domande("Qual è la capitale della Romania?", null,3, listOf("Sofia", "Belgrado", "Bucarest", "Budapest")),
     Domande("Quale lago italiano è il più grande per superficie?", null, 2, listOf("Lago di Como", "Lago di Garda", "Lago Maggiore", "Lago Trasimeno")),
     Domande("Qual è la capitale della Croazia?", null,4, listOf("Spalato", "Ragusa", "Fiume", "Zagabria")),
     Domande("Quale deserto asiatico si estende tra la Cina meridionale e la Mongolia?", null,1, listOf("Deserto del Gobi", "Deserto del Thar", "Deserto del Kyzylkum", "Deserto del Karakum")),
     Domande("Qual è la capitale della Scozia?", null,3, listOf("Glasgow", "Aberdeen", "Edimburgo", "Inverness")),
     Domande("Quale arcipelago dell'Oceano Atlantico fa politicamente parte del Portogallo?", null,2, listOf("Canarie", "Azzorre", "Baleari", "Capo Verde")),
     Domande("Qual è la capitale dell'Ungheria?", null,1, listOf("Budapest", "Bucarest", "Praga", "Bratislava")),
     Domande("Quale fiume asiatico è considerato sacro dagli induisti?", null,4, listOf("Mekong", "Gange", "Fiume Giallo", "Indo")),
     Domande("Qual è la capitale del Marocco?", null,2, listOf("Casablanca", "Rabat", "Marrakech", "Fès")),
     Domande("In quale catena montuosa si trova il Machu Picchu?", null,3, listOf("Rocciose", "Himalaya", "Ande", "Appalachi")),
     Domande("Qual è la capitale dell'Argentina?", null,1, listOf("Buenos Aires", "Santiago", "Montevideo", "Lima")),
     Domande("Quale paese europeo è bagnato dal Mar Baltico e confina con la Germania?", null,4, listOf("Svezia", "Danimarca", "Lituania", "Polonia")),
     Domande("Qual è la capitale della Repubblica Ceca?", null,2, listOf("Bratislava", "Praga", "Brno", "Ostrava")),
     Domande("Quale fiume americano sfocia nel Golfo del Messico?", null,3, listOf("Colorado", "Rio Grande", "Mississippi", "Yukon")),
     Domande("Qual è la capitale del Cile?", null,1, listOf("Santiago", "Valparaíso", "Concepción", "Mendoza")),
     Domande("In quale mare si trovano le isole Cicladi?", null,4, listOf("Mar Ionio", "Mar Tirreno", "Mar Nero", "Mar Egeo")),
     Domande("Qual è la capitale della Finlandia?", null,2, listOf("Oslo", "Helsinki", "Stoccolma", "Tallinn")),
     Domande("Quale stretto separa la Russia dall'Alaska?", null,3, listOf("Stretto di Gibilterra", "Stretto di Magellano", "Stretto di Bering", "Stretto di Malacca")),
     Domande("Qual è la capitale del Messico?", null,1, listOf("Città del Messico", "Guadalajara", "Monterrey", "Cancun")),
     Domande("Quale deserto si trova lungo la costa occidentale del Sud America?", null,4, listOf("Deserto del Kalahari", "Deserto del Mojave", "Deserto di Simpson", "Deserto di Atacama")),
     Domande("Qual è la capitale dell'India?", null,2, listOf("Mumbai", "Nuova Delhi", "Calcutta", "Bangalore")),
     Domande("Quale isola del Mediterraneo è divisa in due parti (greca e turca)?", null,3, listOf("Creta", "Rodi", "Cipro", "Malta")),
     Domande("Qual è la capitale della Thailandia?", null,1, listOf("Bangkok", "Phuket", "Chiang Mai", "Pattaya")),
     Domande("In quale stato americano si trova il parco nazionale di Yellowstone?", null,4, listOf("California", "Texas", "Colorado", "Wyoming")),
     Domande("Qual è la capitale del Sudafrica (sede amministrativa)?", null,2, listOf("Città del Capo", "Pretoria", "Johannesburg", "Durban")),
     Domande("Quale fiume attraversa la città di Vienna?", null,3, listOf("Reno", "Sena", "Danubio", "Elba")),
     Domande("Qual è la capitale della Nuova Zelanda?", null,1, listOf("Wellington", "Auckland", "Christchurch", "Queenstown"))
 )
//hard questions
val domandeDifficili = listOf(
    Domande("Qual è la capitale dello stato del Kazakistan?", null,4, listOf("Almaty", "Tashkent", "Baku", "Astana")),
    Domande("Quale di questi stati è interamente circondato dal Sudafrica?", null,1, listOf("Lesotho", "Swaziland", "Botswana", "Namibia")),
    Domande("Qual è il punto più basso della terra sulla terraferma?", null,2, listOf("Fossa delle Marianne", "Depressione del Mar Morto", "Valle della Morte", "Lago Assal")),
    Domande("Qual è la capitale della Nuova Zelanda?", null,3, listOf("Auckland", "Christchurch", "Wellington", "Hamilton")),
    Domande("Quale fiume africano è noto per le Cascate Vittoria?", null,1, listOf("Zambesi", "Congo", "Nilo", "Niger")),
    Domande("Qual è lo stato meno popolato del mondo?", null,4, listOf("Tuvalu", "Nauru", "San Marino", "Città del Vaticano")),
    Domande("Qual è la capitale della Mongolia?", null,2, listOf("Astana", "Ulaanbaatar", "Bishkek", "Taipei")),
    Domande("In quale arcipelago si trova l'isola di Giava?", null,3, listOf("Filippine", "Giappone", "Indonesia", "Maldive")),
    Domande("Quale deserto si estende tra la Mongolia e la Cina?", null,1, listOf("Deserto del Gobi", "Deserto del Kalahari", "Deserto di Atacama", "Deserto del Taklamakan")),
    Domande("Qual è la capitale dell'Ecuador?", null,4, listOf("Guayaquil", "Bogotà", "Lima", "Quito")),
    Domande("Quale di questi stati americani è composto solo da isole?", null,2, listOf("Florida", "Hawaii", "Alaska", "California")),
    Domande("Qual è la capitale del Vietnam?", null,3, listOf("Ho Chi Minh", "Da Nang", "Hanoi", "Phnom Penh")),
    Domande("Quale mare bagna le coste della Giordania e di Israele?", null,1, listOf("Mar Morto", "Mar Caspio", "Mar Nero", "Mar Rosso")),
    Domande("Qual è la capitale dell'Iran?", null,2, listOf("Baghdad", "Teheran", "Damasco", "Riad")),
    Domande("Quale moneta si usa in Sudafrica?", null,3, listOf("Dollaro", "Scellino", "Rand", "Pula")),
    Domande("Qual è la capitale della Bolivia (capitale costituzionale)?",null, 4, listOf("La Paz", "Cochabamba", "Santa Cruz", "Sucre")),
    Domande("Quale catena montuosa fa da confine naturale tra la Russia europea e quella asiatica?", null,1, listOf("Monti Urali", "Caucaso", "Carpazi", "Monti Altai")),
    Domande("Qual è la capitale della Nigeria?", null,3, listOf("Lagos", "Kano", "Abuja", "Ibadan")),
    Domande("In quale nazione si trova il deserto del Dasht-e Kavir?", null,2, listOf("Arabia Saudita", "Iran", "Iraq", "Pakistan")),
    Domande("Qual è la capitale del Nepal?", null,4, listOf("Thimphu", "Dhaka", "Colombo", "Kathmandu")),
    Domande("Quale isola dell'Oceano Indiano è nota per i suoi alberi di Baobab?", null,1, listOf("Madagascar", "Zanzibar", "Sri Lanka", "Socotra")),
    Domande("Qual è la capitale dell'Uzbekistan?", null,3, listOf("Samarcanda", "Bukhara", "Tashkent", "Dushanbe")),
    Domande("Quale paese ha come lingua ufficiale il khmer?", null,2, listOf("Laos", "Cambogia", "Myanmar", "Vietnam")),
    Domande("Qual è la capitale del Kenya?", null,4, listOf("Mombasa", "Dar es Salaam", "Kampala", "Nairobi")),
    Domande("Qual è lo stretto che separa l'isola di Giava da Sumatra?", null,1, listOf("Stretto della Sonda", "Stretto di Malacca", "Stretto di Lombok", "Stretto di Makassar")),
    Domande("Qual è la capitale del Perù?", null,3, listOf("Cusco", "Arequipa", "Lima", "Trujillo")),
    Domande("In quale stato si trova la depressione geologica di Afar?", null,2, listOf("Kenya", "Etiopia", "Sudan", "Somalia")),
    Domande("Qual è la capitale della Malesia?", null,4, listOf("Singapore", "Giacarta", "Manila", "Kuala Lumpur")),
    Domande("Quale arcipelago nell'Oceano Pacifico è famoso per essere stato visitato da Darwin a bordo del Beagle?", null,1, listOf("Isole Galapagos", "Isole Fiji", "Isole Marchesi", "Isole Hawaii")),
    Domande("Qual è la capitale della Georgia?", null,3, listOf("Baku", "Erevan", "Tbilisi", "Batumi")),
    Domande("Quale grande fiume asiatico sfocia nel Golfo del Bengala?", null,2, listOf("Fiume Giallo", "Gange", "Mekong", "Fiume Azzurro")),
    Domande("Qual è la capitale dell'Azerbaigian?", null,4, listOf("Tbilisi", "Teheran", "Yerevan", "Baku")),
    Domande("In quale nazione si trova la regione desertica dell'Ogaden?", null,1, listOf("Etiopia", "Somalia", "Kenya", "Eritrea")),
    Domande("Qual è la capitale dell'Ucraina?", null,3, listOf("Leopoli", "Odessa", "Kiev", "Charkiv")),
    Domande("Quale lago d'acqua dolce è diviso tra Perù e Bolivia?",null, 2, listOf("Lago Maracaibo", "Lago Titicaca", "Lago Poopó", "Lago Nicaragua")),
    Domande("Qual è la capitale del Bangladesh?", null,4, listOf("Karachi", "Lahore", "Calcutta", "Dhaka")),
    Domande("Quale paese controlla lo Stretto di Malacca insieme a Singapore e Indonesia?",null, 1, listOf("Malesia", "Thailandia", "Vietnam", "Filippine")),
    Domande("Qual è la capitale della Colombia?", null,3, listOf("Medellin", "Cali", "Bogotà", "Cartagena")),
    Domande("Quale di questi laghi si trova interamente in Canada?", null,2, listOf("Lago Superiore", "Grande Lago degli Orsi", "Lago Huron", "Lago Erie")),
    Domande("Qual è la capitale del Libano?", null,4, listOf("Damasco", "Amman", "Nicosia", "Beirut")),
    Domande("Quale stato detiene la sovranità sulle Isole Svalbard?",null, 1, listOf("Norvegia", "Danimarca", "Russia", "Svezia")),
    Domande("Qual è la capitale del Senegal?", null,3, listOf("Bamako", "Conakry", "Dakar", "Banjul")),
    Domande("In quale oceano si trova la fossa di Porto Rico?", null,2, listOf("Oceano Pacifico", "Oceano Atlantico", "Oceano Indiano", "Mar Glaciale Artico")),
    Domande("Qual è la capitale della Siria?", null,4, listOf("Aleppo", "Homs", "Riad", "Damasco")),
    Domande("Quale di questi mari è tecnicamente un lago salato endoreico?", null,1, listOf("Mar Caspio", "Mar Rosso", "Mar Baltico", "Mar Nero"))
)
    private var indici = (0..44).toList() //this array contains numbers from 0 to 44 in a random pattern that changes every time the fragment is loaded
private var punti=0
    private var i=0
    private  var conta_giuste=0
    private var conta_sbagliate=0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var progressBar=view.findViewById<ProgressBar>(R.id.progress_bar)
        var bottoni=listOf<Button>(
        view.findViewById<Button>(R.id.btn1),
        view.findViewById<Button>(R.id.btn2),
        view.findViewById<Button>(R.id.btn3),
        view.findViewById<Button>(R.id.btn4),
        )
var btnnext=view.findViewById<Button>(R.id.btnnext)
        progressBar.setProgress(progressBar.progress+1, true)
        val testo_punteggio=view.findViewById<TextView>(R.id.punteggio)
        var testo_offset_punteggio=view.findViewById<TextView>(R.id.offset_punteggio)
        testo_offset_punteggio.alpha=0f
testo_punteggio.text="Punteggio: $punti"
        var home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.DomandeDaGioco)
        }
val view_domanda=view.findViewById<TextView>(R.id.domanda)
        var setdomande=domandeFacili
        var livello_difficolta=arguments?.getChar("livello_difficolta")
        var offset_punti=when(livello_difficolta){
            'm'->{
                setdomande=domandeMedie
                15}
            'd'->{
                setdomande=domandeDifficili
                20}
            else -> {
                setdomande=domandeFacili
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
        var domanda=setdomande[indici[i]]
        view_domanda.text=domanda.domanda
        for(j in 0..3){
            bottoni[j].text=domanda.elenco_risposte[j]
        }
        for(j in 0..3) {
            bottoni[j].setOnClickListener {
                btnnext.isEnabled = true
                btnnext.animate().alpha(1f).setDuration(500)
                    .start() //making all the other buttons invisible
                bottoni.forEach{//making all the other buttons invisible
                    if(it!=bottoni[j]&& it!=bottoni[domanda.risposta_giusta-1]) {
                        it.animate().alpha(0f).setDuration(500).start()
                    } }
                bottoni.forEach { it.isEnabled = false } //making them also unclickable
                if (domanda.risposta_giusta == j+1) {
                    testo_offset_punteggio.setTextColor(Color.GREEN)
                    testo_offset_punteggio.text = "+$offset_punti"
                    conta_giuste++
                    punti += offset_punti
                    bottoni[j].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("#2E7D32")) //green (right answer)
                } else {
                    testo_offset_punteggio.setTextColor(Color.RED)
                    testo_offset_punteggio.text = "-$offset_punti"
                    if (punti >= offset_punti) { //this way points don't go below 0
                        punti -= offset_punti
                    }
                    conta_sbagliate++
                    bottoni[domanda.risposta_giusta-1].backgroundTintList=
                        ColorStateList.valueOf(Color.parseColor("#2E7D32"))
                    bottoni[j].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("#C62828"))
                }
                testo_offset_punteggio.animate().alpha(1f).setDuration(100).start()
                testo_punteggio.text = "Punteggio: $punti"
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
                        domanda=setdomande[indici[i]]
                        view_domanda.text=domanda.domanda
                        btnnext.isEnabled=false
                        for(j in 0..3){
                        bottoni[j].text=domanda.elenco_risposte[j]
                        }
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
                            putString("Gioco", "Domande")
                        }
                        Navigation.findNavController(view).navigate(R.id.FineQuiz,bundle)
                    }
                    }
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



