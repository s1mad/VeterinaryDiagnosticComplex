package com.example.veterinarydiagnosticcomplex.presentation.screen.pet.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ConfirmExitDialog(
    onDismissRequest: () -> Unit,
    onConfirmRequest: () -> Unit
) {
    AlertDialog(
        title = {
            Text(text = "Выйти из аккаунта?")
        },
        onDismissRequest = {
            onDismissRequest()
        },
        dismissButton = {
            Button(
                onClick = onDismissRequest
            ) {
                Text(text = "Отмена")
            }
        },
        confirmButton = {
            Button(
                onClick = onConfirmRequest,
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                    disabledContainerColor = MaterialTheme.colorScheme.tertiary,
                    disabledContentColor = MaterialTheme.colorScheme.onTertiary
                )
            ) {
                Text(text = "Выйти")
            }
        }
    )
}
