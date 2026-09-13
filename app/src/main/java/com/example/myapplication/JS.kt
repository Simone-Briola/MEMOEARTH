package com.example.myapplication
import android.util.Log
import android.webkit.JavascriptInterface
import android.content.Context
import android.widget.Toast

class JS(private val onContinenteSelezionato:(String)->Unit){
    @JavascriptInterface
    fun onCountrySelected(nome:String){ //function called by js on click
        MainActivity.Stato.continente_selezionato.value=nome //the global state receives the country's name
   onContinenteSelezionato(nome)
    }
}