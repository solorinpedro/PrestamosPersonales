package edu.ucne.prestamospersonales.view
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.data.repository.Ocupacionrepository
import edu.ucne.prestamospersonales.model.Ocupacion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ocupacionviewmodel @Inject constructor(
    val ocupacionrepository: Ocupacionrepository
    ):ViewModel(){
    var ocupacionBuscar by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var salario by mutableStateOf("")

    var prestamo = ocupacionrepository.List()
        private set

    fun Guardar(){
        viewModelScope.launch {
            ocupacionrepository.Insertar(
                Ocupacion(
                  ocupacionId = 0,
                    descripcion = descripcion,
                    salario = salario.toFloat()
                )
            )
        }
    }
}


