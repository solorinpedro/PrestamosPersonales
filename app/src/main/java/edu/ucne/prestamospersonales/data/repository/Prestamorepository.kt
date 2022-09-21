package edu.ucne.prestamospersonales.data.repository

import edu.ucne.prestamospersonales.data.PersonasDao
import edu.ucne.prestamospersonales.data.PrestamoDao
import edu.ucne.prestamospersonales.model.Ocupacion
import edu.ucne.prestamospersonales.model.Persona
import edu.ucne.prestamospersonales.model.Prestamo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Prestamorepository @Inject constructor(
    val prestamoDao: PrestamoDao
    ){
    suspend fun  Insertar(prestamos: Prestamo)=prestamoDao.Insertar(prestamos)

    fun List(): Flow<List<Prestamo>> = prestamoDao.List()
}