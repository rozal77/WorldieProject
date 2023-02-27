package com.example.projectworldie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter = 1
        val guess = findViewById<EditText>(R.id.et_guess)
        val button = findViewById<Button>(R.id.button_main)
        val text1 = findViewById<TextView>(R.id.Guess1_val)
        val text2 = findViewById<TextView>(R.id.Guess1Check_val)
        val text3 = findViewById<TextView>(R.id.Guess2_val)
        val text4 = findViewById<TextView>(R.id.Guess2Check_val)
        val text5 = findViewById<TextView>(R.id.Guess3_val)
        val text6 = findViewById<TextView>(R.id.Guess3Check_val)
        val Right = findViewById<TextView>(R.id.RightWord)


        val wordToGuess = FourLetterWordList.FourLetterWordList.getRandomFourLetterWord()
        fun checkGuess(guess: String) : String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                }
                else if (guess[i] in wordToGuess) {
                    result += "+"
                }
                else {
                    result += "X"
                }
            }
            return result
        }

        button.setOnClickListener {
            var right = ""
            var word1 = ""
            var word2 = ""
            var word3 = ""
            if (counter == 1) {

                word1 = guess.text.toString().uppercase()
                text1.text = word1
                right = checkGuess (word1)
                text2.text = right
                counter = counter + 1
//
//              text1.apply { text=word1}
            } else if (counter == 2) {

                word2 = guess.text.toString().uppercase()
                text3.text = word2
                right = checkGuess(word2)
                text4.text = right
                counter = counter + 1
            } else if (counter == 3) {

                word3 = guess.text.toString().uppercase()
                text5.text = word3
                right = checkGuess(word3)
                text6.text = right
                counter = counter + 1
                Right.text = wordToGuess
                Toast.makeText(applicationContext,"Attempts Over!", Toast.LENGTH_LONG).show()

            }


        }
    }
}