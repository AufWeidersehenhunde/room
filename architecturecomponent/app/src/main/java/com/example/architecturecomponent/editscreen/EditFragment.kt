package com.example.architecturecomponent.editscreen


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.architecturecomponent.R
import com.example.architecturecomponent.databinding.FragmentBlank3Binding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class EditFragment : Fragment(R.layout.fragment_blank3) {
    private val viewME: EditViewModel by viewModel()
    private val viewBinding: FragmentBlank3Binding by viewBinding()

    companion object {
        private const val DATA = "UUID"
        fun getInstance(data: String) = EditFragment().apply {
            arguments = Bundle().apply {
                putString(DATA, data)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputDat3 = arguments?.getString(DATA)

        inputDat3?.let {
            viewME.getIt(it)
        }
        initObserver()


        println("${viewBinding.editTextName.text}shlyapadiravaya2")

        viewBinding.checkBox.setOnClickListener {
            if (inputDat3 != null) {
                viewME.updateSomethingModel(
                    inputDat3,
                    viewBinding.editTextName.text.toString(),
                    viewBinding.editTextDescription.text.toString()
                )
            }
            viewME.goHome()
        }

    }

    private fun initObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewME.model.collect {
                    with(viewBinding) {
                        editTextName.setText(it.firstText)
                        editTextDescription.setText(it.lastText)
                        println("${viewBinding.editTextName.text}shlyapadiravaya")
                    }
                }
            }
        }
    }
}



