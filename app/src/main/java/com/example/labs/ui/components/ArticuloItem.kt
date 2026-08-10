package com.example.labs.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*   // incluye Row, Column, Box, Spacer, fillMaxSize, padding, etc.
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labs.model.Articulo

@Composable
fun ArticuloItem(articulo: Articulo, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = articulo.autor, fontSize = 12.sp)
            Text(text = articulo.titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = articulo.extracto, fontSize = 14.sp)
            Text("${articulo.minutos} min · ${articulo.fecha}", fontSize = 12.sp)
        }
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Gray)
        )
    }
}
