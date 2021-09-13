package com.example.contactsapp.Models

import android.support.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class Note(
    @PrimaryKey(autoGenerate = true)@NonNull val noteId:Int,
    val date:String,
    val title:String,
    val body:String
)
