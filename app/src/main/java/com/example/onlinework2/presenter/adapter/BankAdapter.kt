package com.example.onlinework2.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinework2.databinding.ItemBinding
import com.example.onlinework2.domain.model.BankTransaction

class BankAdapter:ListAdapter<BankTransaction, BankAdapter.BankViewHolder>(BanlDiffutil()) {
    inner class BankViewHolder(private val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(transaction: BankTransaction) {
            binding.tvDate.text = transaction.date
            binding.textCurrency.text = transaction.currency
            binding.tvAmount.text = transaction.amount.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        return BankViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class BanlDiffutil:DiffUtil.ItemCallback<BankTransaction>() {
        override fun areItemsTheSame(oldItem: BankTransaction, newItem: BankTransaction): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: BankTransaction,
            newItem: BankTransaction,
        ): Boolean {
            return oldItem == newItem
        }

    }
}