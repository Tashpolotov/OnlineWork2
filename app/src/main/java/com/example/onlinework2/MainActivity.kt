package com.example.onlinework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.onlinework2.data.repository.BankRepositoryMock
import com.example.onlinework2.databinding.ActivityMainBinding
import com.example.onlinework2.domain.getbankusecase.GetBankUseCase
import com.example.onlinework2.domain.repository.BankRepository
import com.example.onlinework2.presenter.adapter.BankAdapter
import com.example.onlinework2.presenter.viewmodel.BankViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = BankAdapter()
    private val viewModel= BankViewModel(GetBankUseCase(BankRepositoryMock()))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rv.adapter = adapter

        GlobalScope.launch {

            viewModel.state.collect{

                binding.tvBalance.text = it?.balance
                binding.tvNumber.text = it?.accountNumber
                binding.tvValut.text = it?.currency
            }

        }
        viewModel.getBank()

        GlobalScope.launch {
            viewModel.stateBank.collect{
                adapter.submitList(it)
        }

        }
        viewModel.getBank()

    }
}