package com.org.jet


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.org.jet.screens.MainTabScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(MainTabScreen)
    }
}
