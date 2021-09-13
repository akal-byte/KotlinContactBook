package com.example.contactsapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.contactsapp.Models.Contacts
import com.example.contactsapp.R
import com.example.contactsapp.ViewModel.ContactsViewModel
import com.example.contactsapp.databinding.ActivityAddContactsBinding

class AddContacts : AppCompatActivity() {
    lateinit var binding: ActivityAddContactsBinding
    val contactViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddContactsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnsavecontact.setOnClickListener {
            validateContacts()
        }
    }

    fun validateContacts() {
        binding.tilname.error=null
        binding.tilphone.error=null
        binding.tilemail.error=null



        var name = binding.tvname.text.toString()
        var phone = binding.tvphonenumber.text.toString()
        var email = binding.tvemail.text.toString()
        var error = false
        if (name != null) {
            if (name.isEmpty() || name.isBlank()) {
                error = true
                binding.tilname.error = getString(R.string.name_required)
            }
            if (phone != null) {
                if (phone.isEmpty() || phone.isBlank()) {
                    error = true
                    binding.tilphone.error = getString(R.string.phone_required)
                }
                if (email != null) {
                    if (email.isEmpty() || email.isBlank()) {
                        error = true
                        binding.tilemail.error = getString(R.string.email_required)
                    }
                }
                if(!error){
                    var contacts=Contacts(0,name,phone,email,"")
                    contactViewModel.saveContact(contacts)
                    binding.tvname.setText("")
                    binding.tvphonenumber.setText("")
                    binding.tvemail.setText("")

                }
            }

        }
    }
}