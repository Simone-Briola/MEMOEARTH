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
import com.example.myapplication.Domande
import com.example.myapplication.R
import com.example.myapplication.ui.DataBaseUtenti
import kotlinx.coroutines.launch

class FragGiocoLinguaggio : Fragment(R.layout.fraggioco_linguaggio_layout) {
        //THIS PART WAS MADE WITH AI
        val frasiFacili = listOf(
            Domande("Bonjour, comment ça va?", "Buongiorno, come va?", 1, listOf("Francese", "Spagnolo", "Inglese", "Tedesco")),
            Domande("Hello, how are you?", "Ciao, come stai?", 3, listOf("Tedesco", "Olandese", "Inglese", "Svedese")),
            Domande("Hola, ¿cómo estás?", "Ciao, come stai?", 2, listOf("Italiano", "Spagnolo", "Portoghese", "Francese")),
            Domande("Guten Tag, wie geht es Ihnen?", "Buongiorno, come sta?", 4, listOf("Svedese", "Inglese", "Danese", "Tedesco")),
            Domande("Ciao, come stai?", "Ciao, come stai?", 1, listOf("Italiano", "Spagnolo", "Rumeno", "Portoghese")),
            Domande("Olá, tudo bem?", "Ciao, tutto bene?", 3, listOf("Spagnolo", "Francese", "Portoghese", "Italiano")),
            Domande("Nǐ hǎo, nǐ hǎo ma?", "Ciao, come stai?", 2, listOf("Giapponese", "Cinese", "Coreano", "Vietnamita")),
            Domande("Konnichiwa, genki desu ka?", "Buongiorno, come stai?", 4, listOf("Cinese", "Thai", "Mongolo", "Giapponese")),
            Domande("Annyeonghaseyo, eotteohge jinaeseyo?", "Salve, come te la passi?", 1, listOf("Coreano", "Giapponese", "Cinese", "Filippino")),
            Domande("Zdravstvuyte, kak dela?", "Salve, come vanno le cose?", 3, listOf("Polacco", "Ceco", "Russo", "Bulgaro")),
            Domande("Dzien dobry, jak sie masz?", "Buongiorno, come stai?", 2, listOf("Russo", "Polacco", "Slovacco", "Ceco")),
            Domande("Dobry den, jak se mas?", "Buongiorno, come stai?", 4, listOf("Polacco", "Croato", "Serbo", "Ceco")),
            Domande("Goedemorgen, hoe gaat het?", "Buongiorno, come va?", 1, listOf("Olandese", "Tedesco", "Inglese", "Afrikaans")),
            Domande("God dag, hvordan har du det?", "Buondì, come stai?", 3, listOf("Svedese", "Finlandese", "Norvegese", "Olandese")),
            Domande("God dag, hur mar du?", "Buondì, come stai?", 2, listOf("Norvegese", "Svedese", "Danese", "Islandese")),
            Domande("Hyvää päivää, mitä kuuluu?", "Buongiorno, come va?", 4, listOf("Ungherese", "Estone", "Lappone", "Finlandese")),
            Domande("Kalimera, ti kanis?", "Buongiorno, come stai?", 1, listOf("Greco", "Turco", "Albanese", "Bulgaro")),
            Domande("Merhaba, nasilsin?", "Ciao, come stai?", 3, listOf("Arabo", "Persiano", "Turco", "Ebraico")),
            Domande("Shalom, ma shlomcha?", "Pace/Ciao, come stai?", 2, listOf("Arabo", "Ebraico", "Armeno", "Turco")),
            Domande("Marhaban, kayfa halik?", "Benvenuto, come stai?", 4, listOf("Turco", "Ebraico", "Persiano", "Arabo")),
            Domande("Namaste, aap kaise hain?", "Salve, lei come sta?", 1, listOf("Hindi", "Bengalese", "Tamil", "Urdu")),
            Domande("Sawatdee, sabaiดี mai?", "Ciao, stai bene?", 3, listOf("Vietnamita", "Malese", "Thai", "Lao")),
            Domande("Xin chao, ban co khoe khong?", "Ciao, come stai?", 2, listOf("Thai", "Vietnamita", "Khmer", "Tagalog")),
            Domande("Selamat pagi, apa kabar?", "Buongiorno, che notizie ci sono?", 4, listOf("Tagalog", "Vietnamita", "Hindi", "Indonesiano")),
            Domande("Kamusta, kumusta ka?", "Ciao, come stai?", 1, listOf("Tagalog", "Indonesiano", "Malese", "Hawaiiano")),
            Domande("Jambo, habari gani?", "Ciao, quali notizie?", 3, listOf("Zulu", "Xhosa", "Swahili", "Yoruba")),
            Domande("Aloha, pehea 'oe?", "Ciao, come stai?", 2, listOf("Maori", "Hawaiiano", "Samoano", "Sango")),
            Domande("Kia ora, kei te pehea koe?", "Ciao, come stai?", 4, listOf("Hawaiiano", "Samoano", "Tahitiano", "Maori")),
            Domande("Szervusz, hogy vagy?", "Ciao, come stai?", 1, listOf("Ungherese", "Finlandese", "Slovacco", "Estone")),
            Domande("Tere, kuidas laheb?", "Ciao, come va?", 3, listOf("Finlandese", "Lituano", "Estone", "Lettone")),
            Domande("Labdien, ka jums klajas?", "Buongiorno, come sta?", 2, listOf("Lituano", "Lettone", "Estone", "Polacco")),
            Domande("Laba diena, kaip laikotes?", "Buongiorno, come va?", 4, listOf("Lettone", "Estone", "Polacco", "Lituano")),
            Domande("Dobar dan, kako ste?", "Buondì, come sta?", 1, listOf("Croato", "Ceco", "Rumeno", "Ungherese")),
            Domande("Dobar den, kak ste?", "Buondì, come sta?", 3, listOf("Russo", "Polacco", "Bulgaro", "Serbo")),
            Domande("Buna ziua, ce mai faci?", "Buongiorno, che fai/come va?", 2, listOf("Italiano", "Rumeno", "Spagnolo", "Portoghese")),
            Domande("Pryvit, yak spravy?", "Ciao, come va?", 4, listOf("Russo", "Polacco", "Bulgaro", "Ucraino")),
            Domande("Bello, how is you?", "Ciao, come stai? (Linguaggio Minions)", 1, listOf("Minionese (Fittizio)", "Inglese", "Esperanto", "Interlingua")),
            Domande("Salu, ki jan ou ye?", "Ciao, come stai?", 3, listOf("Francese", "Spagnolo", "Creolo Haitiano", "Portoghese")),
            Domande("G'day, how ya goin'?", "Buondì, come ti va?", 2, listOf("Inglese Britannico", "Inglese Australiano", "Inglese Americano", "Scozzese")),
            Domande("Dia dhuit, conas atá tú?", "Dio sia con te, come stai?", 4, listOf("Gaelico Scozzese", "Gallesee", "Bretone", "Gaelico Irlandese")),
            Domande("Bore da, sut ydych chi?", "Buongiorno, come sta?", 1, listOf("Gallese", "Gaelico Irlandese", "Cornico", "Inglese")),
            Domande("Salam, chetor hasti?", "Ciao, come stai?", 3, listOf("Arabo", "Turco", "Persiano", "Urdu")),
            Domande("As-salamu alaykum", "La pace sia con te", 2, listOf("Persiano", "Arabo", "Urdu", "Ebraico")),
            Domande("Szia, hogy vagy?", "Ciao, come stai?", 4, listOf("Finlandese", "Slovacco", "Rumeno", "Ungherese")),
            Domande("Sawatdee krub", "Salve/Buongiorno (detto da uomo)", 1, listOf("Thai", "Vietnamita", "Cinese", "Giapponese"))
        )

