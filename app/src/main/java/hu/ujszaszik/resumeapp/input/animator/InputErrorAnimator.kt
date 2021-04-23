package hu.ujszaszik.resumeapp.input.animator

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import com.ujszaszik.resumeapp.R

class InputErrorAnimator(
    private val context: Context,
    private val view: View,
    private val layout: View,
    private val type: ErrorAnimatorType
) : ErrorAnimator {

    private val defaultColor = ContextCompat.getColor(context, R.color.colorAccent)
    private val errorColor = ContextCompat.getColor(context, R.color.red)

    override fun start() {
        val currentView = view as EditText
        val currentLayout = layout as TextInputLayout
        val currentIcon = layout.startIconDrawable as? VectorDrawable
        val gradientDrawable = view.background as GradientDrawable
        val errorStrokeWidth = context.resources.getInteger(R.integer.error_stroke_width)
        val animationDuration = context.resources.getInteger(R.integer.error_animation_duration)
        ValueAnimator.ofObject(ArgbEvaluator(), getStartColor(), getEndColor()).apply {
            duration = animationDuration.toLong()
            addUpdateListener {
                gradientDrawable.setStroke(errorStrokeWidth, animatedValue as Int)
                currentView.setTextColor(animatedValue as Int)
                currentLayout.setPasswordVisibilityToggleTintList(
                    ColorStateList.valueOf(animatedValue as Int)
                )
                currentLayout.defaultHintTextColor = ColorStateList.valueOf(animatedValue as Int)
                currentLayout.hintTextColor = ColorStateList.valueOf(animatedValue as Int)
                currentIcon?.setColorFilter(animatedValue as Int, PorterDuff.Mode.SRC_ATOP)
            }
            start()
        }
    }

    private fun getStartColor(): Int {
        return when (type) {
            ErrorAnimatorType.SHOW -> defaultColor
            else -> errorColor
        }
    }

    private fun getEndColor(): Int {
        return when (type) {
            ErrorAnimatorType.SHOW -> errorColor
            else -> defaultColor
        }
    }

}