package hu.ujszaszik.resumeapp.extensions

fun Int.half(): Int = this / 2

fun zero(): Int = 0

fun Float.isZero(): Boolean = this == zero().toFloat()

fun <T : Any> Int.whenNotZero(block: (Int) -> T): T? {
    return if (this != 0) block.invoke(this)
    else null
}