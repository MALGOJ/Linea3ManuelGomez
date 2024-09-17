package com.example.myapplication.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// MANUEL ALEJANDRO GOMEZ JIMENEZ
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ResistanceCalculator() {
    val context = LocalContext.current

    var band1 by remember { mutableStateOf<String?>(null) }
    var band2 by remember { mutableStateOf<String?>(null) }
    var multiplier by remember { mutableStateOf<String?>(null) }
    var tolerance by remember { mutableStateOf<String?>(null) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BandDropdown(
            label = "1.ª banda de color",
            options = listOf("Negro - 0", "Marrón - 1", "Rojo - 2", "Naranja - 3", "Amarillo - 4", "Verde - 5", "Azul - 6", "Violeta - 7", "Gris - 8", "Blanco - 9"),
            selectedValue = band1,
            onSelectedChange = { band1 = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        BandDropdown(
            label = "2.ª banda de color",
            options = listOf("Negro - 0", "Marrón - 1", "Rojo - 2", "Naranja - 3", "Amarillo - 4", "Verde - 5", "Azul - 6", "Violeta - 7", "Gris - 8", "Blanco - 9"),
            selectedValue = band2,
            onSelectedChange = { band2 = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        BandDropdown(
            label = "Multiplicador",
            options = listOf("Negro - x1", "Marrón - x10", "Rojo - x100", "Naranja - x1k", "Amarillo - x10k", "Verde - x100k", "Azul - x1M", "Violeta - x10M", "Gris - x100M", "Blanco - x1G"),
            selectedValue = multiplier,
            onSelectedChange = { multiplier = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        BandDropdown(
            label = "Tolerancia",
            options = listOf("Marrón ±1%", "Rojo ±2%", "Verde ±0.5%", "Azul ±0.25%", "Violeta ±0.1%", "Gris ±0.05%", "Oro ±5%", "Plata ±10%"),
            selectedValue = tolerance,
            onSelectedChange = { tolerance = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (band1 != null && band2 != null && multiplier != null && tolerance != null) {
                val resistanceValue = calculateResistance(band1!!, band2!!, multiplier!!, tolerance!!)
                result = resistanceValue
                Toast.makeText(context, "Resistencia calculada: $resistanceValue", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Por favor seleccione todos los parámetros", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = result,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(16.dp)
                .fillMaxWidth()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BandDropdown(label: String, options: List<String>, selectedValue: String?, onSelectedChange: (String) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded }
    ) {

        TextField(
            value = selectedValue ?: "Seleccione un color",
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(isExpanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
            modifier = Modifier.fillMaxWidth().menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectedChange(option)
                        isExpanded = false
                    }
                )
            }
        }
    }
}

fun calculateResistance(band1: String, band2: String, multiplier: String, tolerance: String): String {
    val value1 = band1.split(" - ")[1].toInt()
    val value2 = band2.split(" - ")[1].toInt()
    val multiplierValue = when (multiplier) {
        "Negro - x1" -> 1
        "Marrón - x10" -> 10
        "Rojo - x100" -> 100
        "Naranja - x1k" -> 1000
        "Amarillo - x10k" -> 10000
        "Verde - x100k" -> 100000
        "Azul - x1M" -> 1000000
        "Violeta - x10M" -> 10000000
        "Gris - x100M" -> 100000000
        "Blanco - x1G" -> 1000000000
        else -> 1
    }
    val resistance = (value1 * 10 + value2) * multiplierValue
    return "$resistance ohms, Tolerancia: $tolerance"
}
