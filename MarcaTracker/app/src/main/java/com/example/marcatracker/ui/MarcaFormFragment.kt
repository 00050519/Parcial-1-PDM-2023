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
import com.example.marcatracker.databinding.FragmentMarcasBinding
import com.example.marcatracker.ui.viewmodel.MarcaViewModel

class MarcaFormFragment : Fragment() {

    private val marcaViewModel: MarcaViewModel by activityViewModels {
        MarcaViewModel.Factory
    }

    private lateinit var binding: FragmentMarcaFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarcaFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = marcaViewModel
    }

    private fun observeStatus() {
        marcaViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MarcaViewModel.WRONG_INFORMATION) -> {
                    marcaViewModel.clearStatus()
                }
                status.equals(MarcaViewModel.MARCA_CREATED) -> {
                    marcaViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}