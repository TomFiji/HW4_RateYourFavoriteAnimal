package com.example.hw4_rateyourfavoriteanimal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.res.Configuration
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    public val ANIMAL_NAMES = listOf("Dog", "Cat", "Bear", "Rabbit")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ListFragment())
            .addToBackStack(null)
            .commit()

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.details_container, RatingFragment())
                .addToBackStack(null)
                .commit()
        }

    }

}