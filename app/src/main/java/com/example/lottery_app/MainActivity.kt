package com.example.lottery_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //Declaring the widget
    lateinit var titleTextView:TextView
    lateinit var editTextView: EditText
    lateinit var generateButton:Button



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //Initialize the widgets
    titleTextView = findViewById(R.id.textView)
    editTextView = findViewById(R.id.editTextName)
    generateButton = findViewById(R.id.generateBtn)

      generateButton.setOnClickListener {

          var name: String = editTextView.text.toString()

      //Explicit Intents
          var i = Intent(this, second_activity::class.java)

          // Adding extra data: the username
          i.putExtra("username", name)
          startActivity(i)

      }


    }
}