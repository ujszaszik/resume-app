package hu.ujszaszik.resumeapp.extensions

sealed class AttemptResult {

    class Success<T>(val result: T) : AttemptResult()

    class Error(val throwable: Throwable) : AttemptResult()
}

fun <T> attempt(block: () -> T): AttemptResult {
    return try {
        val result = block.invoke()
        AttemptResult.Success(result)
    } catch (throwable: Throwable) {
        AttemptResult.Error(throwable)
    }
}

fun AttemptResult.onError(block: (Throwable) -> Unit) {
    if (this is AttemptResult.Error) block.invoke(this.throwable)
}