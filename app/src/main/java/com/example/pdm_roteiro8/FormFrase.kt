package com.example.pdm_roteiro8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pdm_roteiro8.databinding.FraseFormBinding

class FormFrase : Fragment() {
    private val viewModel: FraseViewModel by activityViewModels() //[cite: 3]
    private var _binding: FraseFormBinding? = null //[cite: 3]
    private val binding get() = _binding!! //[cite: 3]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FraseFormBinding.inflate(inflater, container, false) //[cite: 3]
        return binding.root //[cite: 3]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) //[cite: 3]

        binding.salvarFrase.setOnClickListener { //[cite: 3]
            viewModel.preencher(binding.fraseInput.text.toString()) //[cite: 3]
            parentFragmentManager.popBackStack() //[cite: 3]
        }

        binding.backBtn.setOnClickListener { //[cite: 3]
            parentFragmentManager.popBackStack() //[cite: 3]
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}