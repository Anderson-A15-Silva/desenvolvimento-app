package br.com.andersonsilva.askeonbooks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.andersonsilva.askeonbooks.R
import br.com.andersonsilva.askeonbooks.components.CustomTextField

@Composable
fun AddBookScreen(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    Column(
        Modifier.padding(
            vertical = 8.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.height(40.dp))
        Text(stringResource(R.string.home_add_message), fontSize = 20.sp, color = Color(0xFF882500))
        Spacer(Modifier.height(8.dp))
        CustomTextField(
            label = "Nome",
            placeholder = "Escreva o nome do livro",
            value = username,
            onChange = { value -> username = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = "Autor",
            placeholder = "Escreva o nome do autor",
            value = email,
            onChange = { value -> email = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = "Páginas",
            placeholder = "Escreva a quantidade de páginas",
            value = password,
            onChange = { value -> password = value },
            isPassword = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Spacer(Modifier.height(10.dp))
        Row(
            Modifier.padding(30.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("home_screen")
                },
                Modifier.fillMaxWidth()
            ) {
                Text("Adicionar")
            }
        }
    }
}