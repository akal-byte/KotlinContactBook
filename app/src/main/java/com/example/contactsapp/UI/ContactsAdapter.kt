package com.example.contactsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.Models.Contacts
import com.example.contactsapp.UI.ContactDetailsActivity
import com.squareup.picasso.Picasso

class ContactsAdapter(var contactsList:List<Contacts>, var context:Context):RecyclerView.Adapter <ContactsViewHolder>(){
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
          var itemView=LayoutInflater.from(parent.context).inflate(R.layout.contacts_item_list,parent,false)
          return ContactsViewHolder(itemView)
     }

     override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
          var contacts=contactsList.get(position)
          holder.tvname.text=contacts.name
          holder.tvphone.text=contacts.phoneNumber
          holder.tvemail.text=contacts.email
          holder.cvcontact.setOnClickListener {
               var intent=Intent(context, ContactDetailsActivity::class.java)
               intent.putExtra("name",contacts.name)
               intent.putExtra("phone",contacts.phoneNumber)
               intent.putExtra("email",contacts.email)
               intent.putExtra("image",contacts.imageUrl)
               context.startActivity(intent)


          }
          Picasso.get().load(contacts.imageUrl).resize(80,80).centerCrop().into(holder.ivcontact)
     }
     override fun getItemCount(): Int {
         return contactsList.size
     }
}
class ContactsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
     var tvname=itemView.findViewById<TextView>(R.id.tvname)
     var tvphone=itemView.findViewById<TextView>(R.id.tvphone)
     var tvemail=itemView.findViewById<TextView>(R.id.tvemail)
     var ivcontact=itemView.findViewById<ImageView>(R.id.ivcontact)
     var cvcontact=itemView.findViewById<CardView>(R.id.cvcontact)
}