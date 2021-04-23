package hu.ujszaszik.resumeapp.resume.overview.model

class ContactDataOnClickListener(private val block: () -> Unit) {

    fun onClick() = block.invoke()
}