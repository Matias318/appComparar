package com.curso.android.app.practica.apppractica.appcomparar.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.apppractica.appcomparar.model.Texto


class MainViewModel: ViewModel() {
    private val _texto = MutableLiveData(Texto(textoF = ""))
    val texto: LiveData<Texto> get() = _texto

    fun comparar(textoA: String, textoB: String): Texto {
        val resultado = if (textoA == textoB){
           "ES IGUAL"
        } else {
            "No es igual. Vuelve a intentarlo"
        }
        return Texto(resultado)

    }
}

