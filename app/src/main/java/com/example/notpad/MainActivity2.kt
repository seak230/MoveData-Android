package com.example.notpad

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var list = mutableListOf<String>()

        val pref = this.getPreferences(0)
        val editor = pref.edit()
        val text = findViewById<EditText>(R.id.text)
        val sendbtn = findViewById<Button>(R.id.btn1)

        var inputData = pref.getString("Save", "")

        text.setText(inputData.toString())

        sendbtn.setOnClickListener {
            // 글 저장 코드
            editor.putString("Save", text.text.toString()).apply()

            // 저장한 글을 MainActivity로 넘겨줌
            val input = text.text.toString()
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("Data", input)
            startActivity(intent)

            list.add(input.toString())
            println(list)
        }

        // 완료버튼 누르면 키보드 내려가기
        text.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(text.windowToken, 0)
                true
            } else false
        }

        // 화면 전환
        findViewById<ImageButton>(R.id.imageButton).setOnClickListener {
            startActivity(Intent(this@MainActivity2,MainActivity::class.java))
        }
    }
}