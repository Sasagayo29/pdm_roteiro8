package com.example.pdm_roteiro8

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FraseViewModel : ViewModel() {
    private val _frase = MutableStateFlow<String>("inicial")
    val frase: StateFlow<String> get() = _frase

    fun preencher(novaFrase: String) {
        _frase.value = novaFrase
    }

    fun limpar() {
        _frase.value = ""
    }
}