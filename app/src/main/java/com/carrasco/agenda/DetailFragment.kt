package com.carrasco.agenda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.carrasco.agenda.databinding.DetailFragmentBinding

class DetailFragment : Fragment(R.layout.detail_fragment) {

    companion object{
        const val EXTRA_CONTACT = "DetailFragment:contact"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        val binding = DetailFragmentBinding.bind(view)
        val contact = arguments?.getParcelable<Contact>(EXTRA_CONTACT)

        if(contact!=null){
            binding.name.text = contact.nombre
            Glide.with(binding.root.context).load(contact.imageURL).into(binding.detailImage)
            binding.llamar.setOnClickListener(){
                val msg = "Llamando al ${contact.telefono}"

                val intentCall = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${contact.telefono}")
                }
                startActivity(intentCall)
            }
            binding.enviar.setOnClickListener(){
                val msg = "Enviando Email a ${contact.email}"

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