package edu.ucne.prestamospersonales.data.repository

import edu.ucne.prestamospersonales.data.OcupacionDao
import edu.ucne.prestamospersonales.model.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Ocupacionrepository @Inject constructor(
    val ocupacionDao: OcupacionDao

        ){
    suspend fun Insertar(ocupacion: Ocupacion) = ocupacionDao.Insertar(ocupacion)

    suspend fun Modificar(ocupacion: Ocupacion)= ocupacionDao.Modificar(ocupacion)

    suspend fun Eliminar(ocupacion: Ocupacion)= ocupacionDao.Eliminar(ocupacion)

    fun Buscar(ocupacion:Int)= ocupacionDao.Buscar(ocupacion)

    fun List(): Flow<List<Ocupacion>> = ocupacionDao.List()
}
