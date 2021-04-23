package hu.ujszaszik.resumeapp.login.validator

sealed class LoginFieldState {

    object Valid : LoginFieldState()

    class Invalid(val messageId: Int) : LoginFieldState()
}
