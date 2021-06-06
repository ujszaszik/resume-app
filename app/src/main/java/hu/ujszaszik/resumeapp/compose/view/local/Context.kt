package hu.ujszaszik.resumeapp.compose.view.local

import android.content.Context
import androidx.compose.runtime.*

val LocalContext = defaultCompositionLocal<Context>()

@InternalComposeApi
@Composable
fun ContextProvided(
    context: Context,
    vararg values: ProvidedValue<*> = emptyArray(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalContext provides context, *values) {
        currentComposer.startProviders(values)
        content.invoke()
        currentComposer.endProviders()
    }
}