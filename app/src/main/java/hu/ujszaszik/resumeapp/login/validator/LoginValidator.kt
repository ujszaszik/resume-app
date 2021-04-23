package hu.ujszaszik.resumeapp.login.validator

import android.content.Context
import android.util.Patterns
import com.ujszaszik.resumeapp.R
import javax.inject.Inject

class LoginValidator @Inject constructor(private val context: Context) {

    fun validateEmail(email: String): LoginFieldState {
        return if (email.isEmpty()) LoginFieldState.Invalid(R.string.login_error_empty)
        else if (!isValidEmailAddress(email)) LoginFieldState.Invalid(R.string.login_error_invalid_email)
        else LoginFieldState.Valid
    }

    private fun isValidEmailAddress(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validatePassword(password: String): LoginFieldState {
        return if (password.isEmpty()) LoginFieldState.Invalid(R.string.login_error_empty)
        else LoginFieldState.Valid
    }
}