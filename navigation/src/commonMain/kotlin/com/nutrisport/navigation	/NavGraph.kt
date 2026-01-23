package com.nutrisport.`navigation`

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.nutrisport.auth.AuthScreen

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Auth
    ) {
        composable<Screens.Auth> {
            AuthScreen()
        }
    }
}
