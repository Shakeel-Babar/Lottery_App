package com.example.lottery_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class second_activity : AppCompatActivity() {

    //Declaring the view
    lateinit var textViewTitle:TextView
    lateinit var textGeneratedNumbers:TextView
    lateinit var shareButton:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Initialize the Views
        textViewTitle = findViewById(R.id.textView2)
        textGeneratedNumbers = findViewById(R.id.resultTextView)
        shareButton = findViewById(R.id.shareBtn)

        //Generate 6 random numbers and store them in a string
        val randomNumbers = generateRandomNumbers(6)
        textGeneratedNumbers.text = randomNumbers

        // Getting the Username from the main Activity
        var username = receiveUserName()


        // sharing the username & generated numbers with Email App
        shareButton.setOnClickListener {
            shareResult(username,randomNumbers)
        }

    }

    fun generateRandomNumbers(count:Int):String{
    //Create a list of Random numbers
        var randomNumbers = List(count){
         //lambda expression to generate random numbers
            (0..42).random()

            //val random = java.util.Random()
            //val randomNumber = random.nextInt(43)
        }
        //Covert the list of numbers to a string
        return randomNumbers.joinToString(" ")
    }


    fun receiveUserName():String{

        var bundle:Bundle? = intent.extras

        //Give me the Key, i'll give you the value
        var username = bundle?.getString("username").toString()

        return username

    }

    fun shareResult(username:String, generatedNums:String){

        //Implicit Intents
        //Sending data to another application
        var i = Intent(Intent.ACTION_VIEW)
      //  i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT, "The Lottery Numbers are: $generatedNums")
        startActivity(i)
    }





}