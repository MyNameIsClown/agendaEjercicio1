package com.carrasco.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.carrasco.agenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val contacts = (1..100).map {
        Contact("Nombre $it", "Telefono $it","Email $it","https://loremflickr.com/240/320/face?lock=$it")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contact.adapter = ContactAdapter(contacts) { navigateTo(it) }
    }

    private fun navigateTo(contact: Contact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_CONTACT, contact)

        startActivity(intent)
    }
}