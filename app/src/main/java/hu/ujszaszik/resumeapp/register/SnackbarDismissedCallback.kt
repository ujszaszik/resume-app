package hu.ujszaszik.resumeapp.register

import com.google.android.material.snackbar.Snackbar

class SnackbarDismissedCallback(private val onDismissed: () -> Unit) : Snackbar.Callback() {

    override fun onDismissed(transientBottomBar: Snackbar?, event: Int) = onDismissed.invoke()

    override fun onShown(sb: Snackbar?) = super.onShown(sb)
}

fun Snackbar.whenDismissed(onDismissed: () -> Unit) =
    addCallback(SnackbarDismissedCallback(onDismissed))