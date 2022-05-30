package com.example.retobasicroomapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retobasicroomapp.database.User
import com.example.retobasicroomapp.databinding.ItemUserBinding


class MainAdapter(private val usuarios: List<User>): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(usuarios[position])
    }

    override fun getItemCount(): Int {

        return usuarios.size
    }

    class MainHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun render(usuario: User) {
            //TODDO assign text and image values in render function
            binding.tvNombre.setText("" + usuario.user_id + " " + usuario.user_name)
            binding.ivImagen.setImageResource(R.drawable.icon_person)
        }
    }
}