package edu.ucne.prestamospersonales

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import edu.ucne.prestamospersonales.view.ocupacionviewmodel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamosPersonalesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(
viewModel: ocupacionviewmodel = hiltViewModel()

) {
    val context = LocalContext.current

    //validar
    var descripcionValidar by remember { mutableStateOf(false)}
    var salarioValidar by remember { mutableStateOf(false)}

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones") })
        }

    ) {it
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)) {
            OutlinedTextField(
                value = viewModel.descripcion,
                onValueChange = {viewModel.descripcion = it},
                label = { Text(text = "descripcion") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Description,
                        contentDescription = null)
                }
            )
            OutlinedTextField(
                value = viewModel.salario,
                onValueChange = {viewModel.salario = it},
                label = { Text(text = "salario") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Money,
                        contentDescription = null)
                }
            )
            Button(onClick = {
                descripcionValidar = viewModel.descripcion.isBlank()
                salarioValidar = viewModel.salario.isBlank()

                if(viewModel.descripcion.toString() == ""){
                    Toast.makeText(context, "Descrpcion no debe estar vacia", Toast.LENGTH_SHORT).show()
                }
                if(viewModel.salario.toString() == ""){
                    Toast.makeText(context, "Salario no debe estar vacia", Toast.LENGTH_SHORT).show()
                }

                if(!descripcionValidar){
                    if (viewModel.salario.toFloat() > 0){
                        viewModel.Guardar()
                        Toast.makeText(context, "Guardado exitosamente", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(context, "El salario no debe de ser menor a 0", Toast.LENGTH_SHORT).show()
                    }
                }


            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)

            ) {
                Text(text = "Guardar")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PrestamosPersonalesTheme {
        MyApp()
    }
}