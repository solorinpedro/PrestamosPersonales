package edu.ucne.prestamospersonales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prestamos")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val PrestamoId: Int,
    val Fecha: String,
    val Vence: String,
    val personaId: Int,
    val Concepto: String,
    val Monto: Double,
    val Balance: Double
)
