package com.example.applist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applist.databinding.ItemAppListBinding

class ApplistAdapter: RecyclerView.Adapter<ApplistAdapter.ApplistViewholder>() {

    inner class ApplistViewholder(val binding: ItemAppListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplistViewholder {
        val binding = ItemAppListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false // Attach to root is typically false for RecyclerView items
        )
        return ApplistViewholder(binding)
    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: ApplistViewholder, position: Int) {
       holder.binding.apply {

       }
    }
}