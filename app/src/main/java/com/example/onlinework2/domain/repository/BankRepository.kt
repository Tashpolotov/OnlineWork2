package com.example.onlinework2.domain.repository

import com.example.onlinework2.domain.model.BankAccountModel
import com.example.onlinework2.domain.model.BankTransaction

interface BankRepository {

    fun getBankAccount(): BankAccountModel


    fun getBankTransaction() : List<BankTransaction>
}
