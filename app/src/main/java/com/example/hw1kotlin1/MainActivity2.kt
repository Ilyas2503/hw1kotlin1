package com.example.hw1kotlin1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hw1kotlin1.databinding.ActivityMain2Binding
class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val text = intent.getStringExtra(MainActivity.KEY)
        binding.enterEd.setText(text)
        binding.sendBtn.setOnClickListener {
            transition()
        }
    }

    private fun transition() {
        if (binding.enterEd.text.toString().isEmpty()) {
            Toast.makeText(this, "поле не должно быть пустым", Toast.LENGTH_SHORT).show()
        } else {
            val data = Intent().apply {
                putExtra(MainActivity.KEY, binding.enterEd.text.toString())
            }
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }
}