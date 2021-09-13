package com.example.contactsapp.Repository

import androidx.lifecycle.LiveData
import com.example.contactsapp.ContactsDatabase
import com.example.contactsapp.Database.ContactsBookApp
import com.example.contactsapp.Models.Contacts
import com.example.contactsapp.Models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesRepository {
    val database= ContactsDatabase.getDatabase(ContactsBookApp.context)

    suspend fun saveNotes(note:Note){
        withContext(Dispatchers.IO){
            database.notesDao().insertNotes(note)
        }
//        uses with context and dispatchers with io to switch
    }
    fun getAllNotes(): LiveData<List<Note>> {
        return  database.notesDao().getAllNotes()
    }
     suspend fun getNotesById(noteId: Int): LiveData<Note> {
        return database.notesDao().getNotesById(noteId)
    }
}