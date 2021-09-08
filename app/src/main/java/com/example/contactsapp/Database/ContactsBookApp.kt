package com.example.contactsapp.Database

import android.app.Application
import android.content.Context

class ContactsBookApp():Application() {
companion object{
    lateinit var context: Context
}

    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }

}