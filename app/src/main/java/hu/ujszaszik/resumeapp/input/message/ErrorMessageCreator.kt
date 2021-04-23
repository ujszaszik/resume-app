package hu.ujszaszik.resumeapp.input.message

import android.view.View
import hu.ujszaszik.resumeapp.input.animator.ErrorAnimatorFactory
import hu.ujszaszik.resumeapp.input.animator.ErrorAnimatorType
import hu.ujszaszik.resumeapp.input.animator.ErrorAnimatorViewType.DEFAULT
import hu.ujszaszik.resumeapp.input.animator.ErrorAnimatorViewType.SPINNER
import hu.ujszaszik.resumeapp.register.balloon.BalloonFactory
import hu.ujszaszik.resumeapp.register.balloon.BalloonType
import hu.ujszaszik.resumeapp.register.balloon.duration
import hu.ujszaszik.resumeapp.register.balloon.onCancelled

class ErrorMessageCreator private constructor(
    private val errorView: View,
    private val isSpinnerType: Boolean = false
) {
    companion object {

        private const val DEFAULT_DURATION = 3000L

        fun init(view: View): ErrorMessageCreator {
            return ErrorMessageCreator(view)
        }

        fun initForSpinner(view: View): ErrorMessageCreator {
            return ErrorMessageCreator(view, true)
        }
    }

    fun createMessage(
        view: View,
        layout: View,
        messageId: Int
    ) {
        setErrorMessage(view, layout, view.context.getString(messageId))
        val type = ErrorAnimatorType.SHOW
        val viewType = if (isSpinnerType) SPINNER else DEFAULT
        ErrorAnimatorFactory(type, viewType).create(view, layout).start()
    }

    fun createSimpleMessage(messageId: Int) {
        val errorMessage = errorView.context.getString(messageId)
        BalloonFactory(errorView.context).create(errorMessage, BalloonType.ERROR)
            .duration(DEFAULT_DURATION)
            .show(errorView)
    }

    fun createSimpleMessage(text: String) {
        BalloonFactory(errorView.context).create(text, BalloonType.ERROR)
            .duration(DEFAULT_DURATION)
            .show(errorView)
    }

    private fun setErrorMessage(view: View, layout: View, message: String) {
        BalloonFactory(view.context).create(message, BalloonType.ERROR)
            .duration(DEFAULT_DURATION)
            .onCancelled {
                val type = ErrorAnimatorType.HIDE
                val viewType = if (isSpinnerType) SPINNER else DEFAULT
                ErrorAnimatorFactory(type, viewType).create(view, layout).start()
            }
            .show(errorView)
    }

}