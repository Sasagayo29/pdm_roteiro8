package com.example.pdm_roteiro8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.pdm_roteiro8.databinding.FraseBinding
import kotlinx.coroutines.launch

class FraseFragment : Fragment() {

    private var _binding: FraseBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FraseViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FraseBinding.inflate(inflater, container, false) //[cite: 3]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch { //[cite: 3]
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) { //[cite: 3]
                viewModel.frase.collect { novaFrase -> //[cite: 3]
                    binding.fraseVisao.text = novaFrase //[cite: 3]
                }
            }
        }

        val form = FormFrase() //[cite: 3]
        binding.novaFrase.setOnClickListener { //[cite: 3]
            parentFragmentManager //[cite: 3]
                .beginTransaction() //[cite: 3]
                .replace(R.id.mainContainer, form) //[cite: 3]
                .addToBackStack(null) //[cite: 3]
                .commit() //[cite: 3]
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null //[cite: 3]
    }
}