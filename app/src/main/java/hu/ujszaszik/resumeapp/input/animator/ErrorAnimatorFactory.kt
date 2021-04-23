package hu.ujszaszik.resumeapp.input.animator

import android.view.View

class ErrorAnimatorFactory(
    val type: ErrorAnimatorType,
    private val viewType: ErrorAnimatorViewType
) {

    fun create(view: View, layout: View? = null): ErrorAnimator {
        return if (type == ErrorAnimatorType.SHOW) {
            if (viewType == ErrorAnimatorViewType.SPINNER) getStartSpinnerAnimator(view)
            else getDefaultStartAnimator(view, layout!!)
        } else {
            if (viewType == ErrorAnimatorViewType.SPINNER) getSpinnerFinishAnimator(view)
            else getDefaultFinishAnimator(view, layout!!)
        }
    }


    private fun getDefaultStartAnimator(view: View, layout: View): ErrorAnimator {
        return InputErrorAnimator(view.context, view, layout, ErrorAnimatorType.SHOW)
    }

    private fun getStartSpinnerAnimator(view: View): ErrorAnimator {
        return SpinnerErrorAnimator(view.context, view, ErrorAnimatorType.SHOW)
    }

    private fun getDefaultFinishAnimator(view: View, layout: View): InputErrorAnimator {
        return InputErrorAnimator(view.context, view, layout, ErrorAnimatorType.HIDE)
    }

    private fun getSpinnerFinishAnimator(view: View): SpinnerErrorAnimator {
        return SpinnerErrorAnimator(view.context, view, ErrorAnimatorType.HIDE)
    }
}