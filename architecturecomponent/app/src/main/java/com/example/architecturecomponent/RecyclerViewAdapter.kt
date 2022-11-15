package com.example.architecturecomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.architecturecomponent.databinding.RecyclerviewItemBinding

class RecyclerViewAdapter(private val clickListener: (Task) -> Unit): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var o4ka = ArrayList<Task>()

    fun set (items: List<Task>) {
        o4ka.clear()
        o4ka.addAll(items)
        notifyDataSetChanged()
    }


    inner class MyViewHolder(itemBinding: RecyclerviewItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        private val binding = itemBinding
        fun bind (items: Task) {
            binding.apply {
                nameTask.text = items.task
                descriptionTask.text = items.subTask
                clickListener
                btnDelete.setOnClickListener {
                    clickListener(items)
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
        holder.bind(o4ka[position])

    }

    override fun getItemCount(): Int {
        return o4ka.size
    }
    //fun removeItem(position:Int) {
       // o4ka.removeAt(position)
        //notifyItemRemoved(position)
       // notifyItemRangeChanged(position, o4ka.size)
    //}

}