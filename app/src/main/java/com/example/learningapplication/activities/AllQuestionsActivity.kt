package com.example.learningapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learningapplication.R
import com.example.learningapplication.adapter.AllQuesRecyclerViewAdapter
import com.example.learningapplication.databinding.ActivityAllQuestionsBinding
import com.example.learningapplication.interfaces.ItemOnClickListener
import com.example.learningapplication.modelClass.QuestionsData
import com.example.learningapplication.viewModel.ViewModel
import java.io.Serializable

class AllQuestionsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAllQuestionsBinding
    private lateinit var adapter : AllQuesRecyclerViewAdapter
    lateinit var showAnsIntent : Intent
    lateinit var viewModel : ViewModel
    var dataList = ArrayList<QuestionsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_questions)
        viewModel = ViewModelProvider(this, ViewModelFactory(this))[ViewModel::class.java]

        binding.recyclerAllQuesList.layoutManager = LinearLayoutManager(this)

        dataList  =intent.getSerializableExtra("list") as ArrayList<QuestionsData>

        adapter = AllQuesRecyclerViewAdapter(dataList, object : ItemOnClickListener{
            override fun onItemClick(position: Int) {
                showAnsIntent = Intent(this@AllQuestionsActivity, ShowQuestionsActivity::class.java)
                showAnsIntent.putExtra("question", dataList[position] as Serializable)
                showAnsIntent.putExtra("check", false)
                startActivity(showAnsIntent)

            //               quesData(list[position].ques, list[position].ans, list[position].url, list[position].imgUrl)
            }
        })
            binding.recyclerAllQuesList.adapter = adapter
    }

//    fun quesData(question : String, answer : String, url : String, image : String?){
//        showAnsIntent = Intent(this@AllQuestionsActivity, ShowQuestionsActivity::class.java)
//        showAnsIntent.putExtra("question", question)
//        showAnsIntent.putExtra("answer", answer)
//        showAnsIntent.putExtra("image_url", image)
//        showAnsIntent.putExtra("read_more_url", url)
//        startActivity(showAnsIntent)
//    }

}