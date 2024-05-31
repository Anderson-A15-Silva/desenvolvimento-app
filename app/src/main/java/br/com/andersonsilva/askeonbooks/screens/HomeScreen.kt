package br.com.andersonsilva.askeonbooks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.andersonsilva.askeonbooks.R
import br.com.andersonsilva.askeonbooks.model.Book
import br.com.andersonsilva.askeonbooks.repository.BookRepository
import kotlinx.coroutines.launch
import androidx.compose.material3.SnackbarHostState as SnackbarHostState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var expanded by remember { mutableStateOf(false) }
    val localContext = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = Color(0xFF882500)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        Modifier.padding(vertical = 36.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(stringResource(R.string.drawer_genres_title), color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Ação")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Aventura")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Comédia")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Fantasia")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Ficção Científica")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Infantil")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Romance")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Sobrenatural")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Suspense")
                        }
                    }
                    Card(
                        Modifier.padding(
                            vertical = 6.dp
                        ).size(width = 340.dp, height = 40.dp).fillMaxWidth()
                    ) {
                        Row(
                            Modifier.padding(
                                vertical = 6.dp,
                                horizontal = 10.dp
                            )
                        ) {
                            Text("Terror")
                        }
                    }
                }
            }
        },
    )
    {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF882500)
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(painterResource(R.drawable.ic_categorymenu), "Um ícone do menu", tint = Color.White)
                        }
                    },
                    title = {
                        Text(stringResource(R.string.home_title_screen), color = Color.White)
                    },
                    actions = {
                        IconButton(
                            onClick = {
                                navController.navigate("login_screen")
                            }) {
                            Icon(
                                painterResource(R.drawable.ic_usermenu),
                                stringResource(R.string.home_user_icon_description),
                                tint = Color.White
                            )
                        }
                    }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate("add_book_screen")
                    }
                ) {
                    Button(
                        onClick = { navController.navigate("add_book_screen") },
                        Modifier.size(70.dp)
                    ) {
                        Text("+", fontSize = 40.sp)
                    }
                }
            }
        ) { paddingValues ->
            Column(
                Modifier.fillMaxSize().padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.padding(
                        vertical = 40.dp,
                        horizontal = 24.dp
                    )
                ) {
                    TextFieldWithInputType(stringResource(R.string.home_input_search))
                }
            }
        }
    }
}

@Composable
fun TextFieldWithInputType(labelValue: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        label = { Text(text = labelValue, fontWeight = FontWeight.Normal, fontSize = 18.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { it ->
            text = it
        },
        singleLine = true
    )
}

