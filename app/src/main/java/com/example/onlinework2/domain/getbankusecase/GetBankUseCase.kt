package com.example.onlinework2.domain.getbankusecase

import com.example.onlinework2.domain.model.BankAccountModel
import com.example.onlinework2.domain.model.BankTransaction
import com.example.onlinework2.domain.repository.BankRepository

class GetBankUseCase(private val repository: BankRepository) {


    suspend fun execute() : Pair<BankAccountModel, List<BankTransaction>>{
        val account = repository.getBankAccount()
        val transactions = repository.getBankTransaction()
        return Pair(account, transactions)
    }



}