package edu.ucne.prestamospersonales.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

import edu.ucne.prestamospersonales.model.Ocupacion

@Dao
interface OcupacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(ocupacion: Ocupacion)

    @Query(
        """
        SELECT * 
        FROM ocupaciones
        ORDER BY ocupacionId    
    """
    )
    fun List(): Flow<List<Ocupacion>>
}