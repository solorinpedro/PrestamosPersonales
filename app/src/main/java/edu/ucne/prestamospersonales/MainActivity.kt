package edu.ucne.prestamospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.prestamospersonales.ui.theme.Componentes.Dashboard
import edu.ucne.prestamospersonales.ui.theme.Componentes.RegistroOcupacion
import edu.ucne.prestamospersonales.ui.theme.Componentes.RegistroPersona
import edu.ucne.prestamospersonales.ui.theme.Componentes.RegistroPrestamos
import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import edu.ucne.prestamospersonales.util.Screen


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MyApp()
        }
    }
}

@Composable
fun MyApp() {
    PrestamosPersonalesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navHostController = rememberNavController()
            NavHost(navController = navHostController,
                startDestination = Screen.DashBoardScreen.route){

                composable(route = Screen.DashBoardScreen.route){
                    Dashboard(goRegistroPersonas = {navHostController.navigate(Screen.RegistroPersonaScreen.route)},
                        goRegistroOcupaciones = {navHostController.navigate(Screen.RegistroOcupaciones.route)},
                    goRegistroPrestamo = {navHostController.navigate(Screen.RegistroPrestamosScreen.route)})
                }

                composable(route = Screen.RegistroPersonaScreen.route){
                    RegistroPersona(backToDashboard ={ navHostController.navigate(Screen.DashBoardScreen.route)})
                }

                composable(route = Screen.RegistroOcupaciones.route){
                    RegistroOcupacion(backToDashboard ={ navHostController.navigate(Screen.DashBoardScreen.route)})
                }
                composable(route = Screen.RegistroPrestamosScreen.route){
                    RegistroPrestamos(backToDashboard = {navHostController.navigate(Screen.DashBoardScreen.route)})
                }
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