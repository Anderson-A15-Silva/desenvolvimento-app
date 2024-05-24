package br.com.andersonsilva.askeonbooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.andersonsilva.askeonbooks.ui.theme.AskeonBooksTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import br.com.andersonsilva.askeonbooks.screens.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AskeonBooksTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(
                        navController = navController,
                        startDestination = "login_screen"
                    ){
                        composable("login_screen"){
                            LoginScreen(navController)
                        }
                        composable("account_screen"){
                            AccountScreen(navController)
                        }
                        composable("home_screen"){
                            HomeScreen(navController)
                        }
                        composable("recover_password_screen"){
                            RecoverPasswordScreen(navController)
                        }
                        composable("add_book_screen"){
                            AddBookScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
