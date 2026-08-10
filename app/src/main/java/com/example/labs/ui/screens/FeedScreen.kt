package com.example.labs.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*   // incluye Row, Column, Box, Spacer, fillMaxSize, padding, etc.
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.labs.data.articulos
import com.example.labs.ui.components.ArticuloItem

/*
Q1: Al quitar el weight de la columna, el texto ya no ocupa todo el espacio y la miniatura empuja el contenido, dejando la pantalla desbalanceada. El weight permite que el texto se expanda correctamente.

Q2: El componente recibe un Modifier por parámetro para que el margen externo lo decida la pantalla que lo usa. Así el mismo componente puede reutilizarse en diferentes pantallas con espaciados distintos.
*/

@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        // Barra superior
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("M", fontWeight = FontWeight.Bold)
            Text("Lecturas")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Pestañas
        Row {
            Text("Para ti", fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.width(16.dp))
            Text("Siguiendo")
            Spacer(modifier = Modifier.width(16.dp))
            Text("Destacados")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Lista de artículos
        articulos.forEach {
            ArticuloItem(it)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.LightGray)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen()
}
