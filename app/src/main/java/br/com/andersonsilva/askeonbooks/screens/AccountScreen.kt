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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.andersonsilva.askeonbooks.R
import br.com.andersonsilva.askeonbooks.components.CustomTextField

@Composable
fun AccountScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    Column(
        Modifier.padding(
            vertical = 8.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(R.string.account_title_screen), fontSize = 45.sp, color = Color(0xFF882500))
        Spacer(Modifier.height(8.dp))
        CustomTextField(
            label = stringResource(R.string.login_field_username),
            placeholder = stringResource(R.string.placeholder_username),
            value = username,
            onChange = { value -> username = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = stringResource(R.string.login_field_email),
            placeholder = stringResource(R.string.placeholder_email),
            value = email,
            onChange = { value -> email = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = stringResource(R.string.login_field_password),
            placeholder = stringResource(R.string.placeholder_password),
            value = password,
            onChange = { value -> password = value },
            isPassword = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        Spacer(Modifier.height(10.dp))
        Row(
            Modifier.padding(30.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("login_screen")
                },
                Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.account_button_create))
            }
        }
    }
}
