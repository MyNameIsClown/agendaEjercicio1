package com.carrasco.agenda

import android.content.Intent
import android.net.Uri
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

                val intentCall = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${contact.telefono}")
                }
                startActivity(intentCall)
            }
            binding.enviar.setOnClickListener(){
                val msg = "Enviando Email a ${contact.email}"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

                val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, contact.email)
                    putExtra(Intent.EXTRA_SUBJECT, "Correo para ${contact.nombre}")
                    putExtra(Intent.EXTRA_TEXT, "Texto del correo para ${contact.nombre}")
                }
                startActivity(intentEmail)
            }
        }
    }
}