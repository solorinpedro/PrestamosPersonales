package edu.ucne.prestamospersonales.data.repository

import androidx.room.Insert
import edu.ucne.prestamospersonales.data.OcupacionDao
import edu.ucne.prestamospersonales.model.Ocupacion
import javax.inject.Inject


class Ocupacionrepository @Inject constructor(
    val ocupacionDao: OcupacionDao

        ){
    suspend fun Insertar(ocupacion: Ocupacion) = ocupacionDao.Insertar(ocupacion)
}
