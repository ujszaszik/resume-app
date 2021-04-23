package hu.ujszaszik.resumeapp.register

data class UserData(
    val email: String,
    val password: String
) {

    fun isValid(): Boolean = email.isNotEmpty() && password.isNotEmpty()
}