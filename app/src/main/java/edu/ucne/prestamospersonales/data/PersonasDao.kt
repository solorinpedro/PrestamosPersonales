package edu.ucne.prestamospersonales.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.ucne.prestamospersonales.model.Persona
import edu.ucne.prestamospersonales.model.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonasDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Persona)

    @Query(
        """
    SELECT *
    FROM personas
    ORDER BY personaId
    """
    )
    fun List(): Flow<List<Persona>>
}