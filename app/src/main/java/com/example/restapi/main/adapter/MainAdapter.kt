package com.example.restapi.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.R
import com.example.restapi.repository.data.UserRepos
import com.example.restapi.main.viewholder.MainViewHolder

class MainAdapter(private val onClick: (UserRepos) -> Unit) : RecyclerView.Adapter<MainViewHolder>() {
    private var repositories: List<UserRepos> = listOf()

    fun getAll(repositories: List<UserRepos>) {
        this.repositories = repositories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val viewHolder = MainViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_repos, parent, false))

        viewHolder.itemView.setOnClickListener {
            onClick(repositories[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(repositories[position])
    }

}