package hu.ujszaszik.resumeapp.login

import android.animation.ArgbEvaluator
import android.animation.TimeAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import com.ujszaszik.resumeapp.R
import javax.inject.Inject

class GradientAnimator @Inject constructor(private val context: Context) {

    lateinit var gradient: GradientDrawable

    fun start(button: Button) {
        gradient = button.background as GradientDrawable
        val start = gradient.colors?.get(0)
        val end = gradient.colors?.get(1)
        val animator = getAnimator()
        animator.addUpdateListener { getListener(it, start, end) }
        animator.start()
    }

    private fun getAnimator(): ValueAnimator {
        return TimeAnimator.ofFloat(0.0f, 1.0f).apply {
            duration = context.resources.getInteger(R.integer.button_animation_duration).toLong()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }
    }

    private fun getListener(
        valueAnimator: ValueAnimator,
        start: Int?,
        end: Int?,
    ): ValueAnimator.AnimatorUpdateListener {
        return ValueAnimator.AnimatorUpdateListener {
            val evaluator = ArgbEvaluator()
            val fraction = valueAnimator.animatedFraction
            val newStart = evaluator.evaluate(fraction, start, end) as Int
            val newEnd = evaluator.evaluate(fraction, end, start) as Int
            gradient.colors = intArrayOf(newStart, newEnd)
        }
    }

}