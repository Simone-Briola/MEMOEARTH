package com.example.myapplication.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity(tableName = "ricordo")
@Parcelize
data class Ricordo (
@PrimaryKey(autoGenerate = true)
    val id:Int=0,
    var nomeStato:String?,
    var citta:String?,
    var titolo: String?,
    var url:String?
): Parcelable