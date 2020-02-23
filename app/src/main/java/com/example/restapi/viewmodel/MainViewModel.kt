package com.example.restapi.viewmodel

import android.app.Application
import android.util.AndroidRuntimeException
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.restapi.data.UserRepos
import com.example.restapi.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.HttpException
import kotlin.Exception

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository = UserRepository()

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var owner: ObservableField<String> = ObservableField("")
    var reposName: ObservableField<String> = ObservableField("")

    fun getAllRepos(): LiveData<List<UserRepos>> = liveData(Dispatchers.IO) {
        try {
            val user = repository.getAllRepos(owner.get()!!)
            emit(user)
        } catch (e: HttpException) {
            emit(listOf())
        }
    }

    val getRepos: LiveData<UserRepos> = liveData(Dispatchers.IO) {
        repository.getRepos(owner.toString(), reposName.toString())
    }
}