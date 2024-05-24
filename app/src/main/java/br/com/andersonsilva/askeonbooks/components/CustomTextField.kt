package br.com.andersonsilva.askeonbooks.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomTextField(
    placeholder: String,
    label: String,
    value: String,
    onChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    isPassword: Boolean = false,
    isOutlined: Boolean = true
) {
    if (isOutlined) {
        OutlinedTextField(
            placeholder = { Text(placeholder) },
            label = { Text(label) },
            value = value,
            onValueChange = onChange,
            keyboardOptions = keyboardOptions,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
        )
    } else {
        TextField(
            placeholder = { Text(placeholder) },
            label = { Text(label) },
            value = value,
            onValueChange = onChange,
            keyboardOptions = keyboardOptions
        )
    }
}

