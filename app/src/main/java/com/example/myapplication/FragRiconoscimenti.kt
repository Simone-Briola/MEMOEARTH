package com.example.myapplication

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.navigation.Navigation

class FragRiconoscimenti : Fragment(R.layout.riconoscimenti_layout) {
    private var animator: ObjectAnimator? = null
    private var scroll_max = 0
    private var durata = 20000
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val home = view.findViewById<ImageView>(R.id.icona_home)
        val scroll_view = view.findViewById<ScrollView>(R.id.scrollView)
        val layout = view.findViewById<LinearLayout>(R.id.layout_scrollview)
        home.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        scroll_view.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) { //down=finger on screen
                animator?.pause() //freezing the animation
            } else {
                if (event.action == MotionEvent.ACTION_UP || event.action== MotionEvent.ACTION_CANCEL) { //up=finger away from screen
                  scroll_view.post {
                      scorrimento(scroll_view, scroll_view.scrollY)
                  }
                }

            }
            false //indicates if the event has been completely handled, if true the animation would stop even after the touch
        }

        scroll_view.post { //waiting for the view to be finished
            scroll_max = layout.height - scroll_view.height
            if (scroll_max > 0) { // the layout has to be higher than the view
scorrimento(scroll_view, 0)
            }
        }
    }

    private fun scorrimento(scrollView: ScrollView, posizione: Int) {
        if (scroll_max <= 0 || posizione >= scroll_max) {
            return
        }
        val distanza_rimanente=scroll_max-posizione
        val durata_rimanente=(durata.toDouble()*distanza_rimanente/scroll_max).toLong()
        animator?.cancel()
        animator = ObjectAnimator.ofInt(scrollView, "scrollY", posizione, scroll_max).apply {
            duration = durata_rimanente
            interpolator = LinearInterpolator() //keeps the scrolling speed constant
            start()
        }
    }
        override fun onDestroyView() {
            super.onDestroyView()
            animator?.cancel() //stopping the animation to prevent memory leaks
        }
}