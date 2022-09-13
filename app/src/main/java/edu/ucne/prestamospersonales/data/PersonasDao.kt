package edu.ucne.prestamospersonales.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import edu.ucne.prestamospersonales.model.Persona

@Dao
interface PersonasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Persona)
}