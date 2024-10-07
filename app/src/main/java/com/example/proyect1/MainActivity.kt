package com.example.proyect1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyect1.DAO.UserDao
import com.example.proyect1.Database.UserDatabase
import com.example.proyect1.Repository.userRepository
import com.example.proyect1.Screen.UserApp
import com.example.proyect1.ui.theme.Proyect1Theme

class MainActivity : ComponentActivity() {
    private lateinit var userDao: UserDao
    private lateinit var userRepository: userRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = UserDatabase.getDatabase(applicationContext)
        userDao = db.userDao()
        userRepository = userRepository(userDao) //Inicializa el repositorio

        enableEdgeToEdge()
        setContent {
            UserApp(userRepository)
        }
    }
}