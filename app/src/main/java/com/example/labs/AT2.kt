package com.example.labs

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AT2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_at2)

        val buttonCloseAT2: Button = findViewById(R.id.buttonCloseAT2)
        buttonCloseAT2.setOnClickListener {
            finish()
        }
    }
}
