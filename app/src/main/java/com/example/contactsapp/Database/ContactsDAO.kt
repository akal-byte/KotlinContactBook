package com.example.contactsapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactsapp.Models.Contacts


@Dao
interface ContactsDAO {
@Insert(onConflict = OnConflictStrategy.REPLACE)
fun insertContact(contacts: Contacts)

@Query("SELECT* FROM Contacts" )
fun getAllContacts():LiveData<List<Contacts>>

@Query("SELECT* FROM Contacts WHERE contactId=:contactId")
fun getContactById(contactId:Int):LiveData<Contacts>

//@Query("SELECT* FROM Contacts WHERE name LIKE '%:search%'")
//fun searchContact(search:String)

@Delete
fun deleteContact(contacts: Contacts)

}