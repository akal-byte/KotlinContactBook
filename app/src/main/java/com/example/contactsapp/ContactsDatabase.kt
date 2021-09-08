package com.example.contactsapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsapp.Database.ContactsDAO
import com.example.contactsapp.Models.Contacts

@Database(entities = arrayOf(Contacts::class),version = 1)
 abstract class ContactsDatabase():RoomDatabase() {
     abstract fun contactsDao(): ContactsDAO

     companion object{
        var database: ContactsDatabase?=null
         fun getDatabase(context: Context): ContactsDatabase {
//             if database is null(not existing) a new instance of contacts db is created else,returns the existing one
         if(database ==null){
             database =Room.databaseBuilder(context, ContactsDatabase::class.java,"contactsdb")
                 .fallbackToDestructiveMigration().build()
}
         return database as ContactsDatabase
//             typecasting using as keyword allows us to cast an existing instance to the contacts Database
         }
     }


}