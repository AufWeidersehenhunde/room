package com.example.architecturecomponent.homescreen

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.architecturecomponent.R
import com.example.architecturecomponent.Screens
import com.example.architecturecomponent.adapter.RecyclerViewAdapter
import com.example.architecturecomponent.databinding.FragmentBlank3Binding
import com.example.architecturecomponent.databinding.FragmentBlankBinding
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(R.layout.fragment_blank) {
    private var someAdapter: RecyclerViewAdapter? = null
    private val viewBinding: FragmentBlankBinding by viewBinding()
    private val viewMH: HomeViewModel by viewModel()

    private fun goToView() {
        viewMH.observeAllSomething().observe(viewLifecycleOwner) {
            someAdapter?.set(it)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToView()

        someAdapter = RecyclerViewAdapter({ viewMH.deleteSomethingModel(it) }, {
            viewMH.routeToUuid(it.uuid)
        })

        with(viewBinding.recyclerView) {
            adapter = someAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )

        }
        viewBinding.sibalnahoi.setOnClickListener {
            Toast.makeText(context, "Please  вернись", Toast.LENGTH_LONG).show()
            fun onDestroy() {
                super.onDestroy();
                System.runFinalizersOnExit(true);
                System.exit(0);
            }
            onDestroy()
        }
        viewBinding.btnAdd.setOnClickListener {
            viewMH.goToAdd()
        }
    }

}



