package com.example.restapi.main.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.data.UserRepos
import com.example.restapi.databinding.ItemReposBinding

class MainViewHolder(val binding: ItemReposBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserRepos) {
        binding.apply {
            data = item
        }
    }
}