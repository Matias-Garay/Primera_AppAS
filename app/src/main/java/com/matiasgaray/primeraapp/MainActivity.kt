package com.matiasgaray.primeraapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matiasgaray.primeraapp.ui.theme.PrimeraAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeraAppTheme {
                PrimeraApp()
            }
        }
    }

    @Composable
    fun PrimeraApp() {
        var entrada by remember { mutableStateOf("") }
        var etiqueta by remember { mutableStateOf("") }

        MaterialTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Etiqueta(text = etiqueta)
                    Entrada(value = entrada, onValueChange = { entrada = it })
                    Boton(onClick = {
                        etiqueta = entrada
                        entrada = ""
                    })
                }
            }
        }
    }

    @Composable
    fun Etiqueta(text: String) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }

    @Composable
    fun Entrada(value: String, onValueChange: (String) -> Unit) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = "Ingrese un texto") },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun Boton(onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Cambiar Etiqueta")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PrimeraAppPreview() {
        PrimeraApp()
    }
}



