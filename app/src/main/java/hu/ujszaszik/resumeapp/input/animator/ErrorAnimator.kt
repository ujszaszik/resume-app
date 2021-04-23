package hu.ujszaszik.resumeapp.input.animator

interface ErrorAnimator {

    fun start()
}

enum class ErrorAnimatorViewType {
    DEFAULT, SPINNER
}

enum class ErrorAnimatorType {
    SHOW, HIDE
}