package com.example.hw1kotlin1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.hw1kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val intent = result.data?.getStringExtra(KEY)
                binding.enterEd.setText(intent)
            }
        }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sendBtn.setOnClickListener {
            transition()


        }
    }

    private fun transition() {
        if (binding.enterEd.text.toString().isEmpty()) {
            Toast.makeText(this, "поле не должно быть пустым", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra(KEY, binding.enterEd.text.toString())
            }
            resultLauncher.launch(intent)
        }
    }

    companion object {
        const val KEY = "key"
    }
}