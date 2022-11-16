package com.example.architecturecomponent

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import com.example.architecturecomponent.databinding.FragmentBlank2Binding
import com.example.architecturecomponent.databinding.FragmentBlank3Binding
import com.example.architecturecomponent.firstscreen.BlankViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.io.Closeable

class BlankFragment3 : Fragment() {
    private val vui: BlankViewModel by viewModels()
    private var _binding: FragmentBlank3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkBox.setOnClickListener {
            vui.updateSomethingModel(
                binding.editTextName.text.toString(),
                binding.editTextDescription.text.toString()
            )
            Navigation.findNavController(view).navigate(R.id.blankFragment)
        }


    }
}