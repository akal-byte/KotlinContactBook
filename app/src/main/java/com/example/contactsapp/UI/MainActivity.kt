package com.example.contactsapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.Models.Contacts
import com.example.contactsapp.ContactsAdapter
import com.example.contactsapp.R
import com.example.contactsapp.ViewModel.ContactsViewModel
import com.example.contactsapp.databinding.ActivityAddContactsBinding
import com.example.contactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactViewModel.getContactById(2)
    }

    fun displayContacts(contactsList: List<Contacts>){
     binding.rvcontacts
    var contactsAdapter= ContactsAdapter(contactsList,baseContext)
    binding.rvcontacts.apply {
        layoutManager=LinearLayoutManager(baseContext)
      binding.rvcontacts.adapter=contactsAdapter
    }
    }
    override fun onResume() {
        super.onResume()
        contactViewModel.contactLiveData.observe(this, {contact->
            if (contact!=null){
                Toast.makeText(this, contact.name, Toast.LENGTH_LONG).
                show()
            }
        })
        binding.fabaddcontact.setOnClickListener {
            startActivity(Intent(this,AddContacts::class.java))
        }

    }

    }


