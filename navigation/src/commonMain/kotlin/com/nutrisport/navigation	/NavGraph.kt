package com.nutrisport.`navigation`

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.nutrisport.auth.AuthScreen
import com.nutrisport.`home`.HomeGraphScreen

@Composable
fun SetupNavGraph(startDestination: Screens = Screens.Auth) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Auth
    ) {
        composable<Screens.Auth> {
            AuthScreen(
                navigateToHome = {
                    navController.navigate(Screens.HomeGraph) {
                        popUpTo<Screens.Auth> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Screens.HomeGraph> {
            HomeGraphScreen()
        }
    }
}
