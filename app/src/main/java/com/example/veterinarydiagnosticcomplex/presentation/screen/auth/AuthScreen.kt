package com.example.veterinarydiagnosticcomplex.presentation.screen.auth

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.veterinarydiagnosticcomplex.navigation.Screen

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
    navController: NavController
) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current

    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val phone = "+7 (495) 154-49-56"
    val address = "Москва, Улица Михалковская, 63Б ст4"

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(
            text = "Авторизация",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            shape = shape,
            value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {
                Text("Электроная почта")
            },
            singleLine = true,
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            shape = shape,
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = {
                Text("Пароль")
            },
            singleLine = true
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = shape,
            onClick = {
                // TODO()
                navController.navigate(Screen.Pet.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        ) {
            Text(text = "Вход", style = MaterialTheme.typography.titleLarge)
        }

        Spacer(Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        try {
                            context.startActivity(
                                Intent(
                                    Intent.ACTION_DIAL,
                                    Uri.parse("tel:$phone")
                                )
                            )
                        } catch (e: Exception) {
                            clipboardManager.setText(AnnotatedString(address))
                            Toast
                                .makeText(
                                    context,
                                    "Номер скопирован",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    }
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                text = phone,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(Modifier.height(4.dp))
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        try {
                            context.startActivity(
                                Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("geo:?q=$address")
                                )
                            )
                        } catch (e: Exception) {
                            clipboardManager.setText(AnnotatedString(address))
                            Toast
                                .makeText(
                                    context,
                                    "Адресс скопирован",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    }
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                text = address,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}