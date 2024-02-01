package com.example.learningapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningapplication.interfaces.ItemOnClickListener
import com.example.learningapplication.databinding.CustomListAllQuesBinding
import com.example.learningapplication.modelClass.QuestionDataList
import com.example.learningapplication.modelClass.QuestionsData

class AllQuesRecyclerViewAdapter(var list: ArrayList<QuestionsData>, var onItemClick : ItemOnClickListener) : RecyclerView.Adapter<AllQuesRecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: CustomListAllQuesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = CustomListAllQuesBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvId.text = "Q-${list[position].serNo.toString()} "
        holder.binding.tvQues.text = list[position].ques

        holder.binding.cardView.setOnClickListener {
            onItemClick.onItemClick(position)
        }
    }
}