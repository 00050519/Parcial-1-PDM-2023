package com.example.marcatracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.marcatracker.R
import com.example.marcatracker.databinding.FragmentMarcasBinding
import com.example.marcatracker.ui.viewmodel.MarcaViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MarcasFragment : Fragment() {

    private val movieViewModel: MarcaViewModel by activityViewModels {
        MarcaViewModel.Factory
    }

    private lateinit var binding: FragmentMarcasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarcasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newMarcaButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_marcasFragment_to_marcaFormFragment)
        }

    }

}