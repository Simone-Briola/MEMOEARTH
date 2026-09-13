package com.example.myapplication.ui
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.Utente

@Database(entities = [Utente::class], version=2)
abstract class DataBaseUtenti: RoomDatabase() {
    abstract fun userDao(): DaoUtenti
    companion object{
        @Volatile
        private var istanza: DataBaseUtenti?=null
        fun getDb(contesto: Context): DataBaseUtenti{
            return istanza?:synchronized(this){
                val NuovaIstanza=Room.databaseBuilder(
                    contesto.applicationContext,
                    DataBaseUtenti::class.java,
                    "database_utenti_memoearth"
                ).fallbackToDestructiveMigration().build()
                istanza=NuovaIstanza
                NuovaIstanza //returns the instance
            }
        }
    }
}