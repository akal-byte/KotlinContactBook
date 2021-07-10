package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rvcontacts:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayContacts()
    }

    fun displayContacts(){
        var contactsList= listOf<Contacts>(
            Contacts("Frederick Mutinda","0745678908","mutindafred@gmail.com"),
            Contacts("Michael   Okoth","07348908","okothmichael@gmail.com"),
            Contacts("Fretty Pumzi","075678908","pumzifret98@gmail.com"),
            Contacts("Patricia Musikali","07345687778","musikali980@gmail.com")
        )
rvcontacts=findViewById(R.id.rvcontacts)
    var contactsAdapter=ContactsAdapter(contactsList)
    rvcontacts.apply {
        layoutManager=LinearLayoutManager(baseContext)
        rvcontacts.adapter=contactsAdapter
    }

    }
}