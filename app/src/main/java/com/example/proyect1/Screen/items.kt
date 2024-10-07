package com.example.proyect1.Screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.proyect1.Model.User
import com.example.proyect1.Repository.userRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun UserApp(userRepository: userRepository) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var apellido by rememberSaveable { mutableStateOf("") }
    var edad by rememberSaveable { mutableStateOf("") }
    var idUpdate by rememberSaveable { mutableStateOf("") }
    var idDelete by rememberSaveable { mutableStateOf("") }
    var users by rememberSaveable { mutableStateOf(emptyList<User>()) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text(text = "Apellido") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = edad,
            onValueChange = {
                if (it.toIntOrNull() in 0..100 || it.isEmpty()) {
                    edad = it
                }
            },
            label = { Text(text = "Edad") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            val user = User(
                nombre = nombre,
                apellido = apellido,
                edad = edad.toIntOrNull() ?: 0
            )
            scope.launch {
                withContext(Dispatchers.IO) {
                    userRepository.insert(user)
                }
                Toast.makeText(context, "Usuario registrado", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Registrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                scope.launch {
                    users = withContext(Dispatchers.IO) {
                        userRepository.getAllUser()
                    }
                }
            }
        ) {
            Text(text = "Listar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            users.forEach { user ->
                Text("${user.id} ${user.nombre} ${user.apellido}, Age: ${user.edad}")
                Spacer(modifier = Modifier.height(4.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = idUpdate,
            onValueChange = { idUpdate = it },
            label = { Text(text = "ID a actualizar") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            val id = idUpdate.toIntOrNull()
            if (id != null) {
                scope.launch {
                    val updatedCount: Int
                    withContext(Dispatchers.IO) {
                        updatedCount = userRepository.updateById(id, nombre, apellido, edad.toIntOrNull() ?: 0)
                    }

                    if (updatedCount > 0) {
                        Toast.makeText(context, "Usuario actualizado", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Usuario no existe", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(context, "ID invalido", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Actualizar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = idDelete,
            onValueChange = { idDelete = it },
            label = { Text(text = "ID a eliminar") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            val id = idDelete.toIntOrNull()
            if (id != null) {
                scope.launch {
                    val deletedCount: Int
                    withContext(Dispatchers.IO) {
                        deletedCount = userRepository.deleteById(id)
                    }

                    if (deletedCount > 0) {
                        Toast.makeText(context, "Usuario eliminado", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Usuario no existe", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(context, "ID invalido", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Eliminar")
        }
    }
}