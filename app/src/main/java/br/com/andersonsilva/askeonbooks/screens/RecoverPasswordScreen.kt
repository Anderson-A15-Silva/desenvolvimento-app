package br.com.andersonsilva.askeonbooks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.andersonsilva.askeonbooks.R
import br.com.andersonsilva.askeonbooks.components.CustomTextField

@Composable
fun RecoverPasswordScreen(navController: NavController) {
    var userkey by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CustomTextField(
            label = stringResource(R.string.user_key_password),
            placeholder = stringResource(R.string.placeholder_user_key),
            value = userkey,
            onChange = { value -> userkey = value },
            isPassword = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
        Spacer(Modifier.height(15.dp))
        Button(
            onClick = { navController.navigate("home_screen") },
            Modifier
                .padding(horizontal = 45.dp)
                .fillMaxWidth()
        ) {
            Text(stringResource(R.string.recover_button_confirm))
        }
    }
}