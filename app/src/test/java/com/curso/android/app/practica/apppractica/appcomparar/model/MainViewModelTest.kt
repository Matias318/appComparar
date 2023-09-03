package com.curso.android.app.practica.apppractica.appcomparar.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.curso.android.app.practica.apppractica.appcomparar.view.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<Texto>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel()
        viewModel.texto.observeForever(observer)
    }

    @Test
    fun testCompararIgual() {
        val textoA = "Hello"
        val textoB = "Hello"
        val expectedTexto = Texto("ES IGUAL")

        val result = viewModel.comparar(textoA, textoB)

        assert(result == expectedTexto)
    }
}
