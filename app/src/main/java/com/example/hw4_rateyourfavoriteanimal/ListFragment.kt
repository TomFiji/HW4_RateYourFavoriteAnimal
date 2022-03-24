package com.example.hw4_rateyourfavoriteanimal

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.media.Rating
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    lateinit var viewModel: PositionViewModel
    var position = -1
    var selectedItem = ""
    private val ANIMAL_NAMES = listOf("Dog", "Cat", "Bear", "Rabbit")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(PositionViewModel::class.java)

        view.findViewById<ImageButton>(R.id.dogButton).setOnClickListener {
            position = 0
            selectedItem = "dog"
            something()
        }

        view.findViewById<ImageButton>(R.id.catButton).setOnClickListener {
            position = 1
            selectedItem = "cat"
            something()
        }

        view.findViewById<ImageButton>(R.id.bearButton).setOnClickListener {
            position = 2
            selectedItem = "bear"
            something()
        }

        view.findViewById<ImageButton>(R.id.bunnyButton).setOnClickListener {
            position = 3
            selectedItem = "bunny"
            something()
        }


        var sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        var dog_rating = sharedPreferences?.getString(ANIMAL_NAMES[0], "-") ?: -1
//        var cat_rating = sharedPreferences.getString(ANIMAL_NAMES[1], "-")?.toInt() ?: -1
//        var bear_rating = sharedPreferences.getString(ANIMAL_NAMES[2], "-")?.toInt() ?: -1
//        var bunny_rating = sharedPreferences.getString(ANIMAL_NAMES[3], "-")?.toInt() ?: -1

        dogRatingText.text = "Your rating: $dog_rating"
//        catRatingText.text = "Your rating: $cat_rating.toString()"
//        bearRatingText.text = "Your rating: $bear_rating.toString()"
//        bunnyRatingText.text = "Your rating:  $bunny_rating.toString()"

        return view
    }

    fun something(){
        viewModel.setPosition(position)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, RatingFragment())
                .addToBackStack(null)
                .commit()
        }
        else {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.details_container, RatingFragment())
                .addToBackStack(null)
                .commit()
        }
    }

}