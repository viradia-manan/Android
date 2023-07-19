package com.example.imagezoominout

import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    private lateinit var zoomImageView: ImageView
    private lateinit var gestureDetector: GestureDetector
    private val matrix = Matrix()
    private var scaleFactor = 1f

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zoomImageView = findViewById(R.id.zoomImageView)

        // Initialize GestureDetector
        gestureDetector = GestureDetector(this, MyGestureListener())

        // Set the onTouchListener to detect touch events
        zoomImageView.setOnTouchListener { _, event -> gestureDetector.onTouchEvent(event) }
    }

    private inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onScroll(
            e1: MotionEvent,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            // Calculate the scaling factor based on the scroll distance
            scaleFactor *= Math.pow(SCALE_FACTOR_BASE.toDouble(), -distanceY.toDouble()).toFloat()

            // Limit the scaling factor to avoid extreme zooming
            scaleFactor = scaleFactor.coerceIn(MIN_SCALE_FACTOR, MAX_SCALE_FACTOR)

            // Apply the scaling transformation to the image
            matrix.reset()
            matrix.postScale(scaleFactor, scaleFactor)

            // Apply the transformation matrix to the ImageView
            zoomImageView.imageMatrix = matrix

            return true
        }
    }

    companion object {
        // Set the minimum and maximum scale factors for zooming
        private const val MIN_SCALE_FACTOR = 0.1f
        private const val MAX_SCALE_FACTOR = 5.0f

        // Set the base scaling factor for each scroll event
        private const val SCALE_FACTOR_BASE = 1.02f
    }
}