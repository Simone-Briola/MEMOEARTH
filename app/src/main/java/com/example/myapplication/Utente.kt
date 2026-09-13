package com.example.myapplication
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Utente")
data class Utente (
@PrimaryKey(autoGenerate = true)
    val id:Int=0,
    var nome: String,
    var punteggio:Int,
    var quiz_finiti:Int,
    var quiz_corretti:Int,
    var urlFoto:String?
)