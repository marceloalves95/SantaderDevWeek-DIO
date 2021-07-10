package br.com.santaderdevweek_dio.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.santaderdevweek_dio.data.domain.Conta
import br.com.santaderdevweek_dio.data.local.FakeData

/**
 * Created by RubioAlves on 27/05/2021
 */
class MainViewModel :ViewModel(){

    private val mutableLiveData:MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente():LiveData<Conta>{

        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData

    }

}