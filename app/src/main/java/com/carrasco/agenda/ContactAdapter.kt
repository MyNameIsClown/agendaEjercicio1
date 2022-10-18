package com.carrasco.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carrasco.agenda.databinding.ViewContactItemBinding


class ContactAdapter(private val contacts : List<Contact>, private val contactClickedListener: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewContactItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
        holder.itemView.setOnClickListener {contactClickedListener(contact)}
    }

    override fun getItemCount() = contacts.size

    class ViewHolder(private val binding: ViewContactItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(contact: Contact){
            binding.nombre.text = contact.nombre
            binding.telefono.text = contact.telefono
            binding.email.text = contact.email
            binding.image.glide(contact.imageURL)
        }

    }

}