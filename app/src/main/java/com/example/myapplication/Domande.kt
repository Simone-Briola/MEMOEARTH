package com.example.myapplication

data class Domande (
    var domanda: String,
    var traduzione: String?,
    var risposta_giusta: Int,
    var elenco_risposte: List<String>
)
data class Immagine(
    var url: String,
    var immagine_giusta:Int,
    var elenco_risposte: List<String>
)