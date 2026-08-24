package com.example.labs.model

data class Articulo(
    val autor: String,
    val titulo: String,
    val extracto: String,
    val minutos: Int,
    val fecha: String,
    val esAutorSeguido: Boolean,
    val esDestacado: Boolean
)
