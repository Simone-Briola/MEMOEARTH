package com.example.myapplication.ui

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.Utente

@Dao
interface DaoUtenti {
    @Insert
    suspend fun CreaUtente(utente: Utente)
    @Query("SELECT * FROM utente LIMIT 1")//since there is only 1 user the query selects only him (limit 1)
    suspend fun getUtenti():Utente?
    @Update
    suspend fun AggiornaUtente(utente: Utente)
    @Delete
    suspend fun RimuoviUtente(utente: Utente)
}