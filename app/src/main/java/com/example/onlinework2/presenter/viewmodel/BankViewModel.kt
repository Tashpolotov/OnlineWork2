package com.example.onlinework2.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.onlinework2.domain.getbankusecase.GetBankUseCase
import com.example.onlinework2.domain.model.BankAccountModel
import com.example.onlinework2.domain.model.BankTransaction
import com.example.onlinework2.domain.repository.BankRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BankViewModel(private val getBankUseCase: GetBankUseCase) : ViewModel() {

    val _bankState = MutableStateFlow<BankAccountModel?>(null)
    val state = _bankState.asStateFlow()

    val _bankTransactionState = MutableStateFlow<List<BankTransaction>>(emptyList())
    val stateBank = _bankTransactionState.asStateFlow()

    fun getBank() {
        GlobalScope.launch {
            val result = getBankUseCase.execute()
            _bankTransactionState.value = result.second
            _bankState.value = result.first
        }
    }
}