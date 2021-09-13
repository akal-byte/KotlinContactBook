package com.example.contactsapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.Models.Note
import com.example.contactsapp.Repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel():ViewModel() {
    var notesRepository=NotesRepository()

     fun saveNote(note: Note){
         viewModelScope.launch {
             notesRepository.saveNote(note)
         }
     }
}