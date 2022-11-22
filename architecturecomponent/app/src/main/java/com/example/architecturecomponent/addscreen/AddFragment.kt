package com.example.architecturecomponent.addscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.architecturecomponent.R
import com.example.architecturecomponent.databinding.FragmentBlank2Binding
import com.example.architecturecomponent.databinding.FragmentBlank3Binding
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddFragment : Fragment(R.layout.fragment_blank2) {
    private val viewMA: AddViewModel by viewModel()
    private val viewBinding: FragmentBlank2Binding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnAddToList.setOnClickListener {
            viewMA.addStaticSomethingData(
                viewBinding.taskName.text.toString(),
                viewBinding.taskDescription.text.toString()
            )
            viewMA.goToBack()
        }

        viewBinding.btnGoToBack.setOnClickListener {
            viewMA.goToBack()
        }
    }
}





