package com.example.architecturecomponent.editscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import com.example.architecturecomponent.R
import com.example.architecturecomponent.databinding.FragmentBlank3Binding
import com.example.architecturecomponent.homescreen.HomeFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class EditFragment : Fragment() {
    private val viewME: EditViewModel by viewModel()
    private var _binding: FragmentBlank3Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        private const val DATA = "UUID"
        fun getInstance(data: String) = EditFragment().apply {
            arguments = Bundle().apply {
                putString(DATA, data)
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val inputDat3 = arguments?.getString(DATA)

        if (inputDat3 != null) {
            viewME.getIt(inputDat3)
        }
        viewLifecycleOwner.lifecycle
        lifecycleScope.launch {
            viewME.model.filterNotNull().collect {
                binding.editTextName.setText(it.firstText)
                binding.editTextDescription.setText(it.lastText)
            }
        }



        super.onViewCreated(view, savedInstanceState)

        binding.checkBox.setOnClickListener {
            if (inputDat3 != null) {
                viewME.updateSomethingModel(
                    inputDat3,
                    binding.editTextName.text.toString(),
                    binding.editTextDescription.text.toString()
                )
            }
            viewME.goHome()
        }

    }
}

