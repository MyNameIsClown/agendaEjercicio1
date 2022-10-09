package com.carrasco.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.carrasco.agenda.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CONTACT = "DetailActivity:contact"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contact = intent.getParcelableExtra<Contact>(EXTRA_CONTACT)

        if(contact!=null){
            binding.name.text = contact.nombre
            Glide.with(binding.root.context).load(contact.imageURL).into(binding.detailImage)
            binding.llamar.setOnClickListener(){
                val msg = "Llamando al ${contact.telefono}"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
            binding.enviar.setOnClickListener(){
                val msg = "Enviando Email a ${contact.email}"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }
        }
    }
}