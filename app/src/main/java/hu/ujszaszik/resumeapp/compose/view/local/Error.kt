package hu.ujszaszik.resumeapp.compose.view.local

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

inline fun <reified T : Any> defaultCompositionLocal(): ProvidableCompositionLocal<T> =
    compositionLocalOf { error("Composition Local without value for class: ${T::class.simpleName}") }