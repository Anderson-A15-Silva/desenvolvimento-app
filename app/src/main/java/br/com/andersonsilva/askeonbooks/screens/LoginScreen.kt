package br.com.andersonsilva.askeonbooks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.andersonchoren.login.model.User
import br.com.andersonchoren.login.repository.UserRepository
import br.com.andersonsilva.askeonbooks.R
import br.com.andersonsilva.askeonbooks.components.CustomTextField
import br.com.andersonsilva.askeonbooks.screens.TextButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val localContext = LocalContext.current
    val welcomeMessage = stringResource(R.string.message_success)
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Column(
        Modifier.padding(
            vertical = 8.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(R.string.login_title_screen), fontSize = 75.sp, color = Color(0xFF882500))
        Spacer(Modifier.height(8.dp))
        CustomTextField(
            label = stringResource(R.string.login_field_email),
            placeholder = stringResource(R.string.placeholder_email),
            value = email,
            onChange = { value -> email = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
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
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )
        Spacer(Modifier.height(8.dp))
        Row {
            TextButton(
                onClick = { navController.navigate("recover_password_screen") }
            ) {
                Text(stringResource(R.string.login_text_first_option))
            }
            Spacer(Modifier.width(12.dp))
            TextButton(
                onClick = { navController.navigate("account_screen") }
            ) {
                Text(stringResource(R.string.login_text_second_option))
            }
        }
        Spacer(Modifier.height(10.dp))
        Row(
            Modifier.padding(30.dp)
        ) {
            Button(
                onClick = {
                    val user = User(
                        id = null,
                        email = email,
                        password = password,
                    )
                    val repository = UserRepository(localContext)
                    val result: User? = repository.findOne(user)
                    if (result != null) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = welcomeMessage
                            )
                        }
                        navController.navigate("home_screen")
                    }
                },
                Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.login_button_enter))
            }
        }
    }
}

@Composable
fun TextButton(labelValue: String) {
    Text(labelValue, fontSize = 14.sp, color = Color(0xFF882500))
}