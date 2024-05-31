package br.com.andersonsilva.askeonbooks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.andersonchoren.login.repository.UserRepository
import br.com.andersonsilva.askeonbooks.R
import br.com.andersonsilva.askeonbooks.components.CustomTextField
import br.com.andersonsilva.askeonbooks.model.Book
import br.com.andersonsilva.askeonbooks.repository.BookRepository
import kotlinx.coroutines.launch

@Composable
fun AddBookScreen(navController: NavController){
    var bookImage by remember { mutableStateOf("") }
    var bookName by remember { mutableStateOf("") }
    var bookAuthor by remember { mutableStateOf("") }
    var bookPages by remember { mutableStateOf("") }
    var bookGenrer by remember { mutableStateOf("") }
    val localContext = LocalContext.current
    val successMessage = stringResource(R.string.message_register_success)
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }


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
            label = stringResource(R.string.book_label_image),
            placeholder = stringResource(R.string.book_placeholder_image),
            value = bookImage,
            onChange = { value -> bookImage = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = stringResource(R.string.book_label_name),
            placeholder = stringResource(R.string.book_placeholder_name),
            value = bookName,
            onChange = { value -> bookName = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = stringResource(R.string.book_label_author),
            placeholder = stringResource(R.string.book_placeholder_author),
            value = bookAuthor,
            onChange = { value -> bookAuthor = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = stringResource(R.string.book_label_genrer),
            placeholder = stringResource(R.string.book_placeholder_genrer),
            value = bookGenrer,
            onChange = { value -> bookGenrer = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        Spacer(Modifier.height(2.dp))
        CustomTextField(
            label = stringResource(R.string.book_label_pages),
            placeholder = stringResource(R.string.book_placeholder_pages),
            value = bookPages,
            onChange = { value -> bookPages = value },
            isPassword = false,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        Spacer(Modifier.height(10.dp))
        Row(
            Modifier.padding(30.dp)
        ) {
            Button(
                onClick = {
                    val book = Book(
                        id = null,
                        image = bookImage,
                        name = bookName,
                        author = bookAuthor,
                        pages = bookPages,
                        genrer = bookGenrer
                    )
                    // val result: List<Book> = repository.findAll(book)
                    val repository = BookRepository(localContext)
                    val id = repository.insert(book)
                    if (id > 0L) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = successMessage,
                                withDismissAction = true,
                                duration = SnackbarDuration.Long
                            )
                        }
                    }
                    navController.navigate("home_screen")
                },
                Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.book_button_add))
            }
        }
    }
}