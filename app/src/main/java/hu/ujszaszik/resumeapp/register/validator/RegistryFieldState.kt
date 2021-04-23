package hu.ujszaszik.resumeapp.register.validator

import com.ujszaszik.resumeapp.R

interface ErrorWithMessage {
    val messageId: Int
}

sealed class RegistryFieldState {

    object Valid : RegistryFieldState()

    class Invalid(val message: String) : RegistryFieldState()

    class EmptyUsername(override val messageId: Int = R.string.register_error_empty_email) :
        RegistryFieldState(),
        ErrorWithMessage

    class InvalidUsername(override val messageId: Int = R.string.register_error_invalid_email) :
        RegistryFieldState(),
        ErrorWithMessage

    class EmptyPassword(override val messageId: Int = R.string.register_error_empty_password) :
        RegistryFieldState(),
        ErrorWithMessage

    class EmptyPasswordAgain(override val messageId: Int = R.string.register_error_empty_password_again) :
        RegistryFieldState(),
        ErrorWithMessage

    class PasswordsNotMatching(override val messageId: Int = R.string.register_error_passwords_not_match) :
        RegistryFieldState(),
        ErrorWithMessage

    class EmptyRole(override val messageId: Int = R.string.register_error_empty_role) :
        RegistryFieldState(),
        ErrorWithMessage
}