package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    private var clickCount = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"

            rollDice()
            clickCount++;
        }

        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"

            rollDice()
            clickCount++;
        }
        if(clickCount == 6){
            //disbale player2 buttotn.setEnabled(false)
            //diable player2

            //calcWinner(player1Score, player2Score)

        }
    }

    fun calcWinner(){

        //winner calculated
        showWinnerPopUp(winner);

    }

    fun showWinnerPopUp(int winner){
        //pop
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice1 = Dice(6)
        val diceRoll = dice1.roll()
        var sum1=0
        var sum2=0
        // Update the screen with the dice roll
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
        val diceImage: ImageView =findViewById(R.id.imageView)
        for (chance in 1..3){
            if (diceRoll == 1) {
                diceImage.setImageResource(R.drawable.dice_1)
            } else if (diceRoll == 2) {
                diceImage.setImageResource(R.drawable.dice_2)
            } else if (diceRoll == 3) {
                diceImage.setImageResource(R.drawable.dice_3)
            } else if (diceRoll == 4) {
                diceImage.setImageResource(R.drawable.dice_4)
            } else if (diceRoll == 5) {
                diceImage.setImageResource(R.drawable.dice_5)
            } else {
                diceImage.setImageResource(R.drawable.dice_6)
            }
            sum1 += diceRoll
        }
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}