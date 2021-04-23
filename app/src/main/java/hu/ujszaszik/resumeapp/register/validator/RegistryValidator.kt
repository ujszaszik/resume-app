package hu.ujszaszik.resumeapp.register.validator

import android.util.Patterns
import javax.inject.Inject

class RegistryValidator @Inject constructor() {

    fun validateEmail(email: String): RegistryFieldState {
        return if (email.isEmpty()) RegistryFieldState.EmptyUsername()
        else if (!isValidEmailAddress(email)) RegistryFieldState.InvalidUsername()
        else RegistryFieldState.Valid
    }

    private fun isValidEmailAddress(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validatePassword(password: String, again: Boolean = false): RegistryFieldState {
        return if (password.isEmpty()) getEmptyPasswordState(again)
        else RegistryFieldState.Valid
    }

    private fun getEmptyPasswordState(again: Boolean): RegistryFieldState {
        return if (again) RegistryFieldState.EmptyPasswordAgain()
        else RegistryFieldState.EmptyPassword()
    }

    fun validatePasswordMatch(password: String, passwordAgain: String): RegistryFieldState {
        return if (password == passwordAgain) RegistryFieldState.Valid
        else RegistryFieldState.PasswordsNotMatching()
    }

    fun validateRole(roleSelectionId: Int): RegistryFieldState {
        return when (roleSelectionId) {
            0 -> RegistryFieldState.EmptyRole()
            else -> RegistryFieldState.Valid
        }
    }
}