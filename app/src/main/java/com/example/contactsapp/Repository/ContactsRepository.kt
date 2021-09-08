package com.example.contactsapp.Repository

import androidx.lifecycle.LiveData
import com.example.contactsapp.ContactsDatabase
import com.example.contactsapp.Database.ContactsBookApp
import com.example.contactsapp.Models.Contacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database=ContactsDatabase.getDatabase(ContactsBookApp.context)

    suspend fun saveContacts(contacts: Contacts){
        withContext(Dispatchers.IO){
            database.contactsDao().insertContact(contacts)
        }

    }
    fun getAllContacts():LiveData<List<Contacts>>{
        return  database.contactsDao().getAllContacts()
    }



}