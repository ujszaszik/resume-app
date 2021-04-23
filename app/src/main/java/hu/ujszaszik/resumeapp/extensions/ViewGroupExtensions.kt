package hu.ujszaszik.resumeapp.extensions

import android.view.View
import android.view.ViewGroup

fun ViewGroup.firstChild(): View = getChildAt(0)

fun ViewGroup.secondChild(): View = getChildAt(1)