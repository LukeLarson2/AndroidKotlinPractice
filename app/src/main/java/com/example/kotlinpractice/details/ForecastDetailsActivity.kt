package com.example.kotlinpractice.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.kotlinpractice.R
import com.example.kotlinpractice.formatTempForDisplay

class ForecastDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_details)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        setTitle(R.string.forecast_details)

        val tempText = findViewById<TextView>(R.id.detailsTempText)
        val descriptionText = findViewById<TextView>(R.id.detailsDescriptionText)

        val temp = formatTempForDisplay(intent.getFloatExtra("key_temp", 0f))
        val description = intent.getStringExtra("key_description")

        tempText.text = temp
        descriptionText.text = description
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.tempDisplaySetting -> {
                Toast.makeText(this, "Clicked Menu Item", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}