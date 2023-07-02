package com.example.onlinework2.domain.model

data class BankAccountModel (
    val accountNumber: String,
    val currency: String,
    val balance: String

        )

data class BankTransaction(
    val date: String,
    val amount: Double,
    val currency: String,
)

