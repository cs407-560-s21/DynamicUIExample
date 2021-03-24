package com.example.dynamicuiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val ANIMAL_NAME_LIST = listOf("Dog", "Cat", "Bear", "Rabbit")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Iterate through each animal in the given list above
        // and dynamically display corresponding views for each of them on the screen
        for (item in ANIMAL_NAME_LIST) {
            createViewElement(item)
        }

        // Test
        //val tv = TextView(this)
        //tv.text = "Hello"
        //tv.textSize = 20f
        //View.generateViewId() // this generates an id for that view
        //findViewById<GridLayout>(R.id.grid_layout).addView(tv)

    }


    private fun createViewElement(animalName: String){

        // The second parameter is null that creates view but does not make it appear yet
        // This helps us to set in widgets in that view and then put them on the screen
        val animalView = layoutInflater.inflate(R.layout.animal, null)

        // Find the view by their ids
        val animalImage = animalView.findViewById<ImageView>(R.id.animal_image)
        val animalNameTextView = animalView.findViewById<TextView>(R.id.animal_text)
        val animalLikeCheckBox = animalView.findViewById<CheckBox>(R.id.like_or_not)

        // Set an onClickListener for each checkbox
        // if checked, show a toast message
        animalLikeCheckBox.setOnClickListener{
            if (animalLikeCheckBox.isChecked){
                Toast.makeText(this, "You like $animalName", Toast.LENGTH_SHORT).show()
            }
        }


        // Based on position, get the corresponding image id
        // This works because the name given to each image is the same as the animal names
        val imageId = resources.getIdentifier(animalName.toLowerCase(), "drawable", packageName)


        // Set the imageId and text
        animalImage.setImageResource(imageId)
        animalNameTextView.text = animalName

        // DO NOT FORGET to call addView at the end to display the above views on screen
        findViewById<GridLayout>(R.id.grid_layout).addView(animalView)
    }
}