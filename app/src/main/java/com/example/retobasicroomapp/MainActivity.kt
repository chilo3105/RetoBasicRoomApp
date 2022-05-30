package com.example.retobasicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.retobasicroomapp.database.User
import com.example.retobasicroomapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var nombre : String
        binding.btnGuardar.setOnClickListener {
            nombre = binding.etUserName.text.toString()
            binding.etUserName.setText("")
            var ultimoId : Int = 0

            mainViewModel.getUsers()
            //*******
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (usersList.isNotEmpty()) {
                    for (user in usersList) {
                        if(user.user_id > ultimoId){
                            ultimoId = user.user_id
                        }
                    }
                }
            }
            //*******
            ultimoId ++

            mainViewModel.saveUser(
                User(
                    ultimoId,
                    nombre
                )
            )


            //*****
            mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (usersList.isNotEmpty()) {
                    binding.rvUsers.adapter = MainAdapter(usersList)
                }
            }
            //*****
        }

    }
}