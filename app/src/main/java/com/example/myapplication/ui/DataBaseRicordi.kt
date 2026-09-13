package com.example.myapplication.ui

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Ricordo::class], version=1)
abstract class DataBaseRicordi: RoomDatabase() {
    abstract fun ricordiDao(): DaoRicordi
    companion object{
        @Volatile
private var istanza: DataBaseRicordi?=null
        fun getDb(contesto: Context): DataBaseRicordi{
            return istanza?:synchronized(this){
                val NuovaIstanza=Room.databaseBuilder(
                    contesto.applicationContext,
                    DataBaseRicordi::class.java,
                    "database_ricordi_memoearth"
                ).build()
                istanza=NuovaIstanza
                NuovaIstanza //returns the instance
            }
        }
    }
}