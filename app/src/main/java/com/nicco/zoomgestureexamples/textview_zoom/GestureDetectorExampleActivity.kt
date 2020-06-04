package com.nicco.zoomgestureexamples.textview_zoom

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nicco.zoomgestureexamples.R


class GestureDetectorExampleActivity : AppCompatActivity() {

    var scaleGesture: TextView? = null
    var scaleGestureDetector: ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gesture_detector_example)

        scaleGesture = findViewById(R.id.article) as TextView
        scaleGesture!!.text = "this is some text"
        scaleGestureDetector = ScaleGestureDetector(this, simpleOnScaleGestureListener(scaleGesture!!))
    }



    override fun onTouchEvent(event: MotionEvent?): Boolean {
        // TODO Auto-generated method stub
        scaleGestureDetector!!.onTouchEvent(event)
        return true
    }

    class simpleOnScaleGestureListener(val scaleGesture: TextView) : SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            var size: Float = scaleGesture.textSize
            Log.d("TextSizeStart", size.toString())
            val factor = detector.scaleFactor
            Log.d("Factor", factor.toString())
            val product = size * factor
            Log.d("TextSize", product.toString())
            scaleGesture.setTextSize(TypedValue.COMPLEX_UNIT_PX, product)
            size = scaleGesture.textSize
            Log.d("TextSizeEnd", size.toString())
            return true
        }
    }
}