package com.example.marcatracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.marcatracker.R
import com.example.marcatracker.databinding.FragmentMarcaFormBinding
import com.example.marcatracker.databinding.FragmentMarcaInfoBinding
import com.example.marcatracker.ui.viewmodel.MarcaViewModel

class MarcaInfoFragment : Fragment() {

    private val marcaViewModel: MarcaViewModel by activityViewModels {
        MarcaViewModel.Factory
    }

    private lateinit var binding: FragmentMarcaInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarcaInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = marcaViewModel
    }
}