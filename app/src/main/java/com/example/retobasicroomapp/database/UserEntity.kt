package com.example.retobasicroomapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USERS)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)val id_user: Int,
    @ColumnInfo(name = "user_name") val name: String
)

fun UserEntity.toUser() = User(
    id_user,
    name
)