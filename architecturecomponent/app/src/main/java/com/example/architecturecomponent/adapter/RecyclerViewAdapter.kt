package com.example.architecturecomponent.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturecomponent.dpandprovider.SomethingDb
import com.example.architecturecomponent.databinding.RecyclerviewItemBinding

class RecyclerViewAdapter(private val click:(SomethingDb)  -> Unit, private val suka:(SomethingDb) -> Unit): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var Items: List<SomethingDb> = listOf()

    inner class MyViewHolder(itemBinding: RecyclerviewItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        private val binding = itemBinding
        fun bind (model: SomethingDb) {
            binding.apply {
                nameTask.text = model.firstText
                descriptionTask.text = model.lastText
                btnDelete.setOnClickListener {
                    click (model)
                    notifyItemRemoved(position)
                }
                btnEdit.setOnClickListener {
                    suka(model)

                }
            }
            return
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(Items[position])

    }

    override fun getItemCount(): Int {
        return Items.size
    }
    fun set(items: List<SomethingDb>){
        this.Items = listOf()
        this.Items = items
        notifyDataSetChanged()
    }

}