package com.example.learningapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapplication.interfaces.ButtonOnSetClickListener
import com.example.learningapplication.databinding.CustomButtomListBinding

class ButtonRecyclerViewAdapter(var list : ArrayList<String>, var onBtnClick : ButtonOnSetClickListener) : RecyclerView.Adapter<ButtonRecyclerViewAdapter.MyViewHolder>()  {

    inner class MyViewHolder(var binding : CustomButtomListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = CustomButtomListBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.recyclerBtn.text = list[position]

        holder.binding.recyclerBtn.setOnClickListener {
            onBtnClick.onButtonClick(position)
        }
    }
}