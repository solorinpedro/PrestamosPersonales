package edu.ucne.prestamospersonales.data.repository

import edu.ucne.prestamospersonales.data.PersonasDao
import edu.ucne.prestamospersonales.model.Persona
import javax.inject.Inject

class Personarepository @Inject constructor(
    val PersonasDao: PersonasDao

        ){
    suspend fun Insertar (persona:Persona) = PersonasDao.Insertar(persona)
}