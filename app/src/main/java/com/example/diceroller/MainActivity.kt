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
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()
        val diceImage: ImageView =findViewById(R.id.imageView)
        if(diceRoll==1) {
            diceImage.setImageResource(R.drawable.dice_1)
        }
        else if(diceRoll==2){
            diceImage.setImageResource(R.drawable.dice_2)
        }
        else if(diceRoll==3){
            diceImage.setImageResource(R.drawable.dice_3)
        }
        else if(diceRoll==4){
            diceImage.setImageResource(R.drawable.dice_4)
        }
        else if(diceRoll==5){
            diceImage.setImageResource(R.drawable.dice_5)
        }
        else{
            diceImage.setImageResource(R.drawable.dice_6)
        }
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}