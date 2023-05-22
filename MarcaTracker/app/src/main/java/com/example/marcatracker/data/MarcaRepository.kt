package com.example.marcatracker.data

class MarcaRepository (private val marcas: MutableList<MarcaModel>) {

    fun getMarcas() = marcas

    fun addMarcas(marca: MarcaModel) = marcas.add(marca)
    
}