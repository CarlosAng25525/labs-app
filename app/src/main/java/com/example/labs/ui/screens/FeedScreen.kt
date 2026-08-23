package com.example.labs.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.labs.data.articulos
import com.example.labs.ui.components.ArticuloItem

@Composable
fun FeedScreen(modifier: Modifier = Modifier) {
    var contadorAplausos by rememberSaveable { mutableStateOf(0) }
    var busqueda by rememberSaveable { mutableStateOf("") }
    var soloLecturasCortas by rememberSaveable { mutableStateOf(false) }
    var pestañaSeleccionada by rememberSaveable { mutableStateOf("ParaTi") }

    val articulosFiltrados = articulos.filter { articulo ->
        val coincideBusqueda = articulo.titulo.contains(busqueda, ignoreCase = true) ||
                articulo.autor.contains(busqueda, ignoreCase = true)
        val coincideLecturaCorta = !soloLecturasCortas || articulo.minutos <= 5
        val coincidePestaña = when (pestañaSeleccionada) {
            "Siguiendo" -> articulo.esAutorSeguido
            "Destacados" -> articulo.esDestacado
            else -> true
        }
        coincideBusqueda && coincideLecturaCorta && coincidePestaña
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("M", fontWeight = FontWeight.Bold)
                Text("Lecturas")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                listOf("ParaTi", "Siguiendo", "Destacados").forEach { pestaña ->
                    Text(
                        text = pestaña,
                        fontWeight = if (pestañaSeleccionada == pestaña) FontWeight.Bold else FontWeight.Normal,
                        modifier = Modifier.clickable { pestañaSeleccionada = pestaña }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = busqueda,
                onValueChange = { busqueda = it },
                label = { Text("Buscar por título o autor") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Switch(checked = soloLecturasCortas, onCheckedChange = { soloLecturasCortas = it })
                Text("Solo lecturas cortas")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = { contadorAplausos++ }) {
                Text("Aplaudir · $contadorAplausos")
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (articulosFiltrados.isEmpty()) {
                Text("No se encontraron artículos. Cambia la pestaña, la búsqueda o el filtro.")
            } else {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(articulosFiltrados) { articulo ->
                        ArticuloItem(articulo)
                        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen()
}
