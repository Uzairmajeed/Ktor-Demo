package com.facebook.ktor_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var textView1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1=findViewById(R.id.textView1)
        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.fetchFromModel()
        }
        viewModel.postLiveData.observe(this) { post ->
            if (post != null) {
                // Update your TextView with the data from the Post
                textView1.text = "UserId : ${post.userId}\n ID : ${post.id}\n" +
                                 "Title : ${post.title}\n Body : ${post.body}"
            } else {
                textView1.text = "Nothing here.."
            }
        }
    }
}

