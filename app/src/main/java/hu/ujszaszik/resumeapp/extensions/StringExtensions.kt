package hu.ujszaszik.resumeapp.extensions

val String.asQuote: String
    get() = ",,$this\'\'"