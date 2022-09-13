package edu.ucne.prestamospersonales.data.repository

import edu.ucne.prestamospersonales.data.OcupacionDao
import edu.ucne.prestamospersonales.model.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Ocupacionrepository @Inject constructor(
    val ocupacionDao: OcupacionDao

        ){
    suspend fun Insertar(ocupacion: Ocupacion) = ocupacionDao.Insertar(ocupacion)

    fun List(): Flow<List<Ocupacion>> = ocupacionDao.List()
}
