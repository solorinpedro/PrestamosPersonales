package edu.ucne.prestamospersonales.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.model.Ocupacion
import edu.ucne.prestamospersonales.model.Persona

@Database(
    entities = [Ocupacion::class, Persona::class],
    version = 2
)
abstract class PrestamosDb: RoomDatabase(){
    abstract val OcupacionDao: OcupacionDao

    abstract val PersonasDao: PersonasDao
}
