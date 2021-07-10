package br.com.santaderdevweek_dio.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import br.com.santaderdevweek_dio.R
import br.com.santaderdevweek_dio.data.domain.Conta
import br.com.santaderdevweek_dio.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setupViewModel()

    }

    private fun setupViewModel(){

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.buscarContaCliente().observe(this, { conta-> bind(conta) })

        //throw RuntimeException("Test Crash")

    }

    private fun bind(conta:Conta){

        val cliente = "Olá, ${conta.cliente.nome}"
        val agencia = "Ag ${conta.agencia}"
        val contaCorrente = "CC ${conta.numero}"
        val saldo = "RS ${conta.saldo}"
        val limiteCartao = "R$ ${conta.limite}"

        binding.tvUsuario.text = cliente
        binding.tvAgencia.text = agencia
        binding.tvContaCorrente.text = contaCorrente
        binding.tvSaldo.text = saldo
        binding.tvLimiteCartao.text = limiteCartao
        binding.tvNumeroCartaoFinal.text = conta.cartao.numeroConta


    }
    private fun setupNavigation(){

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){

            R.id.notification -> true
            else -> false
        }
    }


}