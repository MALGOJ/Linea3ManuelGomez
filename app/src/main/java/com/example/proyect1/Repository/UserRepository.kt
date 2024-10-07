package com.example.proyect1.Repository

import com.example.proyect1.DAO.UserDao
import com.example.proyect1.Model.User

class userRepository(private val userDao: UserDao) {
    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun getAllUser(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun updateById(userId: Int, nombre: String, apellido: String, edad: Int): Int {
        return userDao.updateById(userId, nombre, apellido, edad)
    }

    suspend fun deleteById(userId: Int): Int {
        return userDao.deleteById(userId)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }
}