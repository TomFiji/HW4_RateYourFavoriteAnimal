package com.example.hw4_rateyourfavoriteanimal

//import android.R
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_rating.view.*


class RatingFragment : Fragment() {

    private val ANIMAL_NAMES = listOf("Dog", "Cat", "Bear", "Rabbit")
    private val FILE_NAME = "animals"
    private val REQUEST_CODE = 123
    var position = 0

    lateinit var viewModel: PositionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(PositionViewModel::class.java)
        position = viewModel.getPosition() ?: 0

        val imageID = when(position){
            0 -> R.drawable.dog
            1 -> R.drawable.cat
            2 -> R.drawable.bear
            else -> R.drawable.rabbit
        }

        view.findViewById<ImageView>(R.id.animalImage).setImageResource(imageID)
        view.findViewById<TextView>(R.id.animalText).text = ANIMAL_NAMES[position]

        view.findViewById<Button>(R.id.saveRatingButton).setOnClickListener {
            saveRating(view)
        }

        return view
    }

    fun saveRating(view: View){
        val myRatingBar = view.findViewById<RatingBar>(R.id.ratingBar)
        val rating = myRatingBar.rating.toString()
        val sharedPreferences = requireActivity().getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        if(editor!=null){
            editor.putString(ANIMAL_NAMES[position], rating)
            editor.apply()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, ListFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}