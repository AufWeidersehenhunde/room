package com.example.architecturecomponent.editscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.architecturecomponent.R
import com.example.architecturecomponent.databinding.FragmentBlank3Binding



class EditFragment : Fragment() {
    private val viewME: EditViewModel by viewModels()
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
        val inputDat1 = arguments?.getString("firstText")
        val inputDat2 = arguments?.getString("lastText")
        val inputDat3 = arguments?.getString("UUID")

        binding.editTextName.setText(inputDat1.toString())
        binding.editTextDescription.setText(inputDat2.toString())



        super.onViewCreated(view, savedInstanceState)

        binding.checkBox.setOnClickListener {
            if (inputDat3 != null) {
                viewME.updateSomethingModel(
                    inputDat3,
                    binding.editTextName.text.toString(),
                    binding.editTextDescription.text.toString()
                )
            }
            Navigation.findNavController(view).navigate(R.id.blankFragment)
        }

    }
}

