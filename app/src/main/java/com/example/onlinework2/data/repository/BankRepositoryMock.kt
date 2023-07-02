package com.example.onlinework2.data.repository

import com.example.onlinework2.domain.model.BankAccountModel
import com.example.onlinework2.domain.model.BankTransaction
import com.example.onlinework2.domain.repository.BankRepository

class BankRepositoryMock:BankRepository {
    override fun getBankAccount(): BankAccountModel {
        return BankAccountModel("asd", "asd", "1.1")
    }

    override fun getBankTransaction(): List<BankTransaction> {
        return listOf(BankTransaction("aeee", 1.1, "ayyyyyyy"))
    }
}