    val frasiMedie = listOf(
        Domande("Hae, kes oled?", "Ehi, chi sei?", 3, listOf("Finlandese", "Svedese", "Estone", "Lituano")),
        Domande("Moi, mita kuuluu päivaan?", "Ciao, come va la giornata?", 1, listOf("Finlandese", "Estone", "Ungherese", "Svedese")),
        Domande("Hej, hvordan gar det?", "Ciao, come va?", 2, listOf("Svedese", "Danese", "Norvegese", "Olandese")),
        Domande("Terve, kuinka voit?", "Ciao, come stai?", 4, listOf("Estone", "Lituano", "Lappone", "Finlandese")),
        Domande("Hoe gaan dit met jou?", "Come vanno le cose con te?", 1, listOf("Afrikaans", "Olandese", "Tedesco", "Fiammingo")),
        Domande("S'mae, sut mae?", "Ehi, come va?", 3, listOf("Gaelico Irlandese", "Gaelico Scozzese", "Gallese", "Bretone")),
        Domande("Halò, ciamar a tha thu?", "Ciao, come stai?", 2, listOf("Gallese", "Gaelico Scozzese", "Gaelico Irlandese", "Manx")),
        Domande("Kassoumai, ti wa?", "Ciao, ci sei?", 4, listOf("Swahili", "Wolof", "Yoruba", "Mandinka")),
        Domande("Is ka warran, sidee tahay?", "Che si dice, come stai?", 1, listOf("Somalo", "Amharico", "Swahili", "Oromo")),
        Domande("Tena yistilign, kemen awoha?", "Pace a te, come stai?", 3, listOf("Somalo", "Tigrino", "Amharico", "Arabo")),
        Domande("Nangadef, waaw?", "Come va, tutto bene?", 2, listOf("Bambara", "Wolof", "Hausa", "Swahili")),
        Domande("Inu zikuyenda bwanji?", "Come stanno andando le cose?", 4, listOf("Chichewa", "Lingala", "Zulu", "Chinyanja")),
        Domande("Moni, muli bwanji?", "Ciao, come stai?", 1, listOf("Chichewa", "Swahili", "Zulu", "Shona")),
        Domande("Kedu ka mere?", "Che è successo/Come va?", 3, listOf("Yoruba", "Hausa", "Igbo", "Swahili")),
        Domande("E kaaro, bawo ni?", "Buongiorno, come va?", 2, listOf("Igbo", "Yoruba", "Hausa", "Lingala")),
        Domande("Sannu, ya kake?", "Ciao, come stai?", 4, listOf("Yoruba", "Igbo", "Fulani", "Hausa")),
        Domande("Mbote, sango nini?", "Ciao, che notizie ci sono?", 1, listOf("Lingala", "Swahili", "Kikongo", "Chiluba")),
        Domande("Sawubona, unjani?", "Ti vedo/Ciao, come stai?", 3, listOf("Xhosa", "Sotho", "Zulu", "Tswana")),
        Domande("Molo, unjani?", "Ciao, come stai?", 2, listOf("Zulu", "Xhosa", "Swahili", "Afrikaans")),
        Domande("Dumela, o kae?", "Buongiorno, dove sei/come va?", 4, listOf("Zulu", "Xhosa", "Shona", "Sotho")),
        Domande("Bula, vacava tiko?", "Benvenuto, come te la passi?", 1, listOf("Fijiano", "Samoano", "Tongano", "Maori")),
        Domande("Talofa, 'e fa'apefea 'oe?", "Ciao, come stai?", 3, listOf("Hawaiiano", "Maori", "Samoano", "Fijiano")),
        Domande("Malo e lelei, fefe hake?", "Buongiorno, come va?", 2, listOf("Samoano", "Tongano", "Fijiano", "Maori")),
        Domande("Ia orana, e aha te huru?", "Buongiorno, come stanno le cose?", 4, listOf("Hawaiiano", "Maori", "Samoano", "Tahitiano")),
        Domande("Kassoumai, abene?", "Ciao, come va?", 1, listOf("Diola", "Wolof", "Serer", "Peul")),
        Domande("Kaixo, nola zaude?", "Ciao, come stai?", 3, listOf("Catalano", "Galiziano", "Basco", "Asturiano")),
        Domande("Bon dia, com estás?", "Buongiorno, come stai?", 2, listOf("Spagnolo", "Catalano", "Occitano", "Portoghese")),
        Domande("Ola, como estas?", "Ciao, come stai?", 4, listOf("Spagnolo", "Portoghese", "Catalano", "Galiziano")),
        Domande("Boas, tudo bem contigo?", "Ciao, tutto bene con te?", 1, listOf("Portoghese", "Galiziano", "Spagnolo", "Catalano")),
        Domande("Bongour, ki maniere?", "Buongiorno, come va?", 3, listOf("Francese", "Creolo Reunionese", "Creolo Mauriziano", "Malgascio")),
        Domande("Salama, manao ahoana?", "Ciao, come va?", 2, listOf("Swahili", "Malgascio", "Somalo", "Comoriano")),
        Domande("Moni, wa uka bwanji?", "Ciao, come ti sei svegliato?", 4, listOf("Swahili", "Tumbuka", "Zulu", "Chichewa")),
        Domande("Suostei, neak sok sabay te?", "Ciao, stai bene e in salute?", 1, listOf("Khmer", "Thai", "Lao", "Burmese")),
        Domande("Sabaidee, pen hang dai?", "Ciao, come va?", 3, listOf("Thai", "Vietnamita", "Lao", "Khmer")),
        Domande("Mingalaba, kay kantar par lae?", "Un augurio a te, come stai?", 2, listOf("Thai", "Burmese", "Khmer", "Karen")),
        Domande("Helo, siwrne dda!", "Ciao, buon viaggio!", 4, listOf("Gaelico Scozzese", "Gaelico Irlandese", "Cornico", "Gallese")),
        Domande("Sain baashuud uu?", "Stai bene?", 1, listOf("Mongolo", "Kazako", "Uzbeco", "Kirghiso")),
        Domande("Salemetsiz be, kalay siz?", "Salve, lei come sta?", 3, listOf("Uzbeco", "Turkmeno", "Kazako", "Tagiko")),
        Domande("Assalomu alaykum, kalaysiz?", "La pace sia con te, come stai?", 2, listOf("Kazako", "Uzbeco", "Kirghiso", "Uiguro")),
        Domande("Salomatmisiz, qandaysiz?", "Siete in salute, come va?", 4, listOf("Uzbeco", "Kazako", "Turkmeno", "Kirghiso")),
        Domande("Korshoshgonngo kubanichchamyz", "Felice di vederti/incontrarti", 1, listOf("Kirghiso", "Uzbeco", "Mongolo", "Tatariko")),
        Domande("Salamatsyzby, kandaysyz?", "Salve, come sta?", 3, listOf("Kazako", "Uzbeco", "Kirghiso", "Turkmeno")),
        Domande("Essenessisiz be?", "State bene?", 2, listOf("Kazako", "Tatariko", "Bashkiro", "Uiguro")),
        Domande("Iänsems, kodat tevtne?", "Buongiorno, come vanno gli affari?", 4, listOf("Russo", "Udmurto", "Mari", "Erzya")),
        Domande("Shumbat, kodat tevtne?", "Salute a te, come vanno le cose?", 1, listOf("Moksha", "Tatariko", "Russo", "Ciuvascio"))
    )

