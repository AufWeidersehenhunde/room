package com.example.architecturecomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.architecturecomponent.databinding.FragmentBlank2Binding
import com.example.architecturecomponent.databinding.FragmentBlankBinding


class BlankFragment2 : Fragment() {
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
        binding.btnGoToBack.setOnClickListener {
            val text1 = binding.taskName.text
            val text2 = binding.taskDescription.text
            Navigation.findNavController(view).navigate(R.id.blankFragment)
            binding.btnGoToBack.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.blankFragment)
            }
        }
    }
}




