package com.example.notpad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import javax.xml.transform.Transformer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val text = findViewById<TextView>(R.id.textView)

        text.text = intent.getStringExtra("Data")

        btn.setOnClickListener {
            startActivity(Intent(this@MainActivity,MainActivity2::class.java))
        }
    }
}