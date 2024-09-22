package com.example.veterinarydiagnosticcomplex.presentation.screen.pet

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Update
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.veterinarydiagnosticcomplex.presentation.screen.pet.component.BasePetParamRow
import com.example.veterinarydiagnosticcomplex.presentation.screen.pet.component.ChoosePetDialog
import com.example.veterinarydiagnosticcomplex.presentation.screen.pet.component.Pet

@SuppressLint("UnrememberedMutableState")
@Composable
fun PetScreen(
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = MaterialTheme.shapes.medium,
) {
    val showChoosePetDialog = rememberSaveable { mutableStateOf(false) }

    // TODO Получение pet с сервака
    val pet = Pet(
        name = "Клара",
        age = "7 лет",
        image = "https://steamuserimages-a.akamaihd.net/ugc/2032845877293949799/81EDE9BC0CC7E42BE420CEEB5E300805779E3D15/?imw=512&&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=false"
    )

    val imageUrl = mutableStateOf(pet.image)
    val name = pet.name
    val age = pet.age

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            SubcomposeAsyncImage(
                model = imageUrl.value,
                contentDescription = "pet image",
                loading = { CircularProgressIndicator() },
                error = {
                    IconButton(
                        onClick = {
                            imageUrl.value = pet.image
                        }) {
                        Icon(
                            imageVector = Icons.Rounded.Update,
                            contentDescription = "Try again"
                        )
                    }
                },
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(shape)
                    .fillMaxHeight()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(50f)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(MaterialTheme.colorScheme.tertiary),
                            shape = shape
                        )
                        .padding(16.dp),
                    text = name,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(50f)
                        .border(
                            width = 1.dp,
                            brush = SolidColor(MaterialTheme.colorScheme.tertiary),
                            shape = shape
                        )
                        .padding(16.dp),
                    text = age,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        Text(
            text = "Основные показатели:",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyLarge
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = shape
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // TODO Получение данных
            BasePetParamRow("Температура:", "12.12")
            BasePetParamRow("Давление:", "12.13")
            BasePetParamRow("ЧСС:", "12.14")
            BasePetParamRow("Частота дыхания:", "12.15")
        }
        Spacer(Modifier.weight(1f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = shape,
            onClick = {
                showChoosePetDialog.value = true
            }
        ) {
            Text(text = "Изменить питомца", style = MaterialTheme.typography.titleLarge)
        }
    }

    if (showChoosePetDialog.value) {
        ChoosePetDialog(
            pets = listOf(
                pet, pet, pet, pet, pet
            ),
            onChoose = {
                // TODO Выбор pet
            },
            hideDialog = {
                showChoosePetDialog.value = false
            }
        )
    }
}