    val frasiDifficili = listOf(
        Domande("Pryvitannya, yak vashi spravy?", "Saluti, come vanno i vostri affari?", 3, listOf("Russo", "Bielorusso", "Ucraino", "Polacco")),
        Domande("Vitam, yak vashe zdarouye?", "Benvenuto, come va la salute?", 2, listOf("Ucraino", "Bielorusso", "Polacco", "Slovacco")),
        Domande("Zdravo, kako ste?", "Salve, come sta?", 4, listOf("Russo", "Bulgaro", "Polacco", "Macedone")),
        Domande("Zdravo, kak si?", "Ciao, come stai?", 1, listOf("Macedone", "Bulgaro", "Serbo", "Sloveno")),
        Domande("Zhivjo, kako si?", "Ciao/Salute, come stai?", 3, listOf("Croato", "Serbo", "Sloveno", "Slovacco")),
        Domande("Pritorika, faafetai!", "Buona sera, grazie!", 2, listOf("Fijiano", "Tuvaluano", "Samoano", "Kiribati")),
        Domande("Mauri, ko na era?", "Benedizioni, come va?", 4, listOf("Tuvaluano", "Nauruano", "Marshallese", "Kiribati")),
        Domande("Alii, ke elang?", "Ciao, come stanno le cose?", 1, listOf("Palauano", "Chamorru", "Chuukese", "Yapese")),
        Domande("Hafa adai, tatatmane ha?", "Ciao, come va?", 3, listOf("Palauano", "Caroliniano", "Chamorru", "Marshallese")),
        Domande("Ran annim, ifa usun?", "Buona giornata, come va?", 2, listOf("Palauano", "Chuukese", "Kosraean", "Pohnpeiano")),
        Domande("Kaselehlie, ke wahw?", "Saluti, come stai?", 4, listOf("Chuukese", "Yapese", "Marshallese", "Pohnpeiano")),
        Domande("Mogethin, mang e ngaw?", "Ciao, cosa c'è che non va?", 1, listOf("Yapese", "Palauano", "Chuukese", "Kosraean")),
        Domande("Len wo, kom mour?", "Buona giornata, stai bene?", 3, listOf("Pohnpeiano", "Yapese", "Marshallese", "Chuukese")),
        Domande("Halo, yu stap gut?", "Ciao, stai bene?", 2, listOf("Fijiano", "Tok Pisin", "Bislama", "Pijin")),
        Domande("Halo, olsem wanem?", "Ciao, come va?", 4, listOf("Tok Pisin", "Motu", "Hiri Motu", "Bislama")),
        Domande("Halo, i wankaim?", "Ciao, è tutto a posto?", 1, listOf("Pijin (Isole Salomone)", "Tok Pisin", "Bislama", "Samoano")),
        Domande("Kiorana, pe'ea koe?", "Possa tu vivere a lungo, come stai?", 3, listOf("Maori", "Tahitiano", "Maori delle Isole Cook", "Hawaiiano")),
        Domande("Fakaalofa lahi atu, meaa koe?", "Tanto amore a te, come stai?", 2, listOf("Samoano", "Niueano", "Tongano", "Tuvaluano")),
        Domande("Fakatalofa atu, e a koe?", "Saluti a te, come va?", 4, listOf("Tokelauano", "Samoano", "Niueano", "Tuvaluano")),
        Domande("Taloha, e a koe?", "Ciao, come stai?", 1, listOf("Tokelauano", "Tuvaluano", "Samoano", "Tahitiano")),
        Domande("Bula vinaka, vacava tiko?", "Un caloroso saluto, come stai?", 3, listOf("Tongano", "Samoano", "Fijiano", "Rotumano")),
        Domande("Noa'ia, 'e kai?", "Ciao, hai mangiato?", 2, listOf("Fijiano", "Rotumano", "Wallisiano", "Futuniano")),
        Domande("Malo te katiko, e fefea?", "Grazie per essere qui, come va?", 4, listOf("Rotumano", "Samoano", "Tongano", "Wallisiano")),
        Domande("Malo te ma'uli, e fefea?", "Grazie per la vita, come stai?", 1, listOf("Futuniano", "Wallisiano", "Tongano", "Niueano")),
        Domande("Klaik, a'e ba?", "Ciao, come va?", 3, listOf("Armeno", "Georgiano", "Osseto", "Abcaso")),
        Domande("Gamarjoba, rogora khar?", "Vittoria/Ciao, come stai?", 2, listOf("Armeno", "Georgiano", "Megrelio", "Svano")),
        Domande("Salam, necasiniz?", "Ciao, come sta?", 4, listOf("Turco", "Persiano", "Curdo", "Azero")),
        Domande("Silav, tu cawa yi?", "Saluti, come stai?", 1, listOf("Curdo (Kurmanji)", "Persiano", "Pashto", "Balochi")),
        Domande("Sloom, choni?", "Ciao, come stai?", 3, listOf("Persiano", "Urdu", "Curdo (Sorani)", "Azero")),
        Domande("Pakhir raghley, tsanga ye?", "Benvenuto, come stai?", 2, listOf("Dari", "Pashto", "Tajik", "Balochi")),
        Domande("Salam, shuma chetor hastin?", "Ciao, lei come sta?", 4, listOf("Pashto", "Balochi", "Urdu", "Dari")),
        Domande("Shoma chetor hastid?", "Voi come state?", 1, listOf("Tajik", "Uzbeco", "Turkmeno", "Kyrgyz")),
        Domande("Salamatsyzba, jagdayynyz kalay?", "State bene, qual è la vostra situazione?", 3, listOf("Uzbeco", "Turkmeno", "Karakalpako", "Kazako")),
        Domande("Salamatsyz my, yagdaylarynyz nili?", "State bene, come va la vostra situazione?", 2, listOf("Kazako", "Turkmeno", "Uzbeco", "Uiguro")),
        Domande("Assalamu alaykum, yaxshimuyiz?", "La pace sia con voi, state bene?", 4, listOf("Uzbeco", "Kazako", "Kirghiso", "Uiguro")),
        Domande("Bongu, kif int?", "Buongiorno, come stai?", 1, listOf("Maltese", "Arabo", "Ebraico", "Siciliano")),
        Domande("Demean, tanastin?", "Buona sera, come state?", 3, listOf("Cabilo", "Shilha", "Tamazight", "Tuareg")),
        Domande("Azul, mamnk antgit?", "Ciao, come stai?", 2, listOf("Cabilo", "Tamazight (Shilha)", "Tuareg", "Maltese")),
        Domande("Azul, fella-wen!", "Ciao a tutti voi!", 4, listOf("Shilha", "Riffeno", "Siwi", "Cabilo")),
        Domande("Azul, amek thettili?", "Ciao, come te la passi?", 1, listOf("Cabilo", "Tuareg", "Mozabite", "Chaouia")),
        Domande("Oy, isen'ek?", "Ciao, come stai?", 3, listOf("Amharico", "Somalo", "Tigrino", "Afar")),
        Domande("Heloo, kifiin?", "Ciao, come state?", 2, listOf("Arabo Egiziano", "Arabo Levantino", "Arabo Maghrebin", "Arabo del Golfo")),
        Domande("Izzayyak, 'amil eh?", "Come stai, che fai?", 4, listOf("Arabo Levantino", "Arabo del Golfo", "Arabo Iracheno", "Arabo Egiziano")),
        Domande("Shlonak, shako mako?", "Come va, che c'è di nuovo?", 1, listOf("Arabo Iracheno", "Arabo Egiziano", "Arabo Maghrebin", "Arabo Yemeni")),
        Domande("Kiyf halak, 'asaak bkhayr?", "Come stai, spero bene?", 3, listOf("Arabo Egiziano", "Arabo Levantino", "Arabo del Golfo", "Arabo Sudanese"))
    )

