package com.example.learningapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.learningapplication.R
import com.example.learningapplication.database.SavedQuesDb
import com.example.learningapplication.databinding.ActivityShowQuestionsBinding
import com.example.learningapplication.modelClass.QuestionsData
import com.example.learningapplication.repository.DbRepository
import com.example.learningapplication.viewModel.DbViewModel
import com.example.learningapplication.viewModel.DbViewModelFactory
import com.example.learningapplication.viewModel.ViewModel
import com.squareup.picasso.Picasso

class ShowQuestionsActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowQuestionsBinding
    lateinit var dbViewModel: DbViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_questions)

        var quesDao = SavedQuesDb.getInstance(this).savedQuesDao
        dbViewModel = ViewModelProvider(this, DbViewModelFactory(DbRepository(quesDao)))[DbViewModel::class.java]

        var check = intent.getBooleanExtra("check", false)
        showQuesAns(check)
    }

    fun showQuesAns(check : Boolean){
        var listData = intent.getSerializableExtra("question") as QuestionsData
        binding.tvQues.text = "Q.${listData.serNo}- ${listData.ques}"
        binding.tvAns.text = "Ans. - ${listData.ans}"

        binding.tvUrl.text = listData.url
        binding.tvUrl.setOnClickListener {
            var webIntent = Intent(this@ShowQuestionsActivity, WebViewActivity::class.java)
            webIntent.putExtra("url",listData.url)
            startActivity(webIntent)
        }
        if (listData.imgUrl.isNullOrEmpty()){
            binding.tvImg.visibility = View.INVISIBLE
        }else{
            Picasso.get().load("${listData.imgUrl}").into(binding.tvImg)
        }
    }
}
