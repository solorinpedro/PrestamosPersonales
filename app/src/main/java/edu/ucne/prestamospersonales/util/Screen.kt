package edu.ucne.prestamospersonales.util

sealed class Screen (val route: String){
    object RegistroPersonaScreen: Screen("RegistroPersonas")
    object RegistroOcupaciones: Screen("RegistroOcupaciones")
    object  RegistroPrestamosScreen: Screen("RegistroPrestamos")
    object DashBoardScreen: Screen("DashBoard")
}