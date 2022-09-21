package edu.ucne.prestamospersonales.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.model.Ocupacion
import edu.ucne.prestamospersonales.model.Persona
import edu.ucne.prestamospersonales.model.Prestamo

@Database(
    entities = [Ocupacion::class, Persona::class, Prestamo::class],
    version = 3
)
abstract class PrestamosDb: RoomDatabase(){
    abstract val OcupacionDao: OcupacionDao

    abstract val PersonasDao: PersonasDao

    abstract  val PrestamoDao: PrestamoDao
}
