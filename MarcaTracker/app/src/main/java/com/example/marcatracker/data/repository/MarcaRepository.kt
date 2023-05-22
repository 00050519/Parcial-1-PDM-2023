package com.example.marcatracker.data.repository

import com.example.marcatracker.data.model.MarcaModel

class MarcaRepository (private val marcas: MutableList<MarcaModel>) {

    fun getMarcas() = marcas

    fun addMarcas(marca: MarcaModel) = marcas.add(marca)

}