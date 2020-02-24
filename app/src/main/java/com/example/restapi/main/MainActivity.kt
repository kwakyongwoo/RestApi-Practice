package com.example.restapi.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.R
import com.example.restapi.repository.data.UserRepos
import com.example.restapi.databinding.ActivityMainBinding
import com.example.restapi.main.adapter.MainAdapter
import com.example.restapi.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding?.lifecycleOwner = this

        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding?.viewmodel = vm

        val adapter = MainAdapter { repos -> onClick(repos) }

        binding?.mainRcvInfo?.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
//            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }

        binding?.mainBtnSearch?.setOnClickListener {
            vm.getAllRepos().observe(this, Observer { items ->
                adapter.getAll(items)
            })
        }
    }

    private fun onClick(repos: UserRepos) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(repos.url)))
    }
}
