package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter( var contactsList:List<Contacts>):RecyclerView.Adapter <ContactsViewHolder>(){
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
          var itemView=LayoutInflater.from(parent.context).inflate(R.layout.contacts_item_list,parent,false)
          return ContactsViewHolder(itemView)
     }

     override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
          var contacts=contactsList.get(position)
          holder.tvname.text=contacts.name
          holder.tvphone.text=contacts.phoneNumber
          holder.tvemail.text=contacts.email
     }
     override fun getItemCount(): Int {
         return contactsList.size
     }
}
class ContactsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
     var tvname=itemView.findViewById<TextView>(R.id.tvname)
     var tvphone=itemView.findViewById<TextView>(R.id.tvphone)
     var tvemail=itemView.findViewById<TextView>(R.id.tvemail)
}