    private var indici = (0..44).toList() //this array contains numbers from 0 to 44 in a random pattern that changes every time the fragment is loaded
    private var punti=0
    private var i=0
    private var conta_giuste=0
    private var conta_sbagliate=0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bottoni=listOf<Button>(
            view.findViewById<Button>(R.id.btn1),
            view.findViewById<Button>(R.id.btn2),
            view.findViewById<Button>(R.id.btn3),
            view.findViewById<Button>(R.id.btn4),
        )
        var btnnext=view.findViewById<Button>(R.id.btnnext)
        btnnext.isEnabled=false
        var traduzione=view.findViewById<TextView>(R.id.frasetradotta)
        var progressBar=view.findViewById<ProgressBar>(R.id.progress_bar)
        val testo_punteggio=view.findViewById<TextView>(R.id.punteggio)
        testo_punteggio.text="Punteggio: $punti"
        val testo_offset_punteggio=view.findViewById<TextView>(R.id.offset_punteggio)
        testo_offset_punteggio.alpha=0f
        var home=view.findViewById<ImageView>(R.id.icona_home)
        home.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.LinguaggioDaGioco)
        }
        val view_frase=view.findViewById<TextView>(R.id.frase)
        var setdomande=frasiFacili
        var livello_difficolta=arguments?.getChar("livello_difficolta")
        var offset_punteggio=when(livello_difficolta){
            'm'->{
                setdomande=frasiMedie
                15}
            'd'->{
                setdomande=frasiDifficili
                20}
            else -> {
                setdomande=frasiFacili
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
        view_frase.text=domanda.domanda
        traduzione.text="ITALIANO: ${domanda.traduzione}"
      for(j in 0..3){
        bottoni[j].text=domanda.elenco_risposte[j]
      }
        for(j in 0..3) {
            bottoni[j].setOnClickListener {
                btnnext.isEnabled = true
                btnnext.animate().alpha(1f).setDuration(500).start()
               bottoni.forEach{//making all the other buttons invisible
                   if(it!=bottoni[j]&& it!=bottoni[domanda.risposta_giusta-1]) {
               it.animate().alpha(0f).setDuration(500).start()
                   } }
                bottoni.forEach { it.isEnabled = false } //making them also unclickable
                if (domanda.risposta_giusta == j+1) {
                    punti += offset_punteggio
                    conta_giuste++
                    testo_offset_punteggio.setTextColor(Color.GREEN)
                    testo_offset_punteggio.text = "+$offset_punteggio"
                    bottoni[j].backgroundTintList = ColorStateList.valueOf(Color.parseColor("#2E7D32")) //green (right answer)
                } else {
                    if (punti >= offset_punteggio) {
                        punti -= offset_punteggio
                    }
                    conta_sbagliate++
                    testo_offset_punteggio.setTextColor(Color.RED)
                    testo_offset_punteggio.text = "-$offset_punteggio"
                    bottoni[j].backgroundTintList =
                        ColorStateList.valueOf(Color.parseColor("#C62828"))
                    bottoni[domanda.risposta_giusta-1].backgroundTintList=
                      ColorStateList.valueOf(Color.parseColor("#2E7D32"))
                }
                testo_offset_punteggio.animate().alpha(1f).setDuration(100).start()
                testo_punteggio.text = "Punteggio: $punti"
            }
        }
        btnnext.setOnClickListener {
            progressBar.setProgress(progressBar.progress+1, true)
            btnnext.animate().alpha(0f).setDuration(500).start()
            bottoni.forEach {
                it.animate().alpha(1f).setDuration(500).start()
            }
            i++
            if(i<10) {
                domanda=setdomande[indici[i]]
                view_frase.text=domanda.domanda
                traduzione.text="ITALIANO: ${domanda.traduzione}"
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
                    putString("Gioco", "Linguaggio")
                }
                var fragfine= FragFineQuiz()
                fragfine.arguments=bundle
                Navigation.findNavController(view).navigate(R.id.FineQuizLinguaggio,bundle)
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
