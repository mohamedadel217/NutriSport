package com.mo.nutrisport


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.mmk.kmpauth.google.GoogleAuthCredentials
import com.mmk.kmpauth.google.GoogleAuthProvider
import com.nutrisport.data.domain.CustomerRepository
import com.nutrisport.navigation.Screens
import com.nutrisport.`navigation`.SetupNavGraph
import com.nutrisports.shared.Constats.WEB_CLIENT_ID
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    MaterialTheme {
        val customerRepository = koinInject<CustomerRepository>()
        var appReady by remember { mutableStateOf(false) }
        val isUserAuthenticated = remember { customerRepository.getCurrentUserId() != null }
        val startDestination = remember {
            if (isUserAuthenticated) Screens.HomeGraph
            else Screens.Auth
        }
        LaunchedEffect(Unit) {
            GoogleAuthProvider.create(credentials = GoogleAuthCredentials(serverId = WEB_CLIENT_ID))
            appReady = true
        }
        AnimatedVisibility(
            modifier = Modifier.fillMaxSize(),
            visible = appReady
        ) {
            SetupNavGraph(
                startDestination = startDestination
            )
        }
    }
}