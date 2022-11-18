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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponent.R
import com.example.architecturecomponent.adapter.RecyclerViewAdapter
import com.example.architecturecomponent.databinding.FragmentBlankBinding


class HomeFragment : Fragment() {
    private var someAdapter: RecyclerViewAdapter? = null
    private var _binding: FragmentBlankBinding? = null
    private val viewMH: HomeViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun gotoview() {
        viewMH.observeAllSomething().observe(viewLifecycleOwner) {
            someAdapter?.set(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        someAdapter = RecyclerViewAdapter({ viewMH.deleteSomethingModel(it) }, {
            val bundle = bundleOf("firstText" to it.firstText, "lastText" to it.lastText, "UUID" to it.uuid)
            Navigation.findNavController(view).navigate(R.id.blankFragment3, bundle)
        })

        with(binding.recyclerView) {
            adapter = someAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
            gotoview()
        }
        binding.sibalnahoi.setOnClickListener {
            Toast.makeText(context , "Please  вернись", Toast.LENGTH_LONG ).show()
            fun onDestroy() {
                super.onDestroy();

                System.runFinalizersOnExit(true);
                System.exit(0);
            }
            onDestroy()
        }
        binding.btnAdd.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.blankFragment2)
        }

    }


}



