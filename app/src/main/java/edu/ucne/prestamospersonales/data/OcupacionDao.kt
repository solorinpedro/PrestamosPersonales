package edu.ucne.prestamospersonales.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

import edu.ucne.prestamospersonales.model.Ocupacion

@Dao
interface OcupacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(ocupacion: Ocupacion)

    @Update
    suspend fun Modificar(ocupacion: Ocupacion)

    @Delete
    suspend fun Eliminar(ocupacion: Ocupacion)

    @Query(
        """
        SELECT * 
        FROM ocupaciones
        ORDER BY ocupacionId
    """
    )
    fun List(): Flow<List<Ocupacion>>
    @Query(
        """
        SELECT * 
        FROM ocupaciones
        WHERE ocupacionId =:Id
    """
    )
    fun Buscar(Id:Int): Flow<Ocupacion>
}