package com.example.hw4_rateyourfavoriteanimal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.res.Configuration

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: PositionViewModel
    var position = 3
    var selectedItem = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //viewModel = ViewModelProvider(requireActivity()).get(PositionViewModel::class.java)

    fun dogButtonClick(view: View){
        position = 0
        viewModel.setPosition(position)
        selectedItem = "dog"
    }

    fun catButtonClick(view: View){
        position = 1
        viewModel.setPosition(position)
        selectedItem = "cat"
    }

    fun bearButtonClick(view: View){
        position = 2
        viewModel.setPosition(position)
        selectedItem = "bear"
    }

    fun bunnyButtonClick(view: View){
        viewModel.setPosition(position)
        selectedItem = "bunny"
    }

    supportFragmentManager.beginTransaction()
        .replace(R.id.main_container, AnimalListFragment())
        .addToBackStack(null)
        .commit()

}