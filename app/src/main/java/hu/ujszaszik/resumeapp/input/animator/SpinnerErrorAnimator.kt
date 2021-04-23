package hu.ujszaszik.resumeapp.input.animator

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.VectorDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.material.textview.MaterialTextView
import com.ujszaszik.resumeapp.R
import hu.ujszaszik.resumeapp.extensions.firstChild
import hu.ujszaszik.resumeapp.extensions.secondChild

class SpinnerErrorAnimator(
    private val context: Context,
    private val view: View,
    private val type: ErrorAnimatorType
) : ErrorAnimator {

    private val defaultColor = ContextCompat.getColor(context, R.color.colorAccent)
    private val errorColor = ContextCompat.getColor(context, R.color.red)

    override fun start() {
        val currentView = view as AppCompatSpinner
        val gradientDrawable = view.background as GradientDrawable
        val errorStrokeWidth = context.resources.getInteger(R.integer.error_stroke_width)
        val animationDuration = context.resources.getInteger(R.integer.error_animation_duration)
        ValueAnimator.ofObject(ArgbEvaluator(), getStartColor(), getEndColor()).apply {
            duration = animationDuration.toLong()
            addUpdateListener {
                gradientDrawable.setStroke(errorStrokeWidth, animatedValue as Int)
                val viewGroup = (currentView.firstChild() as ViewGroup)
                val spinnerText = viewGroup.firstChild() as MaterialTextView
                spinnerText.setTextColor(animatedValue as Int)
                val spinnerArrow = viewGroup.secondChild() as ImageView
                val arrowDrawable = spinnerArrow.drawable as VectorDrawable
                var mutatedDrawable = arrowDrawable.mutate()
                mutatedDrawable = DrawableCompat.wrap(mutatedDrawable)
                DrawableCompat.setTint(mutatedDrawable, animatedValue as Int)
                DrawableCompat.setTintMode(mutatedDrawable, PorterDuff.Mode.SRC_IN)
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