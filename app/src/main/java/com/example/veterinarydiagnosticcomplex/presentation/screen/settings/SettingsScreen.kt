package com.example.veterinarydiagnosticcomplex.presentation.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.veterinarydiagnosticcomplex.presentation.screen.settings.component.SettingsItem
import com.example.veterinarydiagnosticcomplex.presentation.screen.settings.component.SettingsSwitchItem

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    val thresholds = listOf(
        "Нижний порог температуры",
        "Верхний порог температуры",
        "Нижний порог давления",
        "Верхний порог давления",
        "Нижний порог ЧСС",
        "Верхний порог ЧСС",
        "Нижний порог частоты дыхания",
        "Верхний порог частоты дыхания"
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val checked = remember { mutableStateOf(true) }
        SettingsSwitchItem(
            text = "Включить сигнал при критических показателях",
            checked = checked.value,
            onCheckedChange = {
                checked.value = it
            }
        )
        thresholds.forEach {
            val value = remember { mutableStateOf(34) }
            SettingsItem(
                text = it,
                value = value.value,  // TODO
                onReduce = {
                    if (value.value > 0) {
                        value.value -= 1
                    }
                    // TODO
                },
                onIncrease = {
                    value.value += 1
                    // TODO
                })
        }
    }
}
