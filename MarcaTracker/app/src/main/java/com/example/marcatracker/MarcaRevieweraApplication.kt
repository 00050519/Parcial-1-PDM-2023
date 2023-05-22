package com.example.marcatracker

import android.app.Application
import com.example.marcatracker.data.marcas
import com.example.marcatracker.data.repository.MarcaRepository

class MarcaReviewerApplication : Application() {
    val MarcaRepository: MarcaRepository by lazy {
        MarcaRepository(marcas)
    }
}