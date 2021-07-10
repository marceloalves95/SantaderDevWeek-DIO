package br.com.santaderdevweek_dio.data.local

import br.com.santaderdevweek_dio.data.domain.Cartao
import br.com.santaderdevweek_dio.data.domain.Cliente
import br.com.santaderdevweek_dio.data.domain.Conta

/**
 * Created by RubioAlves on 27/05/2021
 */
class FakeData {

    val cliente = Cliente("Marcelo")
    val cartao = Cartao("41111111")

    fun getLocalData(): Conta = Conta("445655-4", "6552-4", "2450,80", "R$ 4.120,00", cliente, cartao)

}