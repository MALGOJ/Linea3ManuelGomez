package com.example.conceptos.screen

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.conceptos.R

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val layoutContacts = findViewById<LinearLayout>(R.id.layoutContacts)
        val btnClearContacts = findViewById<Button>(R.id.btnClearContacts)

        // Mostrar los contactos
        val contacts = ContactRepository.getContacts()

        for (contact in contacts) {
            val contactView = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
            }
            val contactText = TextView(this).apply {
                text = """
                    Nombre: ${contact.firstName}
                    Apellido: ${contact.lastName}
                    Teléfono: ${contact.phone}
                    Hobby: ${contact.hobby}
                """.trimIndent()
            }
            val btnEditContact = Button(this).apply {
                text = "Editar"
                setOnClickListener {
                    // Lógica para editar el contacto
                    val newContact = Contact(contact.firstName, contact.lastName, contact.phone, contact.hobby)
                    // Aquí puedes mostrar un diálogo o una nueva actividad para editar el contacto
                    ContactRepository.editContact(contact, newContact)
                    recreate() // Recargar la actividad para reflejar los cambios
                }
            }
            contactView.addView(contactText)
            contactView.addView(btnEditContact)
            layoutContacts.addView(contactView)
        }

        // Borrar todos los contactos
        btnClearContacts.setOnClickListener {
            ContactRepository.clearContacts()
            layoutContacts.removeAllViews() // Limpiar la vista
        }
    }
}