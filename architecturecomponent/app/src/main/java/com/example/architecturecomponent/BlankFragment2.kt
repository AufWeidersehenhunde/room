package com.example.architecturecomponent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import com.example.architecturecomponent.databinding.FragmentBlank2Binding
import com.example.architecturecomponent.firstscreen.BlankViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch


class BlankFragment2 : Fragment() {
    private val vui: BlankViewModel by viewModels()
    private var _binding: FragmentBlank2Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


        binding.btnAddToList.setOnClickListener {
            vui.addStaticSomethingData(
                binding.taskName.text.toString(),
                binding.taskDescription.text.toString()
            )
            Navigation.findNavController(view).navigate(R.id.blankFragment)
        }

        binding.btnGoToBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.blankFragment)
        }

    }
}




