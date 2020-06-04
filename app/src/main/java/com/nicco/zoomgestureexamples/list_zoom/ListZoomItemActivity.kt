package com.nicco.zoomgestureexamples.list_zoom

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicco.zoomgestureexamples.R
import kotlinx.android.synthetic.main.activity_list_zoom_item.*


class ListZoomItemActivity : AppCompatActivity() {

    private lateinit var mPhotoUris: ArrayList<String>
    private var mPhotosAdapter: PhotosAdapter? = null

    private var mGridLayoutManager1: GridLayoutManager? =
        null
    private var mGridLayoutManager2: GridLayoutManager? = null
    private var mGridLayoutManager3: GridLayoutManager? = null
    private var mCurrentLayoutManager: RecyclerView.LayoutManager? = null

    private var mScaleGestureDetector: ScaleGestureDetector? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_zoom_item)

        mGridLayoutManager1 = GridLayoutManager(this, 1)
        mGridLayoutManager2 = GridLayoutManager(this, 2)
        mGridLayoutManager3 = GridLayoutManager(this, 3)

        mPhotoUris = arrayListOf()
        mPhotoUris.add("Eai")
        mPhotoUris.add("Eai")
        mPhotoUris.add("Opa")
        mPhotoUris.add("Sim")
        mPhotoUris.add("Blz?")
        mPhotoUris.add("Sim e voce?")
        mPhotoUris.add("tambem.")

        //initialize adapter
        mPhotosAdapter = PhotosAdapter(this, mPhotoUris)

        mScaleGestureDetector = ScaleGestureDetector(this, object : SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector): Boolean {
                if (detector.currentSpan > 200 && detector.timeDelta > 200) {
                    if (detector.currentSpan - detector.previousSpan < -1) {
                        if (mCurrentLayoutManager === mGridLayoutManager1) {
                            mCurrentLayoutManager = mGridLayoutManager2
                            rv_photos.layoutManager = mGridLayoutManager2
                            return true
                        } else if (mCurrentLayoutManager === mGridLayoutManager2) {
                            mCurrentLayoutManager = mGridLayoutManager3
                            rv_photos.layoutManager = mGridLayoutManager3
                            return true
                        }
                    } else if (detector.currentSpan - detector.previousSpan > 1) {
                        if (mCurrentLayoutManager === mGridLayoutManager3) {
                            mCurrentLayoutManager = mGridLayoutManager2
                            rv_photos.layoutManager = mGridLayoutManager2
                            return true
                        } else if (mCurrentLayoutManager === mGridLayoutManager2) {
                            mCurrentLayoutManager = mGridLayoutManager1
                            rv_photos.layoutManager = mGridLayoutManager1
                            return true
                        }
                    }
                }
                return false
            }
        })

        rv_photos.setOnTouchListener(View.OnTouchListener { v, event ->
            mScaleGestureDetector!!.onTouchEvent(event)
            false
        })

        rv_photos.layoutManager = LinearLayoutManager(this)
        rv_photos.adapter = mPhotosAdapter
    }
}