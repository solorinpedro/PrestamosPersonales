package edu.ucne.prestamospersonales.ui.theme.Componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun Dashboard(goRegistroPersonas:() -> Unit, goRegistroOcupaciones:() -> Unit) {

    val ScaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Dashboard") })
        },

        scaffoldState = ScaffoldState
    ) {
        it

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            OutlinedButton(
                onClick = {
                    goRegistroPersonas()

                },
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(
                    text = "Persona",
                )
            }
            OutlinedButton(
                onClick = {
                          goRegistroOcupaciones()
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Ocupaciones",
                )
            }
        }

    }
}