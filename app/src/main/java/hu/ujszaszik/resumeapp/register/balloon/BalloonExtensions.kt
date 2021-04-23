package hu.ujszaszik.resumeapp.register.balloon

import com.skydoves.balloon.Balloon


fun Balloon.duration(time: Long): Balloon {
    return this
        .also { setOnBalloonInitializedListener { BalloonTimer.init(this, time).start() } }
}

fun Balloon.onCancelled(onCancelled: () -> Unit): Balloon {
    fun onCancel() {
        dismiss()
        onCancelled.invoke()
    }
    setOnBalloonClickListener { onCancel() }
    setOnBalloonDismissListener { onCancel() }
    setOnBalloonOutsideTouchListener { _, _ -> onCancel() }
    return this
}