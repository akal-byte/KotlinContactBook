package com.example.contactsapp.Models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contacts(
    @PrimaryKey(autoGenerate = true) @NonNull var contactId: Int,
    var name: String,
    var phoneNumber: String,
    var email: String,
    var imageUrl: String?
)