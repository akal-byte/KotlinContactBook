package com.example.contactsapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.Models.Contacts
import com.example.contactsapp.Repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel():ViewModel(){
    var contactsRepository = ContactsRepository()
    lateinit var contactLiveData: LiveData<Contacts>

    fun getContactById(contactId: Int) {
        contactLiveData = contactsRepository.getContactById(contactId)
    }

    fun saveContact(contacts: Contacts) {
      viewModelScope.launch {
          contactsRepository.saveContacts(contacts)
      }
    }
    fun getAllContacts(){

    }


}