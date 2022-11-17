package com.example.architecturecomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.architecturecomponent.databinding.FragmentBlank3Binding
import com.example.architecturecomponent.firstscreen.BlankViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch


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

        val inputDat = arguments?.getString("UUID")

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vui.planetext.filterNotNull().collect {
                    binding.editTextName.setText(it)
                }
                vui.planetextTwo.filterNotNull().collect {
                    binding.editTextDescription.setText(it)
                }
                if (inputDat != null) {
                    vui.observeSHTANI(inputDat)
                }
                vui.planetext.filterNotNull().collect {
                    binding.editTextName.setText(it)
                }
                vui.planetextTwo.filterNotNull().collect {
                    binding.editTextDescription.setText(it)
                }
            }

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
}