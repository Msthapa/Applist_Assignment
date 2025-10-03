package com.example.applist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.applist.R
import com.example.applist.databinding.ItemAppListBinding
import com.example.applist.model.data.AppDetailItem

class ApplistAdapter(private val onItemClick: (AppDetailItem) -> Unit):
    ListAdapter<AppDetailItem, ApplistAdapter.ApplistViewholder>(DiffCallback()) {

    inner class ApplistViewholder(val binding: ItemAppListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item : AppDetailItem) {
            val context = binding.root.context
            Glide.with(context)
              .load(item.artworkUrl100)
              .placeholder(R.drawable.ic_launcher_background)
              .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC) // for caching images
              .skipMemoryCache(false) // using memory to cache
              .into(binding.appIcon)

            binding.appName.text = buildString {
                append(context.getString(R.string.item_app_name))
                append("  ${item.name}")
            }
            binding.devName.text = buildString {
                append(context.getString(R.string.item_dev_name))
                append("  ${item.artistName}")
            }

            binding.root.setOnClickListener {
                onItemClick(item)   // click callback for fragment
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplistViewholder {
        val binding = ItemAppListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ApplistViewholder(binding)
    }

    override fun onBindViewHolder(holder: ApplistViewholder, position: Int) {
       holder.bind(getItem(position))
    }
    class DiffCallback : DiffUtil.ItemCallback<AppDetailItem>() {
        override fun areItemsTheSame(oldItem: AppDetailItem, newItem: AppDetailItem) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: AppDetailItem, newItem: AppDetailItem) = oldItem == newItem
    }
}