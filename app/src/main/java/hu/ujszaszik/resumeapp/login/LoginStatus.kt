package hu.ujszaszik.resumeapp.login

sealed class LoginStatus {

    object Success : LoginStatus()

    object NotValidated : LoginStatus()

    object Unavailable : LoginStatus()

    class DeletedUser(val email: String) : LoginStatus()

    class Failed(val count: Int) : LoginStatus()
}