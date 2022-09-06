package edu.ucne.prestamospersonales.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.model.Ocupacion

@Database(
    entities = [Ocupacion::class],
    version =1
)
abstract class PrestamosDb: RoomDatabase(){
    abstract val OcupacionDao: OcupacionDao
}
