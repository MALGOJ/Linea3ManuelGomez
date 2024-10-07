package com.example.proyect1.DAO

import androidx.room.*
import com.example.proyect1.Model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("DELETE FROM users WHERE id = :userId")
    suspend fun deleteById(userId: Int): Int

    @Query("UPDATE users SET nombre = :nombre, apellido = :apellido, edad = :edad WHERE id = :userId")
    suspend fun updateById(userId: Int, nombre: String, apellido: String, edad: Int): Int

    @Delete
    suspend fun delete(user: User)
}