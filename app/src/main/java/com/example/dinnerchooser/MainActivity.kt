package com.example.dinnerchooser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Pizza", "Mexican", "Chinese", "Indian")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decideButton.setOnClickListener{
            val rand = Random
            val randomIndex = rand.nextInt(foodList.count())
            selected_food_text.text = foodList[randomIndex]

        }

        addFoodText.setOnKeyListener(View.OnKeyListener{ v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                val newFood = addFoodText.text.toString()
                if(newFood != "") {
                    foodList.add(newFood)
                    addFoodText.text.clear()
                }
                return@OnKeyListener true
            }
            false
        })
        addFoodButton.setOnClickListener {
            val newFood = addFoodText.text.toString()
            foodList.add(newFood)
            addFoodText.text.clear()
        }
    }
}
