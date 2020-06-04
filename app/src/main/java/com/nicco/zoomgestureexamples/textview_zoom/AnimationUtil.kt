package com.nicco.zoomgestureexamples.textview_zoom

import android.view.View
import android.view.animation.DecelerateInterpolator

object AnimationUtil {
    fun fadeIn(vararg views: View, duration: Long = 2000L) {
        views.forEach {
            it.animate().alpha(1F).setDuration(duration).setInterpolator(DecelerateInterpolator()).start()
        }
    }

    fun fadeOut(vararg views: View, duration: Long = 2000L) {
        views.forEach {
            it.animate().alpha(0F).setDuration(duration).setInterpolator(DecelerateInterpolator()).start()
        }
    }
}