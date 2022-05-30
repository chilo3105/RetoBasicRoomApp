package com.example.retobasicroomapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retobasicroomapp.database.DatabaseManager
import com.example.retobasicroomapp.database.MyCoroutines
import com.example.retobasicroomapp.database.User
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {

    val savedUsers = MutableLiveData<List<User>>()


    fun saveUser(user: User){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
        }
    }

    fun getUsers(){
        viewModelScope.launch{
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines(userDao).getUsers().value
        }
    }

}