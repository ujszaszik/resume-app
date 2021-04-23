package hu.ujszaszik.resumeapp.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LiveData<T>.observeNotNull(lifecycleOwner: LifecycleOwner, block: (T) -> Unit) {
    observe(lifecycleOwner) { value -> value?.let { block.invoke(it) } }
}