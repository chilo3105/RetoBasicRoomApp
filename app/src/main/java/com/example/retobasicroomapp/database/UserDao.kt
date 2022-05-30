package com.example.retobasicroomapp.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USERS")
    fun getUsersFromDatabase(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)
}