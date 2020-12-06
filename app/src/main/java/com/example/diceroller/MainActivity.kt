package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText: TextView = findViewById(R.id.result_text)

        val clearButton: Button = findViewById(R.id.clear)
        clearButton.setOnClickListener { clearText() }

        val countUpButton: Button = findViewById(R.id.count_up)
        countUpButton.setOnClickListener { countUp( resultText.text.toString() ) }

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice(){

        val randomNumber = (1..6).random()

        result_text.text = randomNumber.toString()

        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
    }

    private fun countUp(msg: String){
        if(msg == "Hello World!"){
            result_text.text = "1"
        } else if(msg == "6"){
            result_text.text = "6"

            Toast.makeText(this, "Count cannot exceed 6",
                Toast.LENGTH_SHORT).show()

        } else {
            var number = msg.toInt()
            number = number + 1
            result_text.text = number.toString()

            Toast.makeText(this, "Increasing the Count",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearText(){
        result_text.text = "0"

        Toast.makeText(this, "Reset Successful",
            Toast.LENGTH_SHORT).show()
    }
}
