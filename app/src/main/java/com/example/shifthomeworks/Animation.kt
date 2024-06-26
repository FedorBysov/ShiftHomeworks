package com.example.shifthomeworks

import android.content.Context
import android.transition.Scene
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce

class Animation {

    fun progressBar(root: ViewGroup, layoutId: Int, context: Context) {
        val progressBar: Scene = Scene.getSceneForLayout(root, layoutId, context)
        TransitionManager.go(progressBar)
    }

    fun povorot(view: View) {
        val springForce = SpringForce(0f)
            .setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
            .setStiffness(SpringForce.STIFFNESS_LOW)
        SpringAnimation(view, DynamicAnimation.TRANSLATION_X).apply {
            setStartVelocity(5000f)
            spring = springForce
            start()
        }
    }



}