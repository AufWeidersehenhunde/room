package com.example.architecturecomponent

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponent.databinding.FragmentBlankBinding
import com.example.architecturecomponent.firstscreen.BlankViewModel


class BlankFragment : Fragment() {
    private var someAdapter: RecyclerViewAdapter? = null
    private var _binding: FragmentBlankBinding? = null
    private val vui: BlankViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root

    }

    fun gotoview(){
        vui.observeAllSomething().observe(viewLifecycleOwner){
            someAdapter?.set(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        someAdapter = RecyclerViewAdapter({vui.deleteSomethingModel(it)}, {
            val bundle = bundleOf("UUID" to it.uuid)
            Navigation.findNavController(view).navigate(R.id.blankFragment3, bundle) })

            with(binding.recyclerView){
                adapter = someAdapter
                layoutManager = LinearLayoutManager (
                    context,
                    LinearLayoutManager.VERTICAL,
                false
                )
            gotoview()
        }

        binding.btnAdd.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.blankFragment2)
        }


    }


}



