package edu.ucne.prestamospersonales.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import edu.ucne.prestamospersonales.model.Ocupacion

@Dao
interface OcupacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(ocupacion: Ocupacion)
}