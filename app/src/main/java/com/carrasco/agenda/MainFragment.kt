package com.carrasco.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.utils.widget.MockView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.carrasco.agenda.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment) {
    private val contacts = (1..100).map {
        Contact(
            "Nombre $it",
            "$it$it$it$it$it$it",
            "$it@correo.com",
            "https://loremflickr.com/240/320/face?lock=$it"
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view).apply {
            contact.adapter = ContactAdapter(contacts){
                val fragment = DetailFragment()
                fragment.arguments = bundleOf(DetailFragment.EXTRA_CONTACT to it)
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container_view,fragment)
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit()
            }
        }
    }
}