package com.example.ricewater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ricewater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //defining the binding above all
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Keeping the promise of late init and used binding as object.
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Binding roots all the views and view groups, it is above all of em.
        setContentView(binding.root)
        //Setting up the calculate button
        binding.button.setOnClickListener { calculateWater() }
    }

    // function for the main function of app
    private fun calculateWater() {
        //Fetching the text input from text field entered text and convert to string before, convert to double
        val stringInEditText = binding.riceInGramsEditText.text.toString()
        val riceAmount = stringInEditText.toDoubleOrNull()
        // if there is no input in the edit text then the method ends here with return.
        if (riceAmount == null) {
            binding.textView.text = ""
            return
        }
        // First here default as the smooth rice
        var waterRequired = riceAmount * 2.0
        // If the switch is on for firm rice calculation changed.
        if (binding.sw.isChecked) {
            waterRequired = riceAmount * 1.5
        }
        //Using string parameter and used the var in the string.
        binding.textView.text = getString(R.string.water_required, waterRequired.toString())
    }
}

