package com.example.contactsapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.cardview.widget.CardView
import com.example.contactsapp.R
import com.example.contactsapp.ViewModel.ContactsViewModel
import com.example.contactsapp.databinding.ActivityContactDetailsBinding
import com.squareup.picasso.Picasso

class ContactDetailsActivity : AppCompatActivity() {
//    lateinit var cvcontact:CardView
    lateinit var binding: ActivityContactDetailsBinding
    val contactViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        var name=intent.getStringExtra("name")
//        var phoneNumber=intent.getStringExtra("phone")
//        var email=intent.getStringExtra("email")
//        var imageUrl=intent.getStringExtra("image")
//
//        var intentName = findViewById<TextView>(R.id.tvname1)
//        var phone2=findViewById<TextView>(R.id.tvphone1)
//        var email2=findViewById<TextView>(R.id.tvemail1)
//        var image=findViewById<ImageView>(R.id.ivcontacts1)
//        Picasso.get()
//            .load(imageUrl)
//            .resize(80,80)
//            .centerCrop()
//            .into(image)
//        intentName.text = name
//        phone2.text=phoneNumber
//        email2.text=email
        Toast.makeText(baseContext,"These are your contact details",Toast.LENGTH_LONG).show()
    }
    override fun onResume() {
        super.onResume()
        contactViewModel.contactLiveData.observe(this, { contact ->
            if (contact != null) {
                Toast.makeText(this, contact.name, Toast.LENGTH_LONG).show()
            }
        })

    }

    }



