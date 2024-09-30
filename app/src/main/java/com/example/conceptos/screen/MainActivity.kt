package com.example.conceptos.screen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.conceptos.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etHobby = findViewById<EditText>(R.id.etHobby)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnViewContacts = findViewById<Button>(R.id.btnViewContacts)

        btnRegister.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val phone = etPhone.text.toString()
            val hobby = etHobby.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && phone.isNotEmpty() && hobby.isNotEmpty()) {
                val contact = Contact(firstName, lastName, phone, hobby)
                ContactRepository.addContact(contact)
                Toast.makeText(this, "Contacto guardado", Toast.LENGTH_SHORT).show()

                // Limpiar los campos después de guardar
                etFirstName.text.clear()
                etLastName.text.clear()
                etPhone.text.clear()
                etHobby.text.clear()
            } else {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }

        btnViewContacts.setOnClickListener {
            val intent = Intent(this, ContactListActivity::class.java)
            startActivity(intent)
        }
    }
}