package com.example.myapplication.ui
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.google.android.gms.common.internal.safeparcel.SafeParcelable

@Dao
interface DaoRicordi {
    @Insert
    suspend fun inserisciRicordo(ricordo: Ricordo): Long //suspend=executable in a coroutine
    @Query("SELECT * FROM ricordo")
    suspend fun getRicordi(): List<Ricordo>
    @Update
    suspend fun aggiornaRicordo(ricordo: Ricordo)
    @Delete
    suspend fun rimuoviRicordo(ricordo: Ricordo)
}