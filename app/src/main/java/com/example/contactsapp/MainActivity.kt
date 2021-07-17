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
            Contacts("Frederick Mutinda","0745678908","mutindafred@gmail.com","https://cdn.pixabay.com/photo/2015/08/05/04/25/people-875617__340.jpg"),
            Contacts("Michael   Okoth","07348908","okothmichael@gmail.com","https://cdn.pixabay.com/photo/2015/03/26/09/41/tie-690084__340.jpg"),
            Contacts("Fretty Pumzi","075678908","pumzifret98@gmail.com","https://cdn.pixabay.com/photo/2015/07/17/22/43/student-849825__340.jpg"),
            Contacts("Patricia Musikali","07345687778","musikali980@gmail.com","https://cdn.pixabay.com/photo/2017/07/31/21/04/people-2561053__340.jpg")
        )
rvcontacts=findViewById(R.id.rvcontacts)
    var contactsAdapter=ContactsAdapter(contactsList,baseContext)
    rvcontacts.apply {
        layoutManager=LinearLayoutManager(baseContext)
        rvcontacts.adapter=contactsAdapter
    }

    }
}