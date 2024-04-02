package com.example.labs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AT1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_at1)

        val buttonOpenAT2: Button = findViewById(R.id.buttonOpenAT2)
        buttonOpenAT2.setOnClickListener {
            val intent = Intent(this, AT2::class.java)
            startActivity(intent)
        }
    }
}
