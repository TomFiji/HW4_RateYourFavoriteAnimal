package com.example.hw4_rateyourfavoriteanimal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_rating.view.*

class RatingFragment : Fragment() {

    private val ANIMAL_NAMES = listOf("Dog", "Cat", "Bear", "Rabbit")

    lateinit var viewModel: PositionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(PositionViewModel::class.java)
        val position = viewModel.getPosition() ?: 0

        val imageID = when(position){
            0 -> R.drawable.dog
            1 -> R.drawable.cat
            2 -> R.drawable.bear
            else -> R.drawable.rabbit
        }

        view.findViewById<ImageView>(R.id.animalImage).setImageResource(imageID)
        view.findViewById<TextView>(R.id.animalText).text = ANIMAL_NAMES[position]

        return view
    }

}