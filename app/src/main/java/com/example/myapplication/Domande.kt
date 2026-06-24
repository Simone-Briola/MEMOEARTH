package com.example.myapplication

class Domande {
    var domanda: String
    var risposta_giusta: Int
    var elenco_risposte: List<Int> = listOf(1,2,3,4)

    constructor(domanda:String, risposta_giusta:Int, elenco_risposte:List<Int>){
        this.domanda=domanda
        this.risposta_giusta=risposta_giusta
        this.elenco_risposte=elenco_risposte
    }
    fun verifica_risposta(s:Int): Boolean {
        if (s == risposta_giusta) {
            return true
        } else {
            return false
        }
    }
}
class Paese{
    var nome: String
    var ricordo: String
    var urlFoto: String
    constructor(nome:String, ricordo:String, urlFoto:String){
        this.nome=nome
        this.ricordo=ricordo
        this.urlFoto=urlFoto
    }
    fun aggiungi_ricordo(new_ricordo:String){
        ricordo=new_ricordo
    }
    fun aggiungi_foto(new_url:String){
        urlFoto=new_url
    }
}