package com.example.myapplication.ui.theme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.myapplication.R




class homeFragment : Fragment() {

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
val immagine_pianeta=view.findViewById<ImageView>(R.id.immagine_pianeta)
        ruota(immagine_pianeta)
        immagine_pianeta.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.vaiallawebview)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onPause() {
        super.onPause()
        val immagine_pianeta=view?.findViewById<ImageView>(R.id.immagine_pianeta)
immagine_pianeta?.animate()?.cancel()  //?=null safety(if immagine_pianeta!=null) call animate
    }

    private fun ruota(immagine_pianeta: ImageView) { //function that animates the planet to make it rotate
        immagine_pianeta.animate().apply {
            rotationBy(360f)
            duration = 10000
            interpolator=android.view.animation.LinearInterpolator()//keeps the speed constant
        }.withEndAction {
            ruota(immagine_pianeta)
        }.start()
    }

    }
