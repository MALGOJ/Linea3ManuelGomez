package com.example.conceptos.screen

object ContactRepository {
    private val contacts = mutableListOf<Contact>()

    fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    fun getContacts(): List<Contact> {
        return contacts
    }

    fun clearContacts() {
        contacts.clear()
    }
    fun editContact(oldContact: Contact, newContact: Contact) {
        val index = contacts.indexOf(oldContact)
        if (index != -1) {
            contacts[index] = newContact
        }
    }
}
