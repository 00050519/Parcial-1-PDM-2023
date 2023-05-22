package com.example.marcatracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.marcatracker.MarcaReviewerApplication
import com.example.marcatracker.data.model.MarcaModel
import com.example.marcatracker.data.repository.MarcaRepository

class MarcaViewModel (private val repository: MarcaRepository) : ViewModel() {

    var name = MutableLiveData("")
    var sector = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMarcas() = repository.getMarcas()

    private fun addMarcas(marca: MarcaModel) = repository.addMarcas(marca)


    fun createMarca() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val marca = MarcaModel(
            name.value!!,
            sector.value!!
        )

        addMarcas(marca)
        clearData()

        status.value = MARCA_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            sector.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        sector.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedMarca(marca: MarcaModel) {
        name.value = marca.nombre
        sector.value = marca.sector
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MarcaReviewerApplication
                MarcaViewModel(app.MarcaRepository)
            }
        }

        const val MARCA_CREATED = "Marca created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}