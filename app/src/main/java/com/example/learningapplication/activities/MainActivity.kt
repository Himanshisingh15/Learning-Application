package com.example.learningapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.learningapplication.interfaces.ButtonOnSetClickListener
import com.example.learningapplication.R
import com.example.learningapplication.adapter.ButtonRecyclerViewAdapter
import com.example.learningapplication.viewModel.ViewModel
import com.example.learningapplication.databinding.ActivityMainBinding
import com.example.learningapplication.modelClass.QuestionsData
import java.io.Serializable
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var btn = ArrayList<String>()
    private lateinit var btnAdapter : ButtonRecyclerViewAdapter
    lateinit var quesIntent : Intent
    lateinit var viewModel : ViewModel

    var androidList = ArrayList<QuestionsData>()
    var kotlinList = ArrayList<QuestionsData>()
    var javaList = ArrayList<QuestionsData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, ViewModelFactory(this))[ViewModel::class.java]

        binding.recyclerBtns.layoutManager = GridLayoutManager(this, 2)

        quesIntent = Intent(this@MainActivity, AllQuestionsActivity::class.java)

        btn.add("Android")
        btn.add("Kotlin")
        btn.add("Java")

        viewModel.readAssetData().observe(this@MainActivity, Observer {
            for (i in it){
                androidList.add(i)
            }
        })
        viewModel.readKotlinAssetData().observe(this@MainActivity, Observer{
            for (i in it){
                kotlinList.add(i)
            }
        })
        viewModel.readJavaAssetData().observe(this@MainActivity, Observer{
            for (i in it){
                javaList.add(i)
            }
        })

        btnAdapter = ButtonRecyclerViewAdapter(btn, object : ButtonOnSetClickListener {
            override fun onButtonClick(position: Int) {
                if (position == 0){
                    quesIntent.putExtra("list", androidList as Serializable )
                }
                if(position == 1){
                    quesIntent.putExtra("list", kotlinList as Serializable)
                }
                if (position == 2){
                    quesIntent.putExtra("list", javaList as Serializable)
                }
                startActivity(quesIntent)
            }

        })

        binding.recyclerBtns.adapter = btnAdapter


//        clickViewModel.btnAndroid.observe(this, Observer {
//            if (it){
//                var intent = Intent(this, AllQuestionsActivity::class.java)
//                startActivity(intent)
//            }
//        })
    }
}