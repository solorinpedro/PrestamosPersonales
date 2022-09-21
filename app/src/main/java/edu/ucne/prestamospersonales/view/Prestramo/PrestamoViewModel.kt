package edu.ucne.prestamospersonales.view.Prestramo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import edu.ucne.prestamospersonales.data.repository.Personarepository
import edu.ucne.prestamospersonales.data.repository.Prestamorepository
import edu.ucne.prestamospersonales.model.Prestamo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    val prestamorepository: Prestamorepository,
    val personarepository: Personarepository
) :ViewModel(){
    var Fecha by mutableStateOf("")
    var Vence by mutableStateOf("")
    var personaId by mutableStateOf("")
    var Concepto by mutableStateOf("")
    var Monto by mutableStateOf("")
    var Balance by mutableStateOf("")

    var selectePersona by mutableStateOf("")
    var expanded by mutableStateOf(false)

    var listas = personarepository.List()
        private set
    fun Guardar(){
        viewModelScope.launch{
            prestamorepository.Insertar(
            Prestamo(
                PrestamoId = 0,
                Fecha = Fecha,
                Vence = Vence,
                personaId = personaId.toInt(),
                Concepto = Concepto,
                Monto = Monto.toDouble(),
                Balance = Balance.toDouble()

            ))
        }
    }
}
