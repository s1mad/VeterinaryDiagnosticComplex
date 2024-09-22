package com.example.veterinarydiagnosticcomplex.presentation.screen.pet.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Update
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.SubcomposeAsyncImage

@Composable
fun ChoosePetDialog(
    pets: List<Pet>,
    onChoose: (Pet) -> Unit,
    hideDialog: () -> Unit,
    shape: CornerBasedShape = MaterialTheme.shapes.medium
) {
    Dialog(
        onDismissRequest = { hideDialog() }
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = shape
                )
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Выбор питомца:",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(8.dp))
            pets.forEach { pet ->
                PetRow(
                    pet = pet,
                    onClick = {
                        hideDialog()
                        onChoose(pet)
                    },
                    height = 64.dp,
                    shape = shape
                )
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun PetRow(
    pet: Pet,
    onClick: () -> Unit,
    height: Dp,
    shape: CornerBasedShape
) {
    val imageUrl = mutableStateOf(pet.image)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
            .clickable {
                onClick()
            }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(height),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
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
        Text(
            text = pet.name,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

data class Pet(
    val name: String,
    val age: String,
    val image: String
)
