package com.example.architecturecomponent.addscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.architecturecomponent.R
import com.example.architecturecomponent.databinding.FragmentBlank2Binding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddFragment : Fragment() {
    private val viewMA: AddViewModel by viewModel()
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
            viewMA.addStaticSomethingData(
                binding.taskName.text.toString(),
                binding.taskDescription.text.toString()
            )
            viewMA.goToBack()
        }

        binding.btnGoToBack.setOnClickListener {
           viewMA.goToBack()
        }

        }
    }





