package com.example.contactsapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactsapp.Models.Contacts
import com.example.contactsapp.Models.Note

interface NotesDao {
    @Dao
    interface NotesDAO {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertNotes(note: Note)

        @Query("SELECT* FROM Note")
        fun getAllNotes(): LiveData<List<Note>>

        @Query("SELECT* FROM Note WHERE noteId= :noteId")
        fun getContactById(noteId: Int): LiveData<Note>

        @Delete
        fun deleteContact(note: Note)
        abstract fun getNotesById(noteId: Int): LiveData<Note>

    }